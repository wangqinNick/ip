package seedu.duck.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Constant {
    public static final String DEFAULT_DIALOG_COLOR = "#9ED49E";
    public static final String WARNING_DIALOG_COLOR = "#e07b39";
    public static final String INFORMATIVE_DIALOG_COLOR = "#A27C2C";
    public static final String DEFAULT_DIALOG_BORDER_COLOR = "#4141B2";
    public static final String DEFAULT_DIALOG_FONT = "Comic Sans MS";
    public static final int DEFAULT_DIALOG_SIZE = 14;
    public static final String DEFAULT_TASK_TIME = "-1";
    public static final String DEFAULT_USERNAME = "duck";
    public static final String DEFAULT_PASSWORD = "123";
    public static final String NEWLINE = "\n";
    public static final int INDEX_OFF_SET = -1;
    public static final int LIST_INDEX_OFFSET = 1;
    public static final String PROJECT_ROOT = System.getProperty("user.dir");
    public static final String DATA_FOLDER = "data";
    public static final String DATA_FILE = "duke.json";
    public static final Path PATH_TO_DATA_FOLDER = Paths.get(PROJECT_ROOT, DATA_FOLDER);
    public static final Path PATH_TO_DATA_FILE = Paths.get(PROJECT_ROOT, DATA_FOLDER, DATA_FILE);
}
