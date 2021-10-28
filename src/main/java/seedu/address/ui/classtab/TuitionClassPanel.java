package seedu.address.ui.classtab;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.ui.TuitionClassListViewCell;
import seedu.address.ui.UiPart;

import java.util.logging.Logger;

public class TuitionClassPanel extends UiPart<Region> {
    private static final String FXML = "classTab/TuitionClassListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(TuitionClassPanel.class);

    private final ObservableList<Student> studentList;

    @FXML
    private ListView<TuitionClass> tuitionClassListView;

    public TuitionClassPanel(ObservableList<Student> studentList, ObservableList<TuitionClass> tuitionClassList) {
        super(FXML);
        this.studentList = studentList;
        tuitionClassListView.setItems(tuitionClassList);
    }

    public void setStudentClassList(ListView<Student> studentListView) {
        tuitionClassListView.setCellFactory(listView ->
                new TuitionClassListViewCell(studentList, studentListView));
    }
}
