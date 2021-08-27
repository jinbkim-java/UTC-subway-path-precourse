package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.graph.DistanceGraph;
import subway.graph.TimeGraph;

import java.util.Arrays;
import java.util.List;

public class DummySetup {
    private static final List<String> dummyStationNames = Arrays.asList(
            "교대역",
            "강남역",
            "역삼역",
            "남부터미널역",
            "양재역",
            "양재시민의숲역",
            "매봉역"
    );

    private static final List<String> dummyLineNames = Arrays.asList(
            "2호선",
            "3호선",
            "신분당선"
    );

    public static void initialize() {
        initializeStations();
        initializeLines();
        connectStationsAndLine();
    }

    private static void initializeStations() {
        dummyStationNames.stream()
                .map(stationName -> new Station(stationName))
                .forEach(station -> StationRepository.addStation(station));
    }

    private static void initializeLines() {
        dummyLineNames.stream()
                .map(lineName -> new Line(lineName))
                .forEach(line -> LineRepository.addLine(line));
    }

    private static void connectStationsAndLine() {
        connectSecondLine();
        connectThirdLine();
        connectNewBundangLine();
    }

    private static void connectSecondLine() {
        Line secondLine = LineRepository.getLine("2호선");
        secondLine.addStation(StationRepository.getStation("교대역"));
        secondLine.addStation(StationRepository.getStation("강남역"));
        secondLine.addStation(StationRepository.getStation("역삼역"));

        addDistanceAndTimeSecondLine();
    }

    private static void connectThirdLine() {
        Line thirdLine = LineRepository.getLine("3호선");
        thirdLine.addStation(StationRepository.getStation("교대역"));
        thirdLine.addStation(StationRepository.getStation("남부터미널역"));
        thirdLine.addStation(StationRepository.getStation("양재역"));
        thirdLine.addStation(StationRepository.getStation("매봉역"));

        addDistanceAndTimeThirdLine();
    }

    private static void connectNewBundangLine() {
        Line newBundangLine = LineRepository.getLine("신분당선");
        newBundangLine.addStation(StationRepository.getStation("강남역"));
        newBundangLine.addStation(StationRepository.getStation("양재역"));
        newBundangLine.addStation(StationRepository.getStation("양재시민의숲역"));

        addDistanceAndTimeNewBundangLine();
    }

    private static void addDistanceAndTimeSecondLine() {
        DistanceGraph.addStationsWithDistance("교대역", "강남역", 2);
        TimeGraph.addStationsWithTime("교대역", "강남역", 3);

        DistanceGraph.addStationsWithDistance("강남역", "역삼역", 2);
        TimeGraph.addStationsWithTime("강남역", "역삼역", 3);
    }

    private static void addDistanceAndTimeThirdLine() {
        DistanceGraph.addStationsWithDistance("교대역", "남부터미널역", 3);
        TimeGraph.addStationsWithTime("교대역", "남부터미널역", 2);

        DistanceGraph.addStationsWithDistance("남부터미널역", "양재역", 6);
        TimeGraph.addStationsWithTime("남부터미널역", "양재역", 5);

        DistanceGraph.addStationsWithDistance("양재역", "매봉역", 1);
        TimeGraph.addStationsWithTime("양재역", "매봉역", 1);
    }

    private static void addDistanceAndTimeNewBundangLine() {
        DistanceGraph.addStationsWithDistance("강남역", "양재역", 2);
        TimeGraph.addStationsWithTime("강남역", "양재역", 8);

        DistanceGraph.addStationsWithDistance("양재역", "양재시민의숲역", 10);
        TimeGraph.addStationsWithTime("양재역", "양재시민의숲역", 3);
    }
}
