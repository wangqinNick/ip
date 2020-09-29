package seedu.duck.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import seedu.duck.data.TaskManager;
import seedu.duck.setting.SystemSetting;
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
import java.util.ArrayList;

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
     * Save the task list as a Json file into data folder
     *
     * @throws IOException io exceptions related to the path
     */
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
     * Create data folder at default path
     */
    private static void createDefaultDataFolder() {
        try {
            Files.createDirectory(PATH_TO_DATA_FOLDER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read the Json file from the data folder into the task list
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
            TaskManager.setTaskList(getDecodedTaskList(readList));
        }
    }

    /**
     * Return the task list read from Json file
     *
     * @param readList the task array read from Json file
     * @return the task list parsed from readList array
     */
    public static ArrayList<Task> getDecodedTaskList(Task[] readList) {
        ArrayList<Task> tempTaskList = new ArrayList<>();
        for (Task task : readList) {
            switch (task.getType()) {
            case 'T':
                tempTaskList.add(new TodoTask(task.getDescription(), task.getIsDone()));
                break;
            case 'D':
                if (task.getTaskDate()==null){
                    tempTaskList.add(new DeadlineTask(task.getDescription(), task.getTaskDateInString(), task.getIsDone()));
                }else {
                    tempTaskList.add(new DeadlineTask(task.getDescription(), task.getTaskDate(), task.getIsDone()));
                }
                break;
            case 'E':
                if (task.getTaskDate()==null){
                    tempTaskList.add(new EventTask(task.getDescription(), task.getTaskDateInString(), task.getIsDone()));
                }else {
                    tempTaskList.add(new EventTask(task.getDescription(), task.getTaskDate(), task.getIsDone()));
                }
                break;
            default:
            }
        }
        return tempTaskList;
    }

    public static void loadUserInfo() throws IOException {
        try {
            FileReader fileReader = new FileReader("data/save.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String rawUsername = bufferedReader.readLine();
            String rawPassword = bufferedReader.readLine();
            SystemSetting.setUsername(Decoder.decodeUsername(rawUsername));
            SystemSetting.setPassword(Decoder.decodePassword(rawPassword));
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            throw new IOException("User Info not found");
        }
    }

    public static void saveUserInfo() throws IOException{
        String encodedUserInfo = Encoder.encode(SystemSetting.getUsername(),
                                                SystemSetting.getPassword());
        try {
            File saveFile = new File("data/save.txt");
            saveFile.getParentFile().mkdirs();
            FileWriter fileWriter = new FileWriter(saveFile);
            fileWriter.write(encodedUserInfo);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new IOException("Save UserInfo failed");
        }
    }
}

