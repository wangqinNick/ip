package sample;

import command.Command;
import ui.TextUi;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        new Main().run();     //quite dummy here, will change later
        TextUi.showFarewells();
    }

    private void run() {
        TextUi.showGreetings();
        runCommandLoopUntilExitCommand();
    }

    private void runCommandLoopUntilExitCommand() {
        Command command;
        String userCommandText;
        Scanner scanner = new Scanner(System.in);
        do {
            userCommandText = scanner.nextLine();
            echo(userCommandText);
        } while (!userCommandText.equals("bye"));
    }

    public static void echo(String userCommandText) {
        System.out.println(userCommandText);
        TextUi.printDivider();
    }
}
