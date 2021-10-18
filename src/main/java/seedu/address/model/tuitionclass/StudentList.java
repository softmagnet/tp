package seedu.address.model.tuitionclass;

import java.util.ArrayList;
import java.util.Arrays;

import seedu.address.model.person.Name;

/**
 * Represents the list of students that a tuition {@code TuitionClass} has.
 */
public class StudentList extends ArrayList<Name> {

    /**
     * Constructs a {@code StudentList} using an array of Names.
     *
     * @param names List of names to be added.
     */
    public StudentList(Name... names) {
        super();
        this.addAll(Arrays.asList(names));
    }
}
