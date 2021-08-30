package subway.controller.path;

import subway.controller.Controller;
import subway.utils.Validate;
import subway.view.InputView;
import subway.view.Message;
import subway.view.OutputView;

public abstract class PathController implements Controller {
    public final InputView inputView;

    public PathController(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public void run() {
        try {
            String startingStation = inputView.userStringInput(Message.SELECT_STARTING_STATION);
            String endingStation = inputView.userStringInput(Message.SELECT_ENDING_STATION);
            validate(startingStation, endingStation);
            calculatePath(startingStation, endingStation);
        }
        catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    private void validate(String startingStation, String endingStation) {
        Validate.validateExistStation(startingStation);
        Validate.validateExistStation(endingStation);
        Validate.validateOverlapStation(startingStation, endingStation);
    }

    protected abstract void calculatePath(String startingStation, String endingStation);
}
