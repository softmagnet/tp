package seedu.address.ui.classtab;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.ui.StudentListViewCell;
import seedu.address.ui.UiPart;

public class TuitionClassCard extends UiPart<Region> {

    private static final String FXML = "classTab/TuitionClassListCard.fxml";
    private static final Character DOLLAR_SIGN = '$';
    private static final String PER_HOUR = "/hr";
    private static final String CLASS_TIMING_FIELD = "Timing: ";
    private static final String LOCATION_FIELD = "Location: ";
    private static final String RATE_FIELD = "Rate: ";
    private static final String CLASS_SIZE_FIELD = "Size: ";

    public final TuitionClass tuitionClass;

    // TuitionClass
    @FXML
    private HBox cardPane;
    @FXML
    private Label className;
    @FXML
    private Label id;
    @FXML
    private Label classTiming;
    @FXML
    private Label classLocation;
    @FXML
    private Label rate;
    @FXML
    private Label classSize;

    private final ListView<Student> tuitionClassListView;

    private final ObservableList<Student> studentList;

    /**
     * Represents a Tuition Card to be shown in the GUI.
     *
     * @param tuitionClass The class to display.
     * @param displayedIndex The index to display.
     */
    public TuitionClassCard(TuitionClass tuitionClass, int displayedIndex,
                            ObservableList<Student> studentList, ListView<Student> tuitionClassListView) {
        super(FXML);
        this.tuitionClass = tuitionClass;
        this.studentList = studentList;
        this.tuitionClassListView = tuitionClassListView;

        this.studentList.addListener(new ListChangeListener<Student>() {
            @Override
            public void onChanged(Change<? extends Student> change) {
                while (change.next()) {
                    selectTuitionClass();
                }
            }
        });

        int index = tuitionClassListView.getSelectionModel().getSelectedIndex();
        tuitionClassListView.getSelectionModel().clearSelection(index);

        // TuitionClass
        String newClassSize = CLASS_SIZE_FIELD + tuitionClass.getStudentList().size();
        String newClassTiming = CLASS_TIMING_FIELD + tuitionClass.getClassTiming().value;
//
//        if (classChanged(classSize.getText(), newClassSize, classTiming.getText(), newClassTiming)) { // Size: 1
//        }

        id.setText(displayedIndex + ". ");
        className.setText(tuitionClass.getClassName().className);
        classTiming.setText(newClassTiming);
        classLocation.setText(LOCATION_FIELD + tuitionClass.getLocation().value);
        rate.setText(RATE_FIELD + DOLLAR_SIGN + tuitionClass.getRate().value + PER_HOUR);
        classSize.setText(newClassSize);
    }

    public boolean classChanged(
            String oldClassSize, String newClassSize, String oldClassTiming, String newClassTiming) {
        if (oldClassSize.equals("")) {
            return false;
        } else {

            System.out.println(oldClassSize);
            System.out.println(newClassSize);
            System.out.println(oldClassTiming);
            System.out.println(newClassTiming);

            return oldClassTiming.equals(newClassTiming) && !oldClassSize.equals(newClassSize);
        }
    }

    @FXML
    private void onMouseClick() {
        selectTuitionClass();
    }

    /**
     * Visually selects the tuition class and shows the Student List associated to it.
     */
    public void selectTuitionClass() {
        ObservableList<Student> newStudentList =
                studentList.filtered(student -> tuitionClass.containsStudent(student.getName()));

        tuitionClassListView.setItems(newStudentList);
        tuitionClassListView.setCellFactory(listView -> new StudentListViewCell());
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TuitionClassCard)) {
            return false;
        }

        // state check
        TuitionClassCard card = (TuitionClassCard) other;
        return id.getText().equals(card.id.getText())
                && tuitionClass.equals(card.tuitionClass);
    }
}
