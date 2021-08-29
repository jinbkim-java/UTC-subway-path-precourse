package subway.view;

import subway.graph.DistanceGraph;
import subway.graph.TimeGraph;

import java.util.List;

public class OutputView {
    public static void printMenu(List<String> menuOptions) {
        System.out.println();
        menuOptions.forEach(menu -> System.out.println(menu));
    }

    public static void printInfo(List<String> pathInformation) {
        System.out.println();
        System.out.println(Message.INFO_RESULT);
        System.out.println(Message.INFO_DIVIDER);
        System.out.printf(Message.INFO_TOTAL_DISTANCE, DistanceGraph.totalDistance(pathInformation));
        System.out.printf(Message.INFO_TOTAL_TIME, TimeGraph.totalTime(pathInformation));
        System.out.println(Message.INFO_DIVIDER);

        pathInformation.forEach(
                station -> System.out.println(Message.INFO_LABEL + station)
        );
    }
}
