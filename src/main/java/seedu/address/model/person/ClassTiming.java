package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a Student's class timing in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidClassTiming(String)}
 */
public class ClassTiming implements Comparable<ClassTiming> {


    public static final String MESSAGE_CONSTRAINTS =
            "Class Timing must be in the form DAY HH:MM-HH:MM, start time must be earlier than end time";

    /*
     * The string has to be in the form DAY HH:SS-HH:SS eg MON 23:59-01:00
     */
    public static final String VALIDATION_REGEX =
            "^(?i)(MON |TUE |WED |THU |FRI |SAT |SUN )+([01][0-9]|2[0-3]):[0-5][0-9]-([01][0-9]|2[0-3]):[0-5][0-9]";

    public final String value;

    private final LocalTime startTime;

    private final LocalTime endTime;

    private final String day;

    /**
     * Constructs a {@code ClassTiming}.
     *
     * @param classTiming A valid class timing.
     */
    public ClassTiming(String classTiming) {
        requireNonNull(classTiming);
        checkArgument(isValidClassTiming(classTiming), MESSAGE_CONSTRAINTS);
        value = formatClassTiming(classTiming);
        startTime = parseStartTime(value);
        endTime = parseEndTime(value);
        day = parseDay(value);
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
     * @return int representation of the days of the week.
     */
    public int getDayToInt() {
        switch (day.toUpperCase()) {
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
        return this.compareTo(otherClassTiming) == -1;
    }

    public boolean isAfter(LocalTime time) {
        return this.getStartTime().isAfter(time);
    }

    public String parseDay(String ct) {
        String[] classTimingPart = ct.split(" ");
        return classTimingPart[0];
    }

    public static String[] splitTiming(String ct) {
        String[] ctSplit = ct.split(" ");
        String startEndTime = ctSplit[1];
        return startEndTime.split("-");
    }

    public static LocalTime parseStartTime(String ct) {
        String[] timePart = splitTiming(ct);
        String startTime = timePart[0];
        return LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm"));
    }

    public static LocalTime parseEndTime(String ct) {
        String[] timePart = splitTiming(ct);
        String endTime = timePart[1];
        return LocalTime.parse(endTime, DateTimeFormatter.ofPattern("HH:mm"));
    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    public LocalTime getEndTime() {
        return this.endTime;
    }

    public String getDay() {
        return this.day;
    }

    public String getClassTiming() {
        return this.value.split(" ")[1];
    }

    /**
     * Returns true if a given string is a valid class timing.
     */
    public static boolean isValidClassTiming(String test) {
        if (test.matches(VALIDATION_REGEX)) {
            LocalTime startTime = parseStartTime(test);
            LocalTime endTime = parseEndTime(test);
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


    @Override
    public int compareTo(ClassTiming o) {
        int thisDayInt = getDayToInt();

        String otherDay = o.getDay();
        int otherDayInt = o.getDayToInt();
        LocalTime otherStartTime = o.getStartTime();

        if (thisDayInt < otherDayInt) {
            return -1;
        } else if (otherDayInt < thisDayInt) {
            return 1;
        } else if (this.getStartTime().equals(otherStartTime)){
            return 0;
        } else {
            return otherStartTime.isAfter(this.getEndTime()) || this.getStartTime().isBefore(otherStartTime) ? -1 : 1;
        }
    }
}
