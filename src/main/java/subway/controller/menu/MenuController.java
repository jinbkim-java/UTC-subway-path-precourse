package subway.controller.menu;

import subway.controller.Controller;
import subway.utils.Validate;
import subway.view.InputView;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuController implements Controller {
    protected final InputView inputView;
    protected final List<Controller> controllerList = new ArrayList<>();

    public MenuController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        try {
            printMenu();
            runNextContorller();
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println(e.getMessage());
            run();
        }
    }

    protected void runController(String select) {
        validate(select);
        controllerList.get(Integer.parseInt(select) - 1).run();
    }

    private void validate(String select) {
        Validate.validateNumeric(select);
        Validate.validateRange(select, controllerList.size());
    }

    protected abstract void printMenu();

    protected abstract void runNextContorller();
}
