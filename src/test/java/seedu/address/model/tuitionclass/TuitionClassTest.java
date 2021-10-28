package seedu.address.model.tuitionclass;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_CLASSNAME_IB_MATHS;
import static seedu.address.logic.commands.CommandTestUtil.VALID_CLASSTIMING_IB_MATHS;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LOCATION_IB_MATHS;
import static seedu.address.logic.commands.CommandTestUtil.VALID_RATE_IB_MATHS;
import static seedu.address.logic.commands.CommandTestUtil.VALID_STUDENTLIST_IB_MATHS;
import static seedu.address.testutil.TypicalTimestable.IB_MATHS;
import static seedu.address.testutil.TypicalTimestable.IB_PHYSICS;

import org.junit.jupiter.api.Test;
import seedu.address.testutil.TuitionClassBuilder;

public class TuitionClassTest {
    private ClassName className = new ClassName("test");
    private Location location = new Location("test");
    private Rate rate = new Rate("50");

    @Test
    public void isSameClass() {
        //same object -> returns true
        assertTrue(IB_PHYSICS.isSameClass(IB_PHYSICS));

        //null -> returns false
        assertFalse(IB_PHYSICS.isSameClass(null));

        //same class timing, all other attribtues different -> returns true
        TuitionClass editedIBPhysics = new TuitionClassBuilder(IB_PHYSICS).withClassName(VALID_CLASSNAME_IB_MATHS)
                .withLocation(VALID_LOCATION_IB_MATHS).withRate(VALID_RATE_IB_MATHS)
                .withStudentList(VALID_STUDENTLIST_IB_MATHS).build();
        assertTrue(IB_PHYSICS.isSameClass(editedIBPhysics));

        //different class timing, all other attributes same -> returns false
        editedIBPhysics = new TuitionClassBuilder(IB_PHYSICS).withClassTiming(VALID_CLASSTIMING_IB_MATHS).build();
        assertFalse(IB_PHYSICS.isSameClass(editedIBPhysics));
    }

    @Test
    public void equals() {
        // same values -> returns true
        TuitionClass IBPhysicsCopy = new TuitionClassBuilder(IB_PHYSICS).build();
        assertTrue(IB_PHYSICS.equals(IBPhysicsCopy));

        // same object -> returns true
        assertTrue(IB_PHYSICS.equals(IB_PHYSICS));

        // null -> returns false
        assertFalse(IB_PHYSICS.equals(null));

        // different type -> returns false
        assertFalse(IB_PHYSICS.equals(5));

        // different classes -> returns false
        assertFalse(IB_PHYSICS.equals(IB_MATHS));

        // different class name -> returns false
        TuitionClass editedIBPhysics = new TuitionClassBuilder(IB_PHYSICS).withClassName(VALID_CLASSNAME_IB_MATHS)
                .build();
        assertFalse(IB_PHYSICS.equals(editedIBPhysics));

        // different class timing -> returns false
        editedIBPhysics = new TuitionClassBuilder(IB_PHYSICS).withClassTiming(VALID_CLASSTIMING_IB_MATHS)
                .build();
        assertFalse(IB_PHYSICS.equals(editedIBPhysics));

        // different rate -> returns false
        editedIBPhysics = new TuitionClassBuilder(IB_PHYSICS).withRate(VALID_RATE_IB_MATHS)
                .build();
        assertFalse(IB_PHYSICS.equals(editedIBPhysics));

        // different location -> returns false
        editedIBPhysics = new TuitionClassBuilder(IB_PHYSICS).withLocation(VALID_LOCATION_IB_MATHS)
                .build();
        assertFalse(IB_PHYSICS.equals(editedIBPhysics));

        // different student list -> returns false
        editedIBPhysics = new TuitionClassBuilder(IB_PHYSICS).withStudentList(VALID_STUDENTLIST_IB_MATHS)
                .build();
        assertFalse(IB_PHYSICS.equals(editedIBPhysics));
    }


    //// isOverlapping
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
