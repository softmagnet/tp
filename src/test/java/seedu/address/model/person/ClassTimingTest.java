package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class ClassTimingTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ClassTiming(null));
    }

    @Test
    public void constructor_invalidAddress_throwsIllegalArgumentException() {
        //Todo
        String invalidAddress = "";
        assertThrows(IllegalArgumentException.class, () -> new ClassTiming(invalidAddress));
    }

    @Test
    public void isValidAddress() {
        // null classTiming
        assertThrows(NullPointerException.class, () -> ClassTiming.isValidClassTiming(null));

        // invalid classTiming
        assertFalse(ClassTiming.isValidClassTiming("")); // empty string
        assertFalse(ClassTiming.isValidClassTiming(" ")); // spaces only

        // valid classTiming
        assertTrue(ClassTiming.isValidClassTiming("Mon 2pm"));
        assertTrue(ClassTiming.isValidClassTiming("2")); // one character
        assertTrue(ClassTiming.isValidClassTiming("Every Mon 2pm till end of the year")); // long classTiming
    }
}
