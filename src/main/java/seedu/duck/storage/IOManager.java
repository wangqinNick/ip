package seedu.duck.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import seedu.duck.exception.StorageOperationException;
import seedu.duck.system.TaskManager;
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

import static seedu.duck.util.Constant.PATH_TO_DATA_FILE;
import static seedu.duck.util.Constant.PATH_TO_DATA_FOLDER;

public class IOManager {

    /** Default file path used if the user doesn't provide the file name. */
    //private static String jsonFilePath = Message.JSON_FILE_PATH;
    private static Path filePath;

    /**
     * default constructor (if the user does not specified file location
     */
    public IOManager() throws StorageOperationException {
        this(PATH_TO_DATA_FILE.toString());
        filePath = Paths.get(PATH_TO_DATA_FILE.toString());
    }

    /**
     * Parses user input into command for execution.
     *
     * @param filePath filePath to write
     * @throws StorageOperationException IO exception
     * @return parsed storage file object
     */
    public IOManager(String filePath) throws StorageOperationException {
        IOManager.filePath = Paths.get(filePath);
        if (!isValidPath(IOManager.filePath)) {
            throw new StorageOperationException("Storage file should end with '.json'");
        }
    }

    /**
     * Parses user input into command for execution.
     *
     * @param filePath json file path
     * @return (boolean) if the filePath is valid, return true
     */
    private static boolean isValidPath(Path filePath) {
        return filePath.toString().endsWith(".txt");
    }

    public static void saveAsJson() throws IOException {
        var gson = new GsonBuilder().create();
        if (Files.exists(PATH_TO_DATA_FOLDER)){
            FileWriter fw = new FileWriter(new File(PATH_TO_DATA_FILE.toString()));
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
     * @param taskList the task list to receive information
     */
    public static void readDom(ArrayList<Task> taskList)  {

        File file = new File(String.valueOf(PATH_TO_DATA_FILE));
        if (file.exists()) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(String.valueOf(PATH_TO_DATA_FILE)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            assert reader != null;
            Task[] readList = new Gson().fromJson(reader, Task[].class);
            for (Task task : readList) {
                switch (task.getType()) {
                case 'T':
                    taskList.add(
                            new TodoTask(task.getDescription()));
                    break;
                case 'D':
                    if (task.getTaskDate()==null){
                        taskList.add(new DeadlineTask(task.getDescription(), task.getTaskDateInString()));
                    }else {
                        taskList.add(new DeadlineTask(task.getDescription(), task.getTaskDate()));
                    }
                    break;
                case 'E':
                    if (task.getTaskDate()==null){
                        taskList.add(new EventTask(task.getDescription(), task.getTaskDateInString()));
                    }else {
                        taskList.add(new EventTask(task.getDescription(), task.getTaskDate()));
                    }
                    break;
                default:
                }
            }
        }
    }
}

