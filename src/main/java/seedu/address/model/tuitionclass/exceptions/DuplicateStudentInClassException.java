package seedu.address.model.tuitionclass.exceptions;

public class DuplicateStudentInClassException extends RuntimeException {
    public DuplicateStudentInClassException() {
        super("Operation would result in duplicate student in class");
    }
}
