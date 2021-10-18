package seedu.address.model.tuitionclass;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.List;

import seedu.address.model.person.Name;

/**
 * Represents a tuition TuitionClass in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class TuitionClass {

    private final ClassName className;
    private final ClassTiming classTiming;
    private final Location location;
    private final Rate rate;

    private final StudentList studentList;

    /**
     * Represents a tuition class for Students to join. A {@code TuitionClass} can have multiple {@code Student}s.
     * A {@code Student} can have multiple {@code TuitionClass}es as well.
     *
     * @param className The name of the class to be created.
     * @param classTiming The timing of the class specified. This is the unique identifier (id) of the class.
     * @param location The location of the class.
     * @param rate How much it costs per hour to attend the class.
     * @param studentNames A list of student names to add to the class upon creation.
     */
    public TuitionClass(ClassName className, ClassTiming classTiming, Location location, Rate rate,
                        Name... studentNames) {
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
