package seedu.address.model.tuitionclass.exceptions;

import seedu.address.model.person.Name;

public class DuplicateStudentInClassException extends RuntimeException {
    public DuplicateStudentInClassException(Name duplicatedName) {
        super(duplicatedName.toString());
    }
}
