package seedu.duck.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import seedu.duck.exception.StorageOperationException;
import seedu.duck.system.TaskManager;
import seedu.duck.util.Message;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOManager {

    /** Default file path used if the user doesn't provide the file name. */
    //private static String jsonFilePath = Message.JSON_FILE_PATH;
    private static Path filePath;

    /**
     * default constructor (if the user does not specified file location
     */
    public IOManager() throws StorageOperationException {
        this(Message.JSON_FILE_PATH);
        filePath = Paths.get(Message.JSON_FILE_PATH);
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
            throw new StorageOperationException("Storage file should end with '.txt'");
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
        Gson gson = new GsonBuilder().create();
        FileWriter fw = new FileWriter(Message.JSON_FILE_PATH);
        String json = gson.toJson(TaskManager.getTaskList());
        fw.write(json);
        fw.flush();
        fw.close();
    }
}
