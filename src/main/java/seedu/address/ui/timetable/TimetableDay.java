package seedu.address.ui.timetable;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TimetableDay extends TimetableRegion {

    private static final String FXML = "timetable/TimetableDay.fxml";

    @FXML
    private Label day;

    private static final int WIDTH = 50;

    public TimetableDay(String dayStr) {
        super(FXML, WIDTH);
        day.setText(dayStr);
    }

    public static int getWidth() {
        return WIDTH * SCALE_FACTOR;
    }
}
