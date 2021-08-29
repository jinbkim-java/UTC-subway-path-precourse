package subway.controller.path;

import subway.controller.Controller;
import subway.view.InputView;
import subway.view.message.MenuMessage;

public abstract class PathController implements Controller {

    public final InputView inputView;

    public PathController(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public void run() {
        System.out.println("path controller");

        String startingStation = inputView.userStringInput(MenuMessage.STARTING_STATION_SELECT);
        String endingStation = inputView.userStringInput(MenuMessage.ENDING_STATION_SELECT);

        calculatePath(startingStation, endingStation);
    }

    protected abstract void calculatePath(String startingStation, String endingStation);

}
