package seedu.duck.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import seedu.duck.storage.IOManager;
import seedu.duck.task.Task;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class StateManager {
    private static Stack<State> undoStack = new Stack<>();
    private static Stack<State> redoStack = new Stack<>();

    /**
     * Initialises the screen shot manager with its first screen shot of the starting list.
     */
    public static void initialise() {
        var gson = new GsonBuilder().create();
        String encodedSavedList = gson.toJson(TaskManager.getTaskList());
        State screenShot = new State(encodedSavedList);
        assert undoStack.isEmpty() : "Undo stack should be empty!";
        assert redoStack.isEmpty() : "Redo stack should be empty!";
        undoStack.push(screenShot);
    }

    private static State popPreviousScreenShot() throws EmptyStackException {
        // There should be at least 2 screen shots to allow undo
        if (undoStack.size() < 2) {
            throw new EmptyStackException();
        }
        State currentState = undoStack.pop();
        redoStack.push(currentState);
        return undoStack.peek();
    }

    private static State peekPreviousScreenShot() {
        return undoStack.peek();
    }

    /**
     * Revert to the previous changed state of the list.
     *
     * @throws IOException exception is thrown when error occurred during IO operation.
     * @throws EmptyStackException exception is thrown when user trying to undo at the initial state.
     */
    public static void undo() throws IOException, EmptyStackException {
        State previousState = popPreviousScreenShot();
        String encodedSavedList = previousState.getEncodedSavedList();
        InputStream stream = new ByteArrayInputStream(encodedSavedList.getBytes());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
        Task[] readList = new Gson().fromJson(bufferedReader, Task[].class);
        TaskManager.setTaskList(IOManager.getDecodedTaskList(readList));
        bufferedReader.close();
    }

    /**
     * Save the moduleList as a string if it was changed.
     */
    public static void saveState() {
        var gson = new GsonBuilder().create();
        String encodedSavedList = gson.toJson(TaskManager.getTaskList());
        State screenShot = new State(encodedSavedList);
        if (getUndoStackSize() == 0) {
            undoStack.push(screenShot);
            return;
        }
        State previousScreenShot = peekPreviousScreenShot();
        String previousEncodedSavedList = previousScreenShot.getEncodedSavedList();
        if (!previousEncodedSavedList.equals(encodedSavedList)) {
            undoStack.push(screenShot);
            if (!redoStack.isEmpty()) {
                redoStack.clear();
            }
        }
    }

    private static int getUndoStackSize() {
        return undoStack.size();
    }
}
