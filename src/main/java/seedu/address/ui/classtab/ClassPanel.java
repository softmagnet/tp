package seedu.address.ui.classtab;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.ui.TuitionClassListViewCell;
import seedu.address.ui.UiPart;

/**
 * A UI for the Class Panel Tab.
 */
public class ClassPanel extends UiPart<Region> {
    private static final String FXML = "classTab/ClassPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ClassPanel.class);

    @FXML
    private ListView<TuitionClass> tuitionClassListView;

    @FXML
    private StackPane tuitionClassListPlaceholder;

    @FXML
    private ListView<Student> studentListViewClassTab;

    @FXML
    private StackPane studentListPlaceholder;

    private StudentClassPanel studentClassPanel;
    private TuitionClassPanel tuitionClassPanel;

    private final ObservableList<TuitionClass> tuitionClassList;

    /**
     * Creates a {@code StudentListPanel} with the given {@code ObservableList}.
     */
    public ClassPanel(ObservableList<Student> studentList, ObservableList<TuitionClass> tuitionClassList) {
        super(FXML);
        this.tuitionClassList = tuitionClassList;

        studentClassPanel = new StudentClassPanel(studentList);
        tuitionClassPanel = new TuitionClassPanel(studentList, tuitionClassList);

        tuitionClassPanel.setStudentClassList(studentClassPanel.getStudentListView());

        studentListPlaceholder.getChildren().add(studentClassPanel.getRoot());
        tuitionClassListPlaceholder.getChildren().add(tuitionClassPanel.getRoot());

        logger.info("ClassPanel tab opened");
    }

    public void setItems(ObservableList<Student> studentObservableList) {
        studentListViewClassTab.setItems(studentObservableList);
    }

    public void setCellFactory(Callback<ListView<Student>, ListCell<Student>> studentObservableList) {
        studentListViewClassTab.setCellFactory(studentObservableList);
    }

}
