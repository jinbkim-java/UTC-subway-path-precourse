package subway.view;

import java.util.List;

public class OutputView {
    public static void printMenu(List<String> menuOptions) {
        System.out.println();
        menuOptions.forEach(menu -> System.out.println(menu));
    }
}
