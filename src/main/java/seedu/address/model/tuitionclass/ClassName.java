package seedu.address.model.tuitionclass;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents the name given to a tuition class by a user
 * Guarantees: immutable; is valid as declared in {@link #isValidClassName(String)}
 */
public class ClassName {
    public static final String MESSAGE_CONSTRAINTS =
            "Names should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the name must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String className;

    /**
     * Constructs a {@code ClassName}.
     *
     * @param className A valid class name.
     */
    public ClassName(String className) {
        requireNonNull(className);
        checkArgument(isValidClassName(className), MESSAGE_CONSTRAINTS);
        this.className = className;
    }

    /**
     * Returns true if a given string is a valid class name.
     */
    public static boolean isValidClassName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return className;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ClassName // instanceof handles nulls
                && className.equals(((ClassName) other).className)); // state check
    }
}
