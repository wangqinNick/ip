package seedu.duck;

import javafx.application.Application;

/**
 * A launcher class to workaround classpath issues.
 */
public class Launcher {
    /**
     * Launches the Nuke Application.
     *
     * @param args
     *  Standard arguments for running
     */
    public static void main(String[] args) {
        Application.launch(Duck.class, args);
    }
}
