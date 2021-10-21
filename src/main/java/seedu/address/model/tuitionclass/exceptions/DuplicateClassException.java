package seedu.address.model.tuitionclass.exceptions;

/**
 * Exception thrown when user attempts at adding to unique class list a tuition class  that has same timing
 * as an already existing tuition class
 */
public class DuplicateClassException extends RuntimeException {
    public DuplicateClassException() {
        super("Operation would result in classes with same timing!");
    }
}
