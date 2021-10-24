package seedu.address.model.tuitionclass.exceptions;

/**
 * Signals that the operation will result in a invalid class (Classes are considered invalid if they have overlapping
 * timings with existing classes in the list).
 */
public class InvalidClassException extends RuntimeException {
    public InvalidClassException() {
        super("Operation would result in overlapping class timings");
    }
}
