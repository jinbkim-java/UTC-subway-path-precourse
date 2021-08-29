package subway.view;

import subway.view.message.MenuMessage;

import java.util.List;

public class OutputView {
    public static void printMainMenu() {
        printMenu(MenuMessage.MAIN_MENU);
    }

    public static void printOptionMenu() {
        printMenu(MenuMessage.OPTION_MENU);
    }

    private static void printMenu(List<String> menuOptions) {
        System.out.println();
        menuOptions.forEach(menu -> System.out.println(menu));
    }

}
