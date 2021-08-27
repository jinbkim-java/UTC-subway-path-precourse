package subway;

import java.util.Scanner;

import subway.controller.menu.MainMenuController;
import subway.controller.menu.MenuController;
import subway.view.InputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final InputView inputView = new InputView(scanner);
        final MenuController mainMenuController = new MainMenuController(inputView);
    }
}
