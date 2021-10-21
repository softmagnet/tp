package seedu.address.model.tuitionclass;

import seedu.address.model.person.Name;

import seedu.address.model.tuitionclass.exceptions.DuplicateStudentInClassException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * Represents a unique list of names corresponding to the students
 * that a {@code TuitionClass} has.
 */
public class UniqueNameList implements Iterable<Name> {

    private final ArrayList<Name> internalList = new ArrayList<>();

    public boolean contains(Name toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::equals);
    }

    public void add(Name toAdd) throws DuplicateStudentInClassException {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicateStudentInClassException(toAdd);
        }
        internalList.add(toAdd);
    }

    public void addAll(UniqueNameList names) {
        for (Name name : names) {
            if (!this.contains(name)) {
                this.add(name);
            }
        }
    }

    public void addAll(List<Name> names) throws DuplicateStudentInClassException {
        for (int i = 0; i < names.size(); i++) {
            this.add(names.get(i));
        }
    }

    public String size() {
        return String.valueOf(internalList.size());
    }

    @Override
    public Iterator<Name> iterator() {
        return internalList.iterator();
    }
}
