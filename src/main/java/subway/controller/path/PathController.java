package subway.controller.path;

import subway.controller.Controller;
import subway.view.InputView;
import subway.view.Message;

public abstract class PathController implements Controller {
    public final InputView inputView;

    public PathController(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public void run() {
        String startingStation = inputView.userStringInput(Message.SELECT_STARTING_STATION);
        String endingStation = inputView.userStringInput(Message.SELECT_ENDING_STATION);

        calculatePath(startingStation, endingStation);
    }

    protected abstract void calculatePath(String startingStation, String endingStation);

}
