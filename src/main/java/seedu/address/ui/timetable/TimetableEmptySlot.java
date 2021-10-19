package seedu.address.ui.timetable;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TimetableEmptySlot extends TimetableRegion {

    private static final String FXML = "timetable/TimetableEmptySlot.fxml";

    public TimetableEmptySlot(LocalTime startTime, LocalTime endTime) {
        super(FXML, startTime.until(endTime, ChronoUnit.MINUTES));
    }
}
