package seedu.address.model.tuitionclass;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a Student's class timing in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidClassTiming(String)}
 */
public class ClassTiming {

    public static final String MESSAGE_CONSTRAINTS =
            "Class Timing must be in the form DAY HH:MM-HH:MM, start time must be earlier than end time";

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
     * Converts the day into the int representation of the day.
     *
     * @param day String value of the day in class timing.
     * @return int representatin of the days of the week.
     */
    public int replaceDayWithInt(String day) {
        switch (day) {
        case "MON":
            return 1;
        case "TUE":
            return 2;
        case "WED":
            return 3;
        case "THU":
            return 4;
        case "FRI":
            return 5;
        case "SAT":
            return 6;
        case "SUN":
            return 7;
        default:
            return 0;
        }
    }

    /**
     * Compares two ClassTiming objects.
     *
     * @param otherClassTiming ClassTiming being compared to.
     * @return true if this ClassTiming is on an earlier day or has end time earlier than otherClassTiming
     * start time, otherwise false.
     */
    public boolean isEarlier(ClassTiming otherClassTiming) {
        String thisDay = getDay(this.value);
        int thisDayInt = replaceDayWithInt(thisDay);
        LocalTime thisStartTime = getStartTime(this.value);
        LocalTime thisEndTime = getEndTime(this.value);

        String otherDay = getDay(otherClassTiming.value);
        int otherDayInt = replaceDayWithInt(otherDay);
        LocalTime otherStartTime = getStartTime(otherClassTiming.value);

        return thisDayInt < otherDayInt || otherStartTime.isAfter(thisEndTime)
                || thisStartTime.isBefore(otherStartTime);
    }

    public static String getDay(String ct) {
        String[] classTimingPart = ct.split(" ");
        String day = classTimingPart[0];
        return day;
    }

    public static String[] getTiming(String ct) {
        String[] ctSplit = ct.split(" ");
        String startEndTime = ctSplit[1];
        String[] timePart = startEndTime.split("-");
        return timePart;
    }

    public static LocalTime getStartTime(String ct) {
        String[] timePart = getTiming(ct);
        String startTime = timePart[0];
        return LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm"));
    }

    public static LocalTime getEndTime(String ct) {
        String[] timePart = getTiming(ct);
        String endTime = timePart[1];
        return LocalTime.parse(endTime, DateTimeFormatter.ofPattern("HH:mm"));
    }

    /**
     * Returns true if a given string is a valid class timing.
     */
    public static boolean isValidClassTiming(String test) {
        if (test.matches(VALIDATION_REGEX)) {
            LocalTime startTime = getStartTime(test);
            LocalTime endTime = getEndTime(test);
            return startTime.isBefore(endTime);
        } else {
            return false;
        }
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
