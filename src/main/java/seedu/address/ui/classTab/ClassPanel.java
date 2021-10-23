package seedu.address.ui.classTab;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
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
    private ListView<Student> studentListViewClassTab;

    private final ObservableList<TuitionClass> tuitionClassList;

    /**
     * Creates a {@code StudentListPanel} with the given {@code ObservableList}.
     */
    public ClassPanel(ObservableList<Student> studentList, ObservableList<TuitionClass> tuitionClassList) {
        super(FXML);
        this.tuitionClassList = tuitionClassList;

        tuitionClassListView.setItems(tuitionClassList);
        tuitionClassListView.setCellFactory(listView ->
                new TuitionClassListViewCell(studentList, studentListViewClassTab));
        logger.info("ClassPanel tab opened");
    }
}
