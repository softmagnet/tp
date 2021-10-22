package seedu.address.ui;

import javafx.scene.control.ListCell;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.ui.classTab.TuitionClassCard;

/**
 * Custom {@code ListCell} that displays the graphics of a {@code TuitionClass} using a {@code TuitionClassCard}.
 */
public class TuitionClassListViewCell extends ListCell<TuitionClass> {
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
