package subway.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) { this.scanner = scanner; }

    public String userStringInput(String userInput){
        System.out.println();
        System.out.println(userInput);
        return scanner.nextLine();
    }
}
