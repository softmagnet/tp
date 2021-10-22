package seedu.address.ui.classTab;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.ui.StudentListViewCell;
import seedu.address.ui.TuitionClassListViewCell;
import seedu.address.ui.UiPart;

/**
 * A UI for the Class Panel Tab.
 */
public class ClassPanel extends UiPart<Region> {
    private static final String FXML = "classTab/ClassPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ClassPanel.class);

    @FXML
    private ListView<Student> studentListView;
    @FXML
    private ListView<TuitionClass> tuitionClassListView;

    /**
     * Creates a {@code StudentListPanel} with the given {@code ObservableList}.
     */
    public ClassPanel(ObservableList<Student> studentList, ObservableList<TuitionClass> tuitionClassList) {
        super(FXML);

        studentListView.setItems(studentList);
        studentListView.setCellFactory(listView -> new StudentListViewCell());

        tuitionClassListView.setItems(tuitionClassList);
        tuitionClassListView.setCellFactory(listView -> new TuitionClassListViewCell());
    }
}
