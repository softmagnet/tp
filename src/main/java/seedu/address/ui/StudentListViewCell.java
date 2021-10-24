package seedu.address.ui;

import javafx.scene.control.ListCell;
import seedu.address.model.person.Student;
import seedu.address.ui.studentTab.StudentCard;

/**
 * Custom {@code ListCell} that displays the graphics of a {@code Student} using a {@code StudentCard}.
 */
public class StudentListViewCell extends ListCell<Student> {
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
