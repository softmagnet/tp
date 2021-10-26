package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SortCommandTest {

    @Test
    void execute() {
        //Todo discuss how to implement this since it doesnt touch the model.
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
