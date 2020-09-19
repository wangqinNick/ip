package seedu.duck.data;

import seedu.duck.task.Task;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

/** The task manager*/
public class TaskManager {
    private static ArrayList<Task> taskList = new ArrayList<>();
    private static ArrayList<Task> filteredTaskList;

    /**
     * Initialises the TaskManager class
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
     * Sets the entire Task List to a new list
     *
     * @param assignedTaskList assigned taskList
     */
    public static void setTaskList(ArrayList<Task> assignedTaskList) {
        taskList = assignedTaskList;
    }

    /**
     * Returns the entire Task List
     *
     * @return The Task List
     */
    public static ArrayList<Task> getTaskList() {
        return taskList;
    }

    /**
     * Returns true if the task is inside the system
     *
     * @param description the task description
     * @return true if the task is inside the system
     */
    private static boolean contains(String description) {
        return taskList.stream().anyMatch(task -> task.isSameTask(description));
    }

    /**
     * Adds a task into the system
     *
     * @param toAdd the task to add
     */
    public static void add(Task toAdd) {
        if (contains(toAdd.getDescription())) {
            //throw new DuplicateTaskException();
            taskList.add(toAdd);
        } else {
            taskList.add(toAdd);
        }
    }

    /**
     * Removes a task
     *
     * @param toRemove the task
     */
    public static void removeTask(Task toRemove){
        taskList.remove(toRemove);
    }

    /**
     * Returns a list of tasks contains the keywords
     * Search a key word int the whole list
     *
     * @param toSearch the keyword to search
     * @return a list of tasks contains the keywords
     */
    public static ArrayList<Task> searchTask(String toSearch) {
        filteredTaskList = new ArrayList<>();
        filteredTaskList = (ArrayList<Task>)taskList.stream()
                .filter((s) -> s.getDescription().contains(toSearch))
                .collect(Collectors.toList());
        return filteredTaskList;
    }

    /**
     * Returns the index of the next task
     *
     * @return the index of the next task
     */
    public static int getNextIndex(){
        return taskList.size();
    }
}
