package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Student's tuition rate in the address book.
 */
public class Rate {

    private static final String MESSAGE_CONSTRAINTS =
            "Rate should not be negative and can "
                    + "at most be up to 2 decimal places. You also cannot enter a decimal point without"
                    + "following it up with at least one digit.";
    public final String value;
    public static final String VALIDATION_REGEX = "\\d+(\\.\\d{1,2})?";

    /**
     * Constructs a {@code Rate}
     *
     * @param rate A valid tuition per hour rate.
     */
    public Rate(String rate) {
        requireNonNull(rate);
        checkArgument(isValidRate(rate), MESSAGE_CONSTRAINTS);
        value = rate;
    }

    /**
     * Returns true if a given string is a valid tuition rate.
     *
     * @param test String representing rate to be tested.
     * @return A boolean value.
     */
    public static boolean isValidRate(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Rate // instanceof handles nulls
                && value.equals(((Rate) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
