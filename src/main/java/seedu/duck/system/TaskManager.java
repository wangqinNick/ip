package seedu.duck.system;

import seedu.duck.task.Task;
import java.util.ArrayList;
import java.util.stream.Stream;

public class TaskManager {
    private static ArrayList<Task> taskList;
    //private static Stream<Task> taskStream = taskList.stream();
    /**
     *  Initiates an empty Task list
     */
    public TaskManager() {
        taskList = new ArrayList<>();
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

    public static void removeTask(int index){
        taskList.remove(index);
    }
}
