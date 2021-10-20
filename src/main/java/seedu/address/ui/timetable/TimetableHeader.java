package seedu.address.ui.timetable;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.time.LocalTime;

public class TimetableHeader extends TimetableRegion {

    private static final String FXML = "timetable/TimetableHeader.fxml";

    private static final int TIMETABLE_HEADER_SLOT_LENGTH = 60;

    @FXML
    private Label headerTime;

    public TimetableHeader(LocalTime headerStartTime, LocalTime headerEndTime) {
        super(FXML, TIMETABLE_HEADER_SLOT_LENGTH);
        String headerTime = headerStartTime.toString() + "-" + headerEndTime.toString();
        this.headerTime.setText(headerTime);
    }

    public TimetableHeader(String headerTime, int width) {
        super(FXML, width);
        this.headerTime.setText(headerTime);
    }

}
