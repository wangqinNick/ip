package ui;

import util.Message;

public class TextUi {

    public static void showGreetings() {
        printDivider();
        System.out.print(Message.MESSAGE_WELCOME);
    }

    public static void showFarewells() {
        printDivider();
        System.out.print(Message.MESSAGE_FAREWELL);
        printDivider();
    }

    public static void printDivider() {
        System.out.println(Message.DIVIDER);
    }
}

