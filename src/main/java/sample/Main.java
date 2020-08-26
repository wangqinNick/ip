package sample;

import ui.TextUi;

public class Main {
    public static void main(String[] args) {
        TextUi.showLogo();
        new Main().run();     //quite dummy here, will change later
        TextUi.showFarewells();
    }

    private void run() {
        TextUi.showGreetings();
    }
}
