package seedu.times.ui.classtab;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.times.commons.core.LogsCenter;
import seedu.times.model.person.Student;
import seedu.times.ui.UiPart;

public class StudentClassPanel extends UiPart<Region> {
    private static final String FXML = "classTab/StudentClassListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(TuitionClassPanel.class);

    @FXML
    private ListView<Student> studentListView;

    /**
     * Represents a Panel for the Students in a Tuition Class.
     *
     * @param studentList The studentList that it is supposed to display.
     */
    public StudentClassPanel(ObservableList<Student> studentList) {
        super(FXML);
        studentListView.setItems(studentList);
        studentListView.setCellFactory(listView -> new StudentListClassTabViewCell());
    }


    public void setItems(ObservableList<Student> studentObservableList) {
        studentListView.setItems(studentObservableList);
    }

    public ListView<Student> getStudentListView() {
        return studentListView;
    }
}