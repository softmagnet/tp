package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.model.tuitionclass.ClassTiming;

public class ClassTimingTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ClassTiming(null));
    }

    @Test
    public void constructor_invalidClassTiming_throwsIllegalArgumentException() {
        //Todo
        String invalidClassTiming = "";
        assertThrows(IllegalArgumentException.class, () -> new ClassTiming(invalidClassTiming));
    }

    @Test
    public void isValidClassTiming() {
        // null classTiming
        assertThrows(NullPointerException.class, () -> ClassTiming.isValidClassTiming(null));

        // invalid classTiming
        assertFalse(ClassTiming.isValidClassTiming("")); // empty string
        assertFalse(ClassTiming.isValidClassTiming(" ")); // spaces only
        assertFalse(ClassTiming.isValidClassTiming("mon 9:00-10:00")); // incorrect timing format
        assertFalse(ClassTiming.isValidClassTiming("mon 0900-1000")); // incorrect timing format
        assertFalse(ClassTiming.isValidClassTiming("mon 10:00")); // missing end time
        assertFalse(ClassTiming.isValidClassTiming("09:00-10:00")); // missing day time
        assertFalse(ClassTiming.isValidClassTiming("monday 10:00")); // incorrect day format
        assertFalse(ClassTiming.isValidClassTiming("THUR 0900-1000")); // incorrect day format



        // valid classTiming
        assertTrue(ClassTiming.isValidClassTiming("Mon 01:00-02:00"));
        assertTrue(ClassTiming.isValidClassTiming("mON 01:00-23:59")); // DAY in weird caps
    }
}
