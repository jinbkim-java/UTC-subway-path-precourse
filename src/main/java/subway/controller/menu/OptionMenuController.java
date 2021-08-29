package subway.controller.menu;

import subway.controller.path.ShortestPathController;
import subway.controller.path.ShortestTimeController;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.message.MenuMessage;

public class OptionMenuController extends MenuController{
    public OptionMenuController(InputView inputView) {
        super(inputView);
        controllerList.add(new ShortestPathController(inputView));
        controllerList.add(new ShortestTimeController(inputView));
    }

    @Override
    protected void printMenu()  {
        OutputView.printOptionMenu();
    }
}
