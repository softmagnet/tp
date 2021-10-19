package seedu.address.model;

import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.ClassTiming;
import seedu.address.model.tuitionclass.TuitionClass;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyAddressBook {

    /**
     * Returns an unmodifiable view of the persons list.
     * This list will not contain any duplicate persons.
     */
    ObservableList<Student> getPersonList();

    ObservableMap<ClassTiming, TuitionClass> getTuitionClassList();
}
