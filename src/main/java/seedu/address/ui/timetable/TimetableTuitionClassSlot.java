package seedu.address.ui.timetable;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import seedu.address.model.person.ClassTiming;

import java.time.temporal.ChronoUnit;

public class TimetableTuitionClassSlot extends TimetableRegion {

    private static final String FXML = "timetable/TimetableTuitionClassSlot.fxml";

    @FXML
    private Label time;

    @FXML
    private Label className;

    public TimetableTuitionClassSlot(String tuitionClassName, ClassTiming classTiming) {
        super(FXML, classTiming.getStartTime().until(classTiming.getEndTime(), ChronoUnit.MINUTES));
        className.setText(tuitionClassName);
        time.setText(classTiming.getClassTiming());
    }
}
