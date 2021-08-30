package subway.controller.path;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.graph.DistanceGraph;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class ShortestPathController extends PathController {
    public ShortestPathController(InputView inputView) {
        super(inputView);
    }

    @Override
    protected void calculatePath(String startingStation, String endingStation) {
        DijkstraShortestPath shortestPath = DistanceGraph.getShortestPath();
        List<String> pathInformation = shortestPath.getPath(startingStation, endingStation).getVertexList();

        OutputView.printInfo(pathInformation);
    }
}
