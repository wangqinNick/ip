package seedu.duck.data;

import seedu.duck.storage.IOManager;
import seedu.duck.task.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collectors;

/** The task manager*/
public class TaskManager {
    private static ArrayList<Task> taskList = new ArrayList<>();
    private static ArrayList<Task> filteredTaskList;

    /**
     * Initialises the TaskManager class.
     *
     * @param taskList
     *  The hash map containing NUS provided modules
     */
    public static void initialise(ArrayList<Task> taskList) {
        TaskManager.taskList = Objects.requireNonNullElseGet(taskList, ArrayList::new);
        filteredTaskList = new ArrayList<>();
    }

    public static void initialise() {
        TaskManager.initialise(null);
    }



    /**
     *  Set the entire Task List to a new list
     * @param assignedTaskList assigned taskList
     */
    public static void setTaskList(ArrayList<Task> assignedTaskList) {
        taskList = assignedTaskList;
    }

    /**
     *  Returns the entire Task List
     * @return
     *  The Task List
     */
    public static ArrayList<Task> getTaskList() {
        return taskList;
    }

    private static boolean contains(String description) {
        return taskList.stream().anyMatch(task -> task.isSameTask(description));
    }

    public static void add(Task toAdd) {
        if (contains(toAdd.getDescription())) {
            //throw new DuplicateTaskException();
            taskList.add(toAdd);
        } else {
            taskList.add(toAdd);
        }
    }

    public static int size(){
        return taskList.size();
    }

    public static void removeTask(Task toRemove){
        taskList.remove(toRemove);
    }


    public static ArrayList<Task> getFilteredTaskList() {
        return filteredTaskList;
    }

    /**
     * Search a key word int the whole list
     */
    public static ArrayList<Task> searchTask(String toSearch) {
        filteredTaskList = new ArrayList<>();
        filteredTaskList = (ArrayList<Task>)taskList.stream()
                .filter((s) -> s.getDescription().contains(toSearch))
                .collect(Collectors.toList());
        return filteredTaskList;
    }

    public static int getNextIndex(){
        return taskList.size();
    }
}