package subway.controller.path;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.graph.TimeGraph;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class ShortestTimeController extends PathController{
    public ShortestTimeController(InputView inputView) {
        super(inputView);
    }

    protected void calculatePath(String startingStation, String endingStation) {
        DijkstraShortestPath shortestTime = TimeGraph.getShortestPath();
        List<String> pathInformation = shortestTime.getPath(startingStation, endingStation).getVertexList();

        OutputView.printInfo(pathInformation);
    }
}
