package seedu.duck;

import javafx.application.Application;

public class Duck {


    /**
     * The main entry point to the application.
     *
     * This is a workaround for the following error when MainApp is made the
     * entry point of the application:
     *
     *     Error: JavaFX runtime components are missing, and are required to run this application
     */
    public static void main(String[] args) {
        Application.launch(DuckApp.class, args);
    }
}
