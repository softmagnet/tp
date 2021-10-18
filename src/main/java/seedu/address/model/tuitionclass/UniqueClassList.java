package seedu.address.model.tuitionclass;


import static java.util.Objects.requireNonNull;

import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.person.Student;
import seedu.address.model.person.UniquePersonList;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.model.tuitionclass.exceptions.InvalidClassException;

/**
 * A list of classes that makes sure there is no overlap between class timings.
 */
public class UniqueClassList implements Iterable<Class> {

    private final ObservableList<Class> internalList = FXCollections.observableArrayList();
    private final ObservableList<Class> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * Adds a class to the list. Class must not overlap in timing with existing classes.
     * @param toAdd
     */
    public void add(Class toAdd) {
        requireNonNull(toAdd);
        if (!isValidTiming(toAdd)) {
            throw new InvalidClassException();
        }


    }

    /**
     * Checks if the class timing is valid (no overlaps with current classes).
     *
     */
    public boolean isValidTiming(Class toCheck) {
        requireNonNull(toCheck);
        return !internalList.stream().anyMatch(toCheck::isOverlapping);
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<Class> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<Class> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniqueClassList // instanceof handles nulls
                && internalList.equals(((UniqueClassList) other).internalList));
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

}
