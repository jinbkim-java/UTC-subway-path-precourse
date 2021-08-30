package subway.controller.menu;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.Message;

public class MainMenuController extends MenuController {

    public static boolean isRunning = true;

    public MainMenuController(InputView inputView) {
        super(inputView);
        controllerList.add(new OptionMenuController(inputView));
    }

    @Override
    protected void printMenu() {
        OutputView.printMenu(Message.MAIN_MENU);
    }

    @Override
    protected void runNextContorller() {
        String select = inputView.userStringInput(Message.SELECT_FUNCTION);
        if (select.equalsIgnoreCase(Message.USER_INPUT_QUIT)) {
            isRunning = false;
            return;
        }
        runController(select);
    }
}
