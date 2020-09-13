package seedu.duck.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Constant {
    public static final String PROJECT_ROOT = System.getProperty("user.dir");
    public static final String DATA_FOLDER = "data";
    public static final String DATA_FILE = "duke.json";
    public static final Path PATH_TO_DATA_FOLDER = Paths.get(PROJECT_ROOT, DATA_FOLDER);
    public static final Path PATH_TO_DATA_FILE = Paths.get(PROJECT_ROOT, DATA_FOLDER, DATA_FILE);
}
