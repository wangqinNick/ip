package seedu.duck.util;

import java.io.File;

public class Message {

    public static final String DUCK_LOGIN = "Duck login";
    public static final String INCORRECT_USER_OR_PW = "Incorrect user or pw.";
    public static final String WELCOME_TEXT = "Welcome to Duck System";
    public static final char DONE = '✓';
    public static final char NOT_DONE = '✕';
    public static final String MESSAGE_EMPTY_LIST_IN_ENGLISH = "There is no task in the list!";
    public static final String MESSAGE_EMPTY_LIST_IN_CHINESE = "程序中没有任务!";
    public static final String MESSAGE_LIST_RESPOND_FORMAT = "%s";
    public static final String MESSAGE_TODO_LIST = "%d. [%c][%c] %s";
    public static final String MESSAGE_EVENT_LIST = "%d. %s";
    public static final String MESSAGE_TODO_SUCCESS_IN_ENGLISH = "Got it. I've added this task: [ID:%d][%c][%c] %s";
    public static final String MESSAGE_TODO_SUCCESS_IN_CHINESE = "添加成功。 已添加: [ID:%d][%c][%c] %s";

    public static final String MESSAGE_DEADLINE_SUCCESS_IN_ENGLISH = "Got it. I've added this task: [ID:%d][%c][%c] %s (%s)";
    public static final String MESSAGE_DEADLINE_SUCCESS_IN_CHINESE = "添加成功。 已添加: [ID:%d][%c][%c] %s (%s)";

    public static final String MESSAGE_DEADLINE_LIST = "%d. %s";
    public static final String MESSAGE_EVENT_SUCCESS_IN_ENGLISH = "Got it. I've added this task: [ID:%d][%c][%c] %s (%s)";
    public static final String MESSAGE_EVENT_SUCCESS_IN_CHINESE = "添加成功。 已添加: [ID:%d][%c][%c] %s (%s)";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT_IN_ENGLISH = "Invalid command format!";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT_IN_CHINESE = "无效命令!";
    public static final String MESSAGE_INVALID_TASK_DISPLAYED_INDEX_IN_ENGLISH = "The task index provided is invalid";
    public static final String MESSAGE_INVALID_TASK_DISPLAYED_INDEX_IN_CHINESE = "输入的任务序号无效";
    public static final String JSON_FILE_PATH = "src"+ File.pathSeparator+"main"+File.pathSeparator+"data"+File.pathSeparator+"taskManager.json";
    public static final String MESSAGE_FILE_OPERATION_IO_ERROR_IN_ENGLISH = "Error writing to file: %s";
    public static final String MESSAGE_FILE_OPERATION_IO_ERROR_IN_CHINESE = "无法写入目标文件: %s";
    public static final String MESSAGE_UNDO_SUCCESS_IN_ENGLISH = "Undo successfully!";
    public static final String MESSAGE_UNDO_UNSUCCESSFUL_IN_ENGLISH = "Sorry, there was an IO error when undoing the state.";
    public static final String MESSAGE_UNDO_AT_BEGINNING_IN_ENGLISH = "You are already at the initial state!";
    public static final String MESSAGE_UNDO_SUCCESS_IN_CHINESE = "撤销成功!";
    public static final String MESSAGE_UNDO_UNSUCCESSFUL_IN_CHINESE = "对不起，文件系统已损坏，撤销失败";
    public static final String MESSAGE_UNDO_AT_BEGINNING_IN_CHINESE = "无法完成撤销：你已经在最初态";
    public static final String MESSAGE_CLEAR_SUCCESS_IN_ENGLISH = "The system has been cleared!";
    public static final String MESSAGE_CLEAR_SUCCESS_IN_CHINESE = "所有任务都已被删除!";
    public static final String MESSAGE_INVALID_DATE_IN_ENGLISH = "Invalid date!";
    public static final String MESSAGE_INVALID_DATE_IN_CHINESE = "无效日期!";

    public static final String MESSAGE_INVALID_COMMAND_IN_ENGLISH = "Invalid Command";
    public static final String MESSAGE_INVALID_COMMAND_IN_CHINESE = "无效指令";

}
