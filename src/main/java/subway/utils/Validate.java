package subway.utils;

import subway.domain.StationRepository;
import subway.view.Message;

public class Validate {
    public static void validateNumeric(String select) {
        try {
            Integer.parseInt(select);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_WRONG);
        }
    }

    public static void validateRange(String select, int maxSize) {
        if (outOfRange(Integer.parseInt(select), 1, maxSize))
            throw new IllegalArgumentException(Message.ERROR_INPUT_WRONG);
    }

    public static void validateExistStation(String station) {
        if (!StationRepository.isExistStation(station))
            throw new IllegalArgumentException(Message.ERROR_STATION_NONE);
    }

    public static void validateOverlapStation(String startingStation, String endingStation) {
        if (startingStation.equals(endingStation))
            throw new IllegalArgumentException(Message.ERROR_STAION_OVERLAP);
    }

    private static boolean outOfRange(int select, int minValue, int maxValue) {
        if (select >= minValue && select <= maxValue)
            return false;
        return true;
    }
}
