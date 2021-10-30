package seedu.address.ui.classtab;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.ui.UiPart;

public class TuitionClassPanel extends UiPart<Region> {
    private static final String FXML = "classTab/TuitionClassListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(TuitionClassPanel.class);

    private final ObservableList<Student> studentList;

    @FXML
    private ListView<TuitionClass> tuitionClassListView;

    /**
     * Represents a Panel for the Tuition Class.
     *
     * @param studentList The studentList is required for the Panel to filter out the students in the class.
     * @param tuitionClassList The tuitionClassList is required to show the classes in the panel.
     */
    public TuitionClassPanel(ObservableList<Student> studentList, ObservableList<TuitionClass> tuitionClassList) {
        super(FXML);
        this.studentList = studentList;
        tuitionClassListView.setItems(tuitionClassList);
    }

    /**
     * Creates the students given the studentListView.
     *
     * @param studentListView The given studentListView to create the students with.
     */
    public void setStudentClassList(ListView<Student> studentListView) {
        tuitionClassListView.setCellFactory(listView ->
                new TuitionClassListViewCell(studentList, studentListView));
    }
}
