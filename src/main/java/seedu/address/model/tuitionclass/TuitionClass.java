package seedu.address.model.tuitionclass;

import seedu.address.model.person.Name;

import java.util.Collections;
import java.util.List;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Represents a tuition TuitionClass in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class TuitionClass {

    private final ClassName className;
    private final ClassTiming classTiming;
    private final Location location;
    private final Rate rate;

    /**
     * ArrayList of {@code Name}
     * Rationale for choosing Name as identifier:
     * If the {@code Student} objects are stored, any changes to a student would cause a cascade of updates in classes
     * the student is in.
     */

    private final StudentList studentList;

    public TuitionClass(ClassName className, ClassTiming classTiming, Location location, Rate rate, Name... studentNames) {
        requireAllNonNull(className, classTiming, location, rate);
        this.className = className;
        this.classTiming = classTiming;
        this.location = location;
        this.rate = rate;
        studentList = new StudentList(studentNames);
    }

    public ClassName getClassName() {
        return className;
    }

    public ClassTiming getClassTiming() {
        return classTiming;
    }

    public Location getLocation() {
        return location;
    }

    public Rate getRate() {
        return rate;
    }

    public List<Name> getStudentList() {
        return Collections.unmodifiableList(studentList);
    }



    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof TuitionClass)) {
            return false;
        }

        TuitionClass o = (TuitionClass) other;
        return o.className.equals(getClassName())
                && o.rate.equals(getRate())
                && o.classTiming.equals(getClassTiming())
                && o.location.equals(getLocation());
    }


    /**
     * Returns true if the class timing of the class to be checked overlaps with this class.
     */
    public boolean isOverlapping(TuitionClass toCheck) {
        //TODO implement conflict checking
        return true;
    }
}
