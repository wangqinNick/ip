package seedu.duck.system;

import seedu.duck.task.Task;

import java.util.ArrayList;

public class TaskManager {
    private static ArrayList<Task> taskList;
    /**
     *  Initiates an empty Task list
     */
    public TaskManager() {
        taskList = new ArrayList<>();
    }

    /**
     *  Set the entire Task List to a new list
     * @param taskList
     */
    public static void setTaskList(ArrayList<Task> taskList) {
        taskList = taskList;
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
        for (Task task : taskList) {
            if (task.isSameTask(description)) {
                return true;
            }
        }
        return false;
    }

    public static void add(Task toAdd) {
        if (contains(toAdd.getDescription())) {
            //throw new DuplicateTaskException();
        } else {
            taskList.add(toAdd);
        }
    }

    public static int size(){
        return taskList.size();
    }

    public static Task get(int index){
        return taskList.get(index);
    }
}
