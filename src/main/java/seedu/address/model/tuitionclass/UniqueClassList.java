package seedu.address.model.tuitionclass;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.HashMap;
import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import jdk.dynalink.linker.support.TypeUtilities;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.model.person.exceptions.PersonNotFoundException;
import seedu.address.model.tuitionclass.exceptions.InvalidClassException;
import seedu.address.model.tuitionclass.exceptions.TuitionClassNotFoundException;

/**
 * A list of classes that makes sure there is no overlap between class timings.
 */
public class UniqueClassList implements Iterable<TuitionClass> {

    private final ObservableList<TuitionClass> internalList = FXCollections.observableArrayList();
    private final ObservableList<TuitionClass> internalUnmodifiableList
            = FXCollections.unmodifiableObservableList(internalList);

    /**
     * Adds a class to the list. TuitionClass must not overlap in timing with existing classes.
     *
     * @param toAdd The tuition class to add.
     */
    public void add(TuitionClass toAdd) {
        requireNonNull(toAdd);
        if (!isValidTiming(toAdd)) {
            throw new InvalidClassException();
        }
        internalList.add(toAdd);
    }

    public void delete(TuitionClass toDelete) {
        requireNonNull(toDelete);
        if(!internalList.remove(toDelete)) {
            throw new TuitionClassNotFoundException();
        }
    }

    /**
     * Checks if the class timing is valid (no overlaps with current classes).
     */
    public boolean isValidTiming(TuitionClass otherClass) {
        requireNonNull(otherClass);
        for (TuitionClass tuitionClass : internalList) {
            if (tuitionClass.isOverlapping(otherClass)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if there is a class with the timing specified.
     */
    public boolean classExistAt(ClassTiming timing) {
        //TODO: probably need to modify cos need to consider overlap
        return internalList.stream().anyMatch(c -> {
            return c.getClassTiming().equals(timing);
        });
    }

    /**
     * Checks if there is an identical class in the internalMap.
     */
    public boolean contains(TuitionClass tuitionClass) {
        return internalList.stream().anyMatch(tuitionClass::isSameClass);
    }

    /**
     * Returns the class at the specified timing.
     * Throws an error if the timing is invalid or no classes exist at that timing.
     */
    public TuitionClass getClassAt(ClassTiming timing) {
        requireNonNull(timing);
        for (TuitionClass tuitionClass : internalList) {
            if (tuitionClass.getClassTiming().equals(timing)) {
                return tuitionClass;
            }
        }
        //if no class at specified timing returns null
        return null;
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<TuitionClass> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<TuitionClass> iterator() {
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

    public void setClass(TuitionClass target, TuitionClass editedClass) {
        requireAllNonNull(target, editedClass);

        int index = internalList.indexOf(target);
        if (index == -1) {
            throw new PersonNotFoundException();
        }

        if (!target.isSameClass(editedClass) && contains(editedClass)) {
            throw new DuplicatePersonException();
        }

        internalList.set(index, editedClass);
    }

    //TODO: need a personsAreUnique method probably
}
