package subway.view;

import java.util.Arrays;
import java.util.List;

public class Message {
    public static final String MAIN_LABEL = "## 메인 화면";
    public static final String MAIN_SEEK_PATH = "1. 경로 조회";
    public static final String MAIN_QUIT = "Q. 종료";

    public static final String SELECT_FUNCTION = "## 원하는 기능을 선택하세요.";
    public static final String SELECT_STARTING_STATION = "## 출발역을 입력하세요.";
    public static final String SELECT_ENDING_STATION = "## 도착역을 입력하세요.";

    public static final String OPTION_LABEL = "## 경로 기준";
    public static final String OPTION_SHORTEST_PATH = "1. 최단 거리";
    public static final String OPTION_SHORTEST_TIME = "2. 최소 시간";
    public static final String OPTION_QUIT = "B. 돌아가기";

    private static final String ERROR_LABEL = "[ERROR] ";
    public static final String ERROR_STATION_NONE = ERROR_LABEL + "존재하지 않은 역 입니다.";
    public static final String ERROR_LINE_NONE = ERROR_LABEL + "존재하지 않은 호선 입니다.";

    public static final String INFO_RESULT = "## 조회 결과";
    public static final String INFO_LABEL = "[INFO] ";
    public static final String INFO_DIVIDER = INFO_LABEL + "---";
    public static final String INFO_TOTAL_DISTANCE = INFO_LABEL + "총 거리: %dkm\n";
    public static final String INFO_TOTAL_TIME = INFO_LABEL + "총 시간: %d분\n";

    public static final List<String> MAIN_MENU = Arrays.asList(
            MAIN_LABEL,
            MAIN_SEEK_PATH,
            MAIN_QUIT
    );

    public static final List<String> OPTION_MENU = Arrays.asList(
            OPTION_LABEL,
            OPTION_SHORTEST_PATH,
            OPTION_SHORTEST_TIME,
            OPTION_QUIT
    );
}
