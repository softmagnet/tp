package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Student's class timing in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidClassTiming(String)}
 */
public class ClassTiming {


    public static final String MESSAGE_CONSTRAINTS =
            "Class Timing must be in the form DAY HH:MM-HH:MM";

    /*
     * The string has to be in the form DAY HH:SS-HH:SS eg MON 23:59-01:00
     */
    public static final String VALIDATION_REGEX =
            "^(?i)(MON |TUE |WED |THU |FRI |SAT |SUN )+([01][0-9]|2[0-3]):[0-5][0-9]-([01][0-9]|2[0-3]):[0-5][0-9]";

    public final String value;

    /**
     * Constructs a {@code ClassTiming}.
     *
     * @param classTiming A valid class timing.
     */
    public ClassTiming(String classTiming) {
        requireNonNull(classTiming);
        checkArgument(isValidClassTiming(classTiming), MESSAGE_CONSTRAINTS);
        value = formatClassTiming(classTiming);
    }

    /**
     * Formats the classTiming day into caps.
     *
     * @param classTiming classTiming where day is going to be changed to caps.
     * @return classTiming with the day in caps.
     */
    public String formatClassTiming(String classTiming) {
        String day = classTiming.split(" ")[0].toUpperCase();
        String timing = classTiming.split(" ")[1];
        return day + " " + timing;
    }

    /**
     * Returns true if a given string is a valid phone number.
     */
    public static boolean isValidClassTiming(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ClassTiming // instanceof handles nulls
                && value.equals(((ClassTiming) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
