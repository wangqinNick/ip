package seedu.duck.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import seedu.duck.exception.StorageOperationException;
import seedu.duck.data.TaskManager;
import seedu.duck.task.DeadlineTask;
import seedu.duck.task.EventTask;
import seedu.duck.task.Task;
import seedu.duck.task.TodoTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

import static seedu.duck.util.Constant.PATH_TO_DATA_FILE;
import static seedu.duck.util.Constant.PATH_TO_DATA_FOLDER;

public class IOManager {

    private static Path filePath;
    /**
     * Initialises the TaskManager class.
     *  The hash map containing NUS provided modules
     */
    public static void initialise() {
        filePath = PATH_TO_DATA_FILE;
    }

    /**
     * Parses user input into command for execution.
     *
     * @param filePath json file path
     * @return (boolean) if the filePath is valid, return true
     */
    private static boolean isValidPath(Path filePath) {
        return filePath.toString().endsWith(".json");
    }

    public static void saveAsJson() throws IOException {
        var gson = new GsonBuilder().create();
        if (Files.exists(PATH_TO_DATA_FOLDER)){
            FileWriter fw = new FileWriter(new File(filePath.toString()));
            var json = gson.toJson(TaskManager.getTaskList());
            fw.write(json);
            fw.flush();
            fw.close();
        } else {
            createDefaultDataFolder();
        }

    }

    /**
     * create data folder at default path
     */
    private static void createDefaultDataFolder() {
        try {
            Files.createDirectory(PATH_TO_DATA_FOLDER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * read the Json file in the data folder into the task list
     */
    public static void loadList()  {

        File file = new File(String.valueOf(filePath));
        if (file.exists()) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(String.valueOf(filePath)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            assert reader != null;
            Task[] readList = new Gson().fromJson(reader, Task[].class);
            for (Task task : readList) {
                switch (task.getType()) {
                case 'T':
                    TaskManager.getTaskList().add(new TodoTask(task.getDescription()));
                    break;
                case 'D':
                    if (task.getTaskDate()==null){
                        TaskManager.getTaskList().add(new DeadlineTask(task.getDescription(), task.getTaskDateInString()));
                    }else {
                        TaskManager.getTaskList().add(new DeadlineTask(task.getDescription(), task.getTaskDate()));
                    }
                    break;
                case 'E':
                    if (task.getTaskDate()==null){
                        TaskManager.getTaskList().add(new EventTask(task.getDescription(), task.getTaskDateInString()));
                    }else {
                        TaskManager.getTaskList().add(new EventTask(task.getDescription(), task.getTaskDate()));
                    }
                    break;
                default:
                }
            }
        }
    }
}

