package seedu.address.ui;

import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.ui.classTab.TuitionClassCard;

/**
 * Custom {@code ListCell} that displays the graphics of a {@code TuitionClass} using a {@code TuitionClassCard}.
 */
public class TuitionClassListViewCell extends ListCell<TuitionClass> {

    private final ObservableList<Student> studentList;
    private final ListView<Student> tuitionClassListView;

    public TuitionClassListViewCell(ObservableList<Student> studentList, ListView<Student> tuitionClassListView) {
        this.studentList = studentList;
        this.tuitionClassListView = tuitionClassListView;
    }

    @Override
    protected void updateItem(TuitionClass tuitionClass, boolean empty) {
        super.updateItem(tuitionClass, empty);

        if (empty || tuitionClass == null) {
            setGraphic(null);
            setText(null);
        } else {
            setGraphic(new TuitionClassCard(tuitionClass, getIndex() + 1, studentList, tuitionClassListView).getRoot());
        }
    }
}
