package seedu.address.model.tuitionclass;

import seedu.address.model.person.Name;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents the list of students that a tuition {@code TuitionClass} has.
 */
public class StudentList extends ArrayList<Name> {

    public StudentList(Name... names) {
        super();
        Arrays.stream(names).forEach(name -> this.add(name));
    }

}
