package seedu.address.ui.timetable;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Student;
import seedu.address.ui.UiPart;

import java.util.logging.Logger;

public class TimetablePanel extends UiPart<Region> {
    private static final String FXML = "timetable/timetableRegion.fxml";
    private final Logger logger = LogsCenter.getLogger(TimetablePanel.class);

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private GridPane timetable;

    /**
     * Creates a {@code TimetablePanel} with the given {@code ObservableList}.
     */
    public TimetablePanel(ObservableList<Student> studentList) {
        super(FXML);
        construct(studentList);
//        personListView.setItems(studentList);
//        personListView.setCellFactory(listView -> new PersonListPanel.PersonListViewCell());
    }

    public void construct(ObservableList<Student> studentList) {
        clearAll();
        if (studentList.isEmpty()) {
            Label label = new Label("You have no classes.");
            timetable.add(label, 0, 0);
        } else {
            Label label = new Label("Work in progress");
            timetable.add(label, 0, 0);
        }
    }

    /**
     * Clears the previously constructed timetable.
     */
    private void clearAll() {
        timetable.getChildren().clear();
        timetable.getRowConstraints().clear();
        timetable.getColumnConstraints().clear();
    }
}
