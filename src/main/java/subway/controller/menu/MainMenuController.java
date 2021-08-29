package subway.controller.menu;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.message.MenuMessage;

public class MainMenuController extends MenuController {
    public MainMenuController(InputView inputView){
        super(inputView);
        controllerList.add(new OptionMenuController(inputView));
    }

    @Override
    protected void printMenu() {
        OutputView.printMenu(MenuMessage.MAIN_MENU);
    }

    @Override
    protected void runNextContorller() {
        System.out.println("main menu controller run next");
        String select = inputView.userStringInput(MenuMessage.FUNCTION_SELECT);
        runController(select);
    }
}
