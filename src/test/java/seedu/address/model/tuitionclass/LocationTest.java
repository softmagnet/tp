package seedu.address.model.tuitionclass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

public class LocationTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Location(null));
    }

    @Test
    public void constructor_invalidLocation_throwsIllegalArgumentException() {
        String invalidLocation = "";
        String invalidLocation2 = " ";
        assertThrows(IllegalArgumentException.class, () -> new Location(invalidLocation));
        assertThrows(IllegalArgumentException.class, () -> new Location(invalidLocation2));
    }

    @Test
    public void isValidLocation() {
        //null location
        assertThrows(NullPointerException.class, () -> Location.isValidLocation(null));

        //invalid locations
        assertFalse(Location.isValidLocation(""));
        assertFalse(Location.isValidLocation(" "));
        assertFalse(Location.isValidLocation(" Serangoon"));

        //valid locations
        assertTrue(Location.isValidLocation("Nex Kumon")); //no non-alpha numeric
        assertTrue(Location.isValidLocation("Hougang blk 111 #02-310")); //contains non-alpha numeric
    }

}
