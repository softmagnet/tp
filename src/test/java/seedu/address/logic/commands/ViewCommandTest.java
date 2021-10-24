package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ViewCommandTest {

    private int studentsIndex = 0;
    private int timetableIndex = 1;
    private int classesIndex = 2;

    @Test
    void execute() {
       //Todo discuss how to implement this since it doesnt touch the model.
    }

    @Test
    void testEquals() {
        ViewCommand viewTimetable = new ViewCommand(timetableIndex);
        ViewCommand viewStudents = new ViewCommand(studentsIndex);
        ViewCommand viewClasses = new ViewCommand(classesIndex);

        //same object
        assertTrue(viewClasses.equals(viewClasses));
        assertTrue(viewTimetable.equals(viewTimetable));
        assertTrue(viewStudents.equals(viewStudents));

        //same values
        assertTrue(new ViewCommand(timetableIndex).equals(viewTimetable));
        assertTrue(new ViewCommand(studentsIndex).equals(viewStudents));
        assertTrue(new ViewCommand(classesIndex).equals(viewClasses));

        //different types
        assertFalse(viewClasses.equals(1));

        //null
        assertFalse(viewClasses.equals(null));

        //different values
        assertFalse(viewClasses.equals(viewStudents));

    }
}
