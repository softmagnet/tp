package seedu.address.model.tuitionclass;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TuitionClassTest {
    private ClassName className = new ClassName("test");
    private Location location = new Location("test");
    private Rate rate = new Rate("50");

    @Test
    public void isOverlapping_overlappingTiming_returnsTrue() {
        TuitionClass class1 = new TuitionClass(className, new ClassTiming("MON 16:00-18:00"), location, rate);
        TuitionClass class2 = new TuitionClass(className, new ClassTiming("MON 17:00-18:00"), location, rate);
        assertTrue(class1.isOverlapping(class2));
        assertTrue(class2.isOverlapping(class1));
    }

    @Test
    public void isOverlapping_differentDay_returnsFalse() {
        TuitionClass class1 = new TuitionClass(className, new ClassTiming("MON 16:00-18:00"), location, rate);
        TuitionClass class2 = new TuitionClass(className, new ClassTiming("TUE 17:00-18:00"), location, rate);
        assertFalse(class1.isOverlapping(class2));
        assertFalse(class2.isOverlapping(class1));
    }

    @Test
    public void isOverlapping_sameDayNoOverlap_returnsFalse() {
        TuitionClass class1 = new TuitionClass(className, new ClassTiming("MON 15:00-16:00"), location, rate);
        TuitionClass class2 = new TuitionClass(className, new ClassTiming("MON 17:00-18:00"), location, rate);
        assertFalse(class1.isOverlapping(class2));
        assertFalse(class2.isOverlapping(class1));
    }

    @Test
    public void isOverlapping_sameDayBackToBack_returnsFalse() {
        TuitionClass class1 = new TuitionClass(className, new ClassTiming("MON 15:00-17:00"), location, rate);
        TuitionClass class2 = new TuitionClass(className, new ClassTiming("MON 17:00-18:00"), location, rate);
        assertFalse(class1.isOverlapping(class2));
        assertFalse(class2.isOverlapping(class1));
    }
}
