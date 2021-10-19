package seedu.address.model.tuitionclass;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.List;

import seedu.address.model.person.Name;
import seedu.address.model.person.Student;

/**
 * Represents a tuition TuitionClass in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class TuitionClass {

    private final ClassTiming classTiming;

    private final ClassName className;
    private final Location location;
    private final Rate rate;

    /**
     * ArrayList of {@code Name}
     * Rationale for choosing Name as identifier:
     * If the {@code Student} objects are stored, any changes to a student would cause a cascade of updates in classes
     * the student is in.
     */
    private final StudentList studentList;

    /**
     * Represents a tuition class for Students to join. A {@code TuitionClass} can have multiple {@code Student}s.
     * A class is uniquely identified by its timing; a single timing can only have _one_ class.
     *
     * A {@code Student} can have multiple {@code TuitionClass}es as well.
     *
     * @param className The name of the class to be created.
     * @param classTiming The timing of the class specified. This is the unique identifier (id) of the class.
     * @param location The location of the class.
     * @param rate How much it costs per hour to attend the class.
     */
    public TuitionClass(ClassName className, ClassTiming classTiming, Location location, Rate rate, Name... names) {
        requireAllNonNull(className, classTiming, location, rate);
        this.className = className;
        this.classTiming = classTiming;
        this.location = location;
        this.rate = rate;
        this.studentList = new StudentList(names);
    }

    public void addStudents(Name... names) {
        studentList.addAll(names);
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

    // TODO: fix this
    //    public List<Name> getStudentList() {
    //        return Collections.unmodifiableList(uniqueStudentList);
    //    }

    /**
     * Checks if the TuitionClass is at this timing.
     */
    public boolean isAtTiming(ClassTiming otherClassTiming) {
        return classTiming.equals(otherClassTiming);
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
        /* A class is uniquely identified by its timing; a single timing can only have _one_ class */
        return o.className.equals(getClassName())
                && o.classTiming.equals(getClassTiming());
    }


    /**
     * Returns true if the class timing of the class to be checked overlaps with this class.
     */
    public boolean isOverlapping(TuitionClass toCheck) {
        //TODO implement conflict checking
        return true;
    }
}
