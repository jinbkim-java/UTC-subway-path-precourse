package subway.controller.menu;

import subway.controller.path.ShortestPathController;
import subway.controller.path.ShortestTimeController;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.Message;

public class OptionMenuController extends MenuController {
    public OptionMenuController(InputView inputView) {
        super(inputView);
        controllerList.add(new ShortestPathController(inputView));
        controllerList.add(new ShortestTimeController(inputView));
    }

    @Override
    protected void printMenu() {
        OutputView.printMenu(Message.OPTION_MENU);
    }

    @Override
    protected void runNextContorller() {
        String select = inputView.userStringInput(Message.SELECT_FUNCTION);
        if (select.equalsIgnoreCase(Message.USER_INPUT_BACK))
            return;
        runController(select);
    }
}
