package subway.graph;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class TimeGraph {
    private static final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public static DijkstraShortestPath getShortestPath() {
        return new DijkstraShortestPath(timeGraph);
    }

    public static void addStationsWithTime(String firstStation, String secondStation, int time) {
        addStation(firstStation);
        addStation(secondStation);
        addTime(firstStation, secondStation, time);
    }

    private static void addStation(String stationName) {
        timeGraph.addVertex(stationName);
    }

    private static void addTime(String firstStation, String secondStation, int time) {
        final DefaultWeightedEdge newEdge = timeGraph.addEdge(firstStation, secondStation);
        timeGraph.setEdgeWeight(newEdge, time);
    }

    public static int totalTime(List<String> pathInformation) {
        int totalTime = 0;
        for (int currentStation = 1; currentStation < pathInformation.size(); currentStation++) {
            final DefaultWeightedEdge eachEdge = timeGraph.getEdge(pathInformation.get(currentStation - 1), pathInformation.get(currentStation));
            final int edgeWeight = (int) timeGraph.getEdgeWeight(eachEdge);
            totalTime += edgeWeight;
        }
        return totalTime;
    }
}
