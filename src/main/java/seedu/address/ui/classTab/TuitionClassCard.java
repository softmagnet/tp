package seedu.address.ui.classTab;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.ui.UiPart;

public class TuitionClassCard extends UiPart<Region> {

    private static final String FXML = "TuitionClassListCard.fxml";
    private static final Character DOLLAR_SIGN = '$';
    private static final String PER_HOUR = "/hr";
    private static final String CLASS_NAME_FIELD = "Class Name: ";
    private static final String CLASS_TIMING_FIELD = "Class Timing: ";
    private static final String LOCATION_FIELD = "Class Location: ";
    private static final String RATE_FIELD = "Rate: ";
    private static final String CLASS_SIZE_FIELD = "Class Size: ";

    public final TuitionClass tuitionClass;

    // TuitionClass
    @FXML
    private HBox cardPane;
    @FXML
    private Label className;
    @FXML
    private Label id;
    @FXML
    private Label classTiming;
    @FXML
    private Label classLocation;
    @FXML
    private Label rate;
    @FXML
    private Label classSize;

    public TuitionClassCard(TuitionClass tuitionClass, int displayedIndex) {
        super(FXML);
        this.tuitionClass = tuitionClass;

        // TuitionClass
        id.setText(displayedIndex + ". ");
        className.setText(CLASS_NAME_FIELD + tuitionClass.getClassName().className);
        classTiming.setText(CLASS_TIMING_FIELD + tuitionClass.getClassTiming().value);
        classLocation.setText(LOCATION_FIELD + tuitionClass.getLocation().value);
        rate.setText(RATE_FIELD + DOLLAR_SIGN + tuitionClass.getRate().value + PER_HOUR);
        classSize.setText(CLASS_SIZE_FIELD + tuitionClass.getStudentList().size());
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TuitionClassCard)) {
            return false;
        }

        // state check
        TuitionClassCard card = (TuitionClassCard) other;
        return id.getText().equals(card.id.getText())
                && tuitionClass.equals(card.tuitionClass);
    }
}
