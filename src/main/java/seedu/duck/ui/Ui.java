package seedu.duck.ui;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ui {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String getUserInput() throws NoSuchElementException {
        return SCANNER.nextLine();
    }
}
