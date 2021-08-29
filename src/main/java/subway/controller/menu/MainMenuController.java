package subway.controller.menu;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.Message;

public class MainMenuController extends MenuController {
    public MainMenuController(InputView inputView){
        super(inputView);
        controllerList.add(new OptionMenuController(inputView));
    }

    @Override
    protected void printMenu() {
        OutputView.printMenu(Message.MAIN_MENU);
    }

    @Override
    protected void runNextContorller() {
        System.out.println("main menu controller run next");
        String select = inputView.userStringInput(Message.SELECT_FUNCTION);
        runController(select);
    }
}
