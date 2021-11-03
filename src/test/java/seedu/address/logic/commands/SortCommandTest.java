package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalTimestable.getTypicalAddressBook;
import static seedu.address.testutil.TypicalTimestable.getTypicalAddressBookReverseClasses;
import static seedu.address.testutil.TypicalTimestable.getTypicalAddressBookReverseStudents;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

class SortCommandTest {

    @Test
    void execute_nameInDescOrder_sortNameAsc() {
        Model model = new ModelManager(getTypicalAddressBookReverseStudents(), new UserPrefs());
        Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        String sortBy = "name";
        String directionOfSort = "asc";
        assertCommandSuccess(new SortCommand(sortBy, directionOfSort), model,
                String.format(SortCommand.MESSAGE_SUCCESS, "students", sortBy, directionOfSort), expectedModel);
    }

    @Test
    void execute_nameInAscOrder_sortNameAsc() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        String sortBy = "name";
        String directionOfSort = "asc";
        assertCommandSuccess(new SortCommand(sortBy, directionOfSort), model,
                String.format(SortCommand.MESSAGE_SUCCESS, "students", sortBy, directionOfSort), expectedModel);
    }

    @Test
    void execute_nameInDescOrder_sortNameDesc() {
        Model model = new ModelManager(getTypicalAddressBookReverseStudents(), new UserPrefs());
        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        String sortBy = "name";
        String directionOfSort = "desc";
        assertCommandSuccess(new SortCommand(sortBy, directionOfSort), model,
                String.format(SortCommand.MESSAGE_SUCCESS, "students", sortBy, directionOfSort), expectedModel);
    }

    @Test
    void execute_nameInAscOrder_sortNameDesc() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        Model expectedModel = new ModelManager(getTypicalAddressBookReverseStudents(), new UserPrefs());
        String sortBy = "name";
        String directionOfSort = "desc";
        assertCommandSuccess(new SortCommand(sortBy, directionOfSort), model,
                String.format(SortCommand.MESSAGE_SUCCESS, "students", sortBy, directionOfSort), expectedModel);
    }

    @Test
    void execute_classInAscOrder_sortTimingAsc() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        String sortBy = "timing";
        String directionOfSort = "asc";
        assertCommandSuccess(new SortCommand(sortBy, directionOfSort), model,
                String.format(SortCommand.MESSAGE_SUCCESS, "classes", sortBy, directionOfSort), expectedModel);
    }

    @Test
    void execute_classInDescOrder_sortTimingAsc() {
        Model model = new ModelManager(getTypicalAddressBookReverseClasses(), new UserPrefs());
        Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        String sortBy = "timing";
        String directionOfSort = "asc";
        assertCommandSuccess(new SortCommand(sortBy, directionOfSort), model,
                String.format(SortCommand.MESSAGE_SUCCESS, "classes", sortBy, directionOfSort), expectedModel);
    }

    @Test
    void execute_classInAscOrder_sortTimingDesc() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        Model expectedModel = new ModelManager(getTypicalAddressBookReverseClasses(), new UserPrefs());
        String sortBy = "timing";
        String directionOfSort = "desc";
        assertCommandSuccess(new SortCommand(sortBy, directionOfSort), model,
                String.format(SortCommand.MESSAGE_SUCCESS, "classes", sortBy, directionOfSort), expectedModel);
    }

    @Test
    void execute_classInDescOrder_sortTimingDesc() {
        Model model = new ModelManager(getTypicalAddressBookReverseClasses(), new UserPrefs());
        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        String sortBy = "timing";
        String directionOfSort = "desc";
        assertCommandSuccess(new SortCommand(sortBy, directionOfSort), model,
                String.format(SortCommand.MESSAGE_SUCCESS, "classes", sortBy, directionOfSort), expectedModel);
    }

    @Test
    void testEquals() {
        SortCommand sortNameAsc = new SortCommand("name", "asc");
        SortCommand sortNameDesc = new SortCommand("name", "desc");
        SortCommand sortTimingAsc = new SortCommand("timing", "asc");
        SortCommand sortTimingDesc = new SortCommand("timing", "desc");

        //same object
        assertTrue(sortNameAsc.equals(sortNameAsc));
        assertTrue(sortNameDesc.equals(sortNameDesc));
        assertTrue(sortTimingAsc.equals(sortTimingAsc));
        assertTrue(sortTimingDesc.equals(sortTimingDesc));

        //same values
        assertTrue(new SortCommand("name", "asc").equals(sortNameAsc));
        assertTrue(new SortCommand("name", "desc").equals(sortNameDesc));
        assertTrue(new SortCommand("timing", "asc").equals(sortTimingAsc));
        assertTrue(new SortCommand("timing", "desc").equals(sortTimingDesc));

        //different types
        assertFalse(sortNameAsc.equals(1));

        //null
        assertFalse(sortNameDesc.equals(null));

        //different values
        assertFalse(sortNameAsc.equals(sortNameDesc));
        assertFalse(sortNameDesc.equals(sortTimingAsc));
        assertFalse(sortTimingAsc.equals(sortTimingDesc));
        assertFalse(sortTimingDesc.equals(sortNameAsc));
    }
}
