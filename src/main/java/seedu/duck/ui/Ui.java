package seedu.duck.ui;

import java.util.Scanner;

public class Ui {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String getUserInput() {
        if (SCANNER.hasNextLine()){
            return SCANNER.nextLine();
        } else {
            return null;
        }
    }
}
