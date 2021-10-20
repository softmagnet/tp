package seedu.address.ui.timetable;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.ui.UiPart;

public class TimetableRegion extends UiPart<Region> {

    @FXML
    private HBox slotPane;

    public static int SCALE_FACTOR = 2;

    public TimetableRegion(String fxml, long scale) {
        super(fxml);
        slotPane.setPrefWidth(scale * SCALE_FACTOR);
        slotPane.setMinWidth(scale * SCALE_FACTOR);
    }

}
