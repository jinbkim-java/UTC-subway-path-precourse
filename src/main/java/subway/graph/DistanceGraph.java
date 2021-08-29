package subway.graph;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class DistanceGraph {
    private static final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph
            = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public static DijkstraShortestPath getShortestPath() {
        return new DijkstraShortestPath(distanceGraph);
    }

    public static void addStationsWithDistance(String firstStation, String secondStation, int distance) {
        addStation(firstStation);
        addStation(secondStation);
        addDistance(firstStation, secondStation, distance);
    }

    private static void addStation(String stationName) {
        distanceGraph.addVertex(stationName);
    }

    private static void addDistance(String firstStation, String secondStation, int distance) {
        final DefaultWeightedEdge newEdge = distanceGraph.addEdge(firstStation, secondStation);
        distanceGraph.setEdgeWeight(newEdge, distance);
    }

    public static int totalDistance(List<String> pathInformation) {
        int totalDistance = 0;
        for (int currentStation = 1; currentStation < pathInformation.size(); currentStation++) {
            final DefaultWeightedEdge eachEdge = distanceGraph.getEdge(pathInformation.get(currentStation-1), pathInformation.get(currentStation));
            final int edgeWeight = (int)distanceGraph.getEdgeWeight(eachEdge);
            totalDistance += edgeWeight;
            System.out.println("edgeWeight : " + edgeWeight);
        }
        return totalDistance;
    }
}
