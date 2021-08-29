package subway.controller.menu;

import subway.controller.Controller;
import subway.view.InputView;
import subway.view.message.MenuMessage;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuController implements Controller {
    protected final InputView inputView;
    protected final List<Controller> controllerList = new ArrayList<>();

    public MenuController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        System.out.println("menu controller run");
        printMenu();
        runNextContorller();
    }

    protected void runNextContorller() {
//        String select = inputView.userStringInput(MenuMessage.FUNCTION_SELECT);

//        String decision = inputView.inputFunction();
//        if (isExitDecision(decision)) {
//            return;
//        }
//        runChildController(decision);
        System.out.println("menu controller run next");
        String select = inputView.userStringInput(MenuMessage.FUNCTION_SELECT);
        runController(select);
    }

    protected void runController(String select) {
        controllerList.get(Integer.parseInt(select) - 1).run();
    }

    protected abstract void printMenu();
}
