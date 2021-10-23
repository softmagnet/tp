package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_PERSONS_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BENSON;
import static seedu.address.testutil.TypicalPersons.CARL;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.ClassTimingContainsKeywordsPredicate;

/**
 * Contains integration tests (interaction with the Model) for {@code ScheduleCommand}.
 */
public class ScheduleCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void equals() {
        ClassTimingContainsKeywordsPredicate firstPredicate =
                new ClassTimingContainsKeywordsPredicate(Collections.singletonList("first"));
        ClassTimingContainsKeywordsPredicate secondPredicate =
                new ClassTimingContainsKeywordsPredicate(Collections.singletonList("second"));

        ScheduleCommand scheduleFirstCommand = new ScheduleCommand(firstPredicate);
        ScheduleCommand scheduleSecondCommand = new ScheduleCommand(secondPredicate);

        // same object -> returns true
        assertTrue(scheduleFirstCommand.equals(scheduleFirstCommand));

        // same values -> returns true
        ScheduleCommand scheduleFirstCommandCopy = new ScheduleCommand(firstPredicate);
        assertTrue(scheduleFirstCommand.equals(scheduleFirstCommandCopy));

        // different types -> returns false
        assertFalse(scheduleFirstCommand.equals(1));

        // null -> returns false
        assertFalse(scheduleFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(scheduleFirstCommand.equals(scheduleSecondCommand));
    }

    @Test
    public void execute_zeroKeywords_noPersonFound() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 0);
        ClassTimingContainsKeywordsPredicate predicate = preparePredicate(" ");
        ScheduleCommand command = new ScheduleCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), model.getFilteredStudentList());
    }

    @Test
    public void execute_multipleKeywords_multiplePersonsFound() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 3);
        ClassTimingContainsKeywordsPredicate predicate = preparePredicate("mon tue");
        ScheduleCommand command = new ScheduleCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(ALICE, BENSON, CARL), model.getFilteredStudentList());
    }

    /**
     * Parses {@code userInput} into a {@code ClassTimingContainsKeywordsPredicate}.
     */
    private ClassTimingContainsKeywordsPredicate preparePredicate(String userInput) {
        return new ClassTimingContainsKeywordsPredicate(Arrays.asList(userInput.split("\\s+")));
    }
}
