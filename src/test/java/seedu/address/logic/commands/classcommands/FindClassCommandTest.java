package seedu.address.logic.commands.classcommands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalTimestable.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.tuitionclass.predicates.ClassTimingContainsKeywordsPredicate;

/**
 * Contains integration tests (interaction with the Model) for {@code FindCommand}.
 */
public class FindClassCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void equals() {
        ClassTimingContainsKeywordsPredicate firstPredicate =
                new ClassTimingContainsKeywordsPredicate(Collections.singletonList("first"));
        ClassTimingContainsKeywordsPredicate secondPredicate =
                new ClassTimingContainsKeywordsPredicate(Collections.singletonList("second"));

        FindClassCommand findClassFirstCommand = new FindClassCommand(firstPredicate);
        FindClassCommand findClassSecondCommand = new FindClassCommand(secondPredicate);

        // same object -> returns true
        assertTrue(findClassFirstCommand.equals(findClassFirstCommand));

        // same values -> returns true
        FindClassCommand findClassFirstCommandCopy = new FindClassCommand(firstPredicate);
        assertTrue(findClassFirstCommand.equals(findClassFirstCommandCopy));

        // different types -> returns false
        assertFalse(findClassFirstCommand.equals(1));

        // null -> returns false
        assertFalse(findClassFirstCommand.equals(null));

        // different predicate with different list of keywords -> returns false
        assertFalse(findClassFirstCommand.equals(findClassSecondCommand));
    }

    //    //todo for kevin to fix these tests (currently there are things in the model at the start
    //    @Test
    //    public void execute_zeroKeywords_noPersonFound() {
    //        String expectedMessage = String.format(MESSAGE_CLASSES_LISTED_OVERVIEW, 0);
    //        ClassTimingContainsKeywordsPredicate predicate = preparePredicate(" ");
    //        FindClassCommand command = new FindClassCommand(predicate);
    //        expectedModel.updateFilteredClassList(predicate);
    //        assertCommandSuccess(command, model, expectedMessage, expectedModel);
    //        assertEquals(Collections.emptyList(), model.getFilteredStudentList());
    //    }
    //
    //    @Test
    //    public void execute_multipleKeywords_multiplePersonsFound() {
    //        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 3);
    //        NameContainsKeywordsPredicate predicate = preparePredicate("Kurz Elle Kunz");
    //        FindNameCommand command = new FindNameCommand(predicate);
    //        expectedModel.updateFilteredPersonList(predicate);
    //        assertCommandSuccess(command, model, expectedMessage, expectedModel);
    //        assertEquals(Arrays.asList(CARL, ELLE, FIONA), model.getFilteredStudentList());
    //    }

    /**
     * Parses {@code userInput} into a {@code NameContainsKeywordsPredicate}.
     */
    private ClassTimingContainsKeywordsPredicate preparePredicate(String userInput) {
        return new ClassTimingContainsKeywordsPredicate(Arrays.asList(userInput.split("\\s+")));
    }
}
