package seedu.address.model.tuitionclass;

import static java.util.Objects.requireNonNull;

import java.util.HashMap;
import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import jdk.dynalink.linker.support.TypeUtilities;
import seedu.address.model.tuitionclass.exceptions.InvalidClassException;

/**
 * A list of classes that makes sure there is no overlap between class timings.
 */
public class UniqueClassList implements Iterable<TuitionClass> {

    private final ObservableMap<ClassTiming, TuitionClass> internalMap = FXCollections.observableMap(new HashMap<>());

    private final ObservableMap<ClassTiming, TuitionClass> internalUnmodifiableMap =
            FXCollections.unmodifiableObservableMap(internalMap);

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
        internalMap.put(toAdd.getClassTiming(), toAdd);
    }

    /**
     * Checks if the class timing is valid (no overlaps with current classes).
     */
    public boolean isValidTiming(TuitionClass otherClass) {
        requireNonNull(otherClass);
        for (TuitionClass tuitionClass : internalMap.values()) {
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
        return internalMap.containsKey(timing);
    }

    /**
     * Checks if there is an identical class in the internalMap.
     */
    public boolean contains(TuitionClass tuitionClass) {
        return internalMap.containsKey(tuitionClass.getClassTiming());
    }

    /**
     * Returns the class at the specified timing.
     * Throws an error if the timing is invalid or no classes exist at that timing.
     */
    public TuitionClass getClassAt(ClassTiming timing) {
        requireNonNull(timing);
        return internalMap.get(timing);
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableMap<ClassTiming, TuitionClass> asUnmodifiableObservableMap() {
        return internalUnmodifiableMap;
    }

    @Override
    public Iterator<TuitionClass> iterator() {
        // Iterates through the values in the internalMap
        return internalMap.values().iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniqueClassList // instanceof handles nulls
                && internalMap.equals(((UniqueClassList) other).internalMap));
    }

    @Override
    public int hashCode() {
        return internalMap.hashCode();
    }
}
