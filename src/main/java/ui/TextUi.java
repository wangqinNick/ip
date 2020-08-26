package ui;

import util.Message;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

public class TextUi {

    public static final Ansi.Color SYSTEM_COLOR_MESSAGE = BLUE;
    public static final Ansi.Color SYSTEM_COLOR_RESPONSE = GREEN;
    public static final Ansi.Color SYSTEM_COLOR_DIVIDER = BLACK;
    public static final Ansi.Color SYSTEM_COLOR_LOGO = MAGENTA;
    public static final Ansi.Color SYSTEM_COLOR_ALERT = RED;

    public static void showLogo() {
        AnsiConsole.systemInstall();
        ansi().reset();
        System.out.print(ansi().bold().fg(SYSTEM_COLOR_LOGO).a(Message.LOGO).reset());
        printDivider();
        AnsiConsole.systemUninstall();
    }

    public static void showGreetings() {
        AnsiConsole.systemInstall();
        printDivider();
        System.out.print(String.format(Message.respondFormat,
                ansi().bold().fg(SYSTEM_COLOR_MESSAGE).a(Message.MESSAGE_WELCOME_1).reset()) );
        System.out.print(String.format(Message.respondFormat,
                ansi().bold().fg(SYSTEM_COLOR_MESSAGE).a(Message.MESSAGE_WELCOME_2).reset()) );
        printDivider();
        AnsiConsole.systemUninstall();
    }

    public static void showFarewells() {
        AnsiConsole.systemInstall();
        printDivider();
        System.out.println( ansi().fg(SYSTEM_COLOR_MESSAGE).a(Message.MESSAGE_FAREWELL).reset() );
        printDivider();
        AnsiConsole.systemUninstall();
    }

    //echo function, display user's input
    public static void showResult(String text) {
        //printDivider();
        printMessage(CYAN, text);
        printDivider();
    }

    public static void printMessage(Ansi.Color color, String message){
        AnsiConsole.systemInstall();
        ansi().reset();
        System.out.print(String.format(Message.respondFormat,
                ansi().bold().fg(color).a(message).reset()));
        AnsiConsole.systemUninstall();
    }

    public static void printDivider() {
        AnsiConsole.systemInstall();
        System.out.println( ansi().bold().fg(SYSTEM_COLOR_DIVIDER).a(Message.DIVIDER).reset() );
        AnsiConsole.systemUninstall();
    }
}

