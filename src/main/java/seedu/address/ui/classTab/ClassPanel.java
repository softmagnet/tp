package seedu.address.ui.classTab;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.ui.StudentCard;
import seedu.address.ui.StudentListPanel;
import seedu.address.ui.UiPart;

import java.util.logging.Logger;

/**
 * A UI for the Class Panel Tab.
 */
public class ClassPanel extends UiPart<Region> {
    private static final String FXML = "classTab/ClassPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ClassPanel.class);
    private final StudentListPanel studentListPanel;
    private final TuitionClassListPanel tuitionClassListPanel;

//    @FXML
//    private ListView<TuitionClass> studentListView;
//    @FXML
//    private ListView<TuitionClass> classListView;

    @FXML
    private ListView<Student> studentListView;
    @FXML
    private ListView<TuitionClass> tuitionClassListView;

    /**
     * Creates a {@code StudentListPanel} with the given {@code ObservableList}.
     */
    public ClassPanel(ObservableList<Student> studentList, ObservableList<TuitionClass> tuitionClassList) {
        super(FXML);
        studentListPanel = new StudentListPanel(studentList);
        tuitionClassListPanel = new TuitionClassListPanel(tuitionClassList);

        studentListView.setItems(studentList);
        studentListView.setCellFactory(listView -> new StudentListViewCell());

        tuitionClassListView.setItems(tuitionClassList);
        tuitionClassListView.setCellFactory(listView -> new TuitionClassListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code TuitionClass} using a {@code TuitionClassCard}.
     */
    class TuitionClassListViewCell extends ListCell<TuitionClass> {
        @Override
        protected void updateItem(TuitionClass tuitionClass, boolean empty) {
            super.updateItem(tuitionClass, empty);

            if (empty || tuitionClass == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new TuitionClassCard(tuitionClass, getIndex() + 1).getRoot());
            }
        }
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Student} using a {@code StudentCard}.
     */
    class StudentListViewCell extends ListCell<Student> {
        @Override
        protected void updateItem(Student student, boolean empty) {
            super.updateItem(student, empty);

            if (empty || student == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new StudentCard(student, getIndex() + 1).getRoot());
            }
        }
    }
}