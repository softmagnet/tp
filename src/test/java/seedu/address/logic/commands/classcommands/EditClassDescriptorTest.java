package seedu.address.logic.commands.classcommands;

import org.junit.jupiter.api.Test;
import seedu.address.testutil.EditClassDescriptorBuilder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.DESC_IB_MATHS;
import static seedu.address.logic.commands.CommandTestUtil.DESC_IB_PHYSICS;
import static seedu.address.logic.commands.CommandTestUtil.VALID_CLASSNAME_IB_MATHS;
import static seedu.address.logic.commands.CommandTestUtil.VALID_CLASSTIMING_IB_MATHS;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LOCATION_IB_MATHS;
import static seedu.address.logic.commands.CommandTestUtil.VALID_RATE_IB_MATHS;
import static seedu.address.logic.commands.CommandTestUtil.VALID_STUDENTLIST_IB_MATHS;
import static seedu.address.logic.commands.classcommands.EditClassCommand.EditClassDescriptor;

public class EditClassDescriptorTest {

    @Test
    public void equals() {
        // same values -> returns true
        EditClassDescriptor descriptorWithSameValues = new EditClassDescriptor(DESC_IB_MATHS);
        assertTrue(DESC_IB_MATHS.equals(descriptorWithSameValues));

        // same object -> returns true
        assertTrue(DESC_IB_MATHS.equals(DESC_IB_MATHS));

        // null -> returns false
        assertFalse(DESC_IB_MATHS.equals(null));

        // different types -> returns false
        assertFalse(DESC_IB_MATHS.equals(5));

        // different values -> returns false
        assertFalse(DESC_IB_MATHS.equals(DESC_IB_PHYSICS));

        // different class name -> returns false
        EditClassDescriptor editedIBPhysics = new EditClassDescriptorBuilder(DESC_IB_PHYSICS)
                .withClassName(VALID_CLASSNAME_IB_MATHS).build();
        assertFalse(DESC_IB_PHYSICS.equals(editedIBPhysics));

        // different class timing -> returns false
        editedIBPhysics = new EditClassDescriptorBuilder(DESC_IB_PHYSICS)
                .withClassTiming(VALID_CLASSTIMING_IB_MATHS).build();
        assertFalse(DESC_IB_PHYSICS.equals(editedIBPhysics));

        // different rate -> returns false
        editedIBPhysics = new EditClassDescriptorBuilder(DESC_IB_PHYSICS)
                .withRate(VALID_RATE_IB_MATHS).build();
        assertFalse(DESC_IB_PHYSICS.equals(editedIBPhysics));

        //different location -> returns false
        editedIBPhysics = new EditClassDescriptorBuilder(DESC_IB_PHYSICS)
                .withLocation(VALID_LOCATION_IB_MATHS).build();
        assertFalse(DESC_IB_PHYSICS.equals(editedIBPhysics));

        //different student list -> returns false
        editedIBPhysics = new EditClassDescriptorBuilder(DESC_IB_PHYSICS)
                .withStudentList(VALID_STUDENTLIST_IB_MATHS).build();
        assertFalse(DESC_IB_PHYSICS.equals(editedIBPhysics));

    }
}
