import command.Command;
import command.CommandResult;
import command.ExitCommand;
import parser.Parser;
import system.TaskManager;
import ui.TextUi;
import java.util.Scanner;


public class Duck {
    private CommandResult commandResult;
    private TaskManager taskManager;

    /**
     * constructor of duck.
     */
    public Duck() {
        taskManager = new TaskManager();
    }

    public static void main(String[] args) {
        new Duck().run();
        TextUi.showFarewells();
    }

    private void run() {
        welcomeUser();
        runCommandLoopUntilExitCommand();
    }

    /**
     * Method to print the welcome message to the user.
     */
    public void welcomeUser() {
        TextUi.clearScreen();
        //TextUi.showLogo();
        TextUi.showGreetings();
    }

    private void runCommandLoopUntilExitCommand() {
        Command command;
        String userCommandText;
        Scanner scanner = new Scanner(System.in);
        do {
            userCommandText = scanner.nextLine();
            command = new Parser().parseCommand(taskManager, userCommandText);
            executeCommand(command);
        } while (!ExitCommand.isExit(command));
    }

    private CommandResult executeCommand(Command command) {
        try {
            // supplies the data the command will operate on.
            // if there is no file to load or the file is empty, setData will initialize a new taskManager system
            command.setData(taskManager);
            // Execute according to the command itself
            commandResult = command.execute();
        } catch (Exception ex) {
            // the out layer exception handler
            System.out.println(ex);
        }
        return commandResult;
    }
}
