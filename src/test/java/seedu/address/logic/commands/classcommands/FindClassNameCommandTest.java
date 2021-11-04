package seedu.address.logic.commands.classcommands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_CLASSES_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalTimestable.getTypicalAddressBook;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.tuitionclass.predicates.ClassNameContainsKeywordsPredicate;

public class FindClassNameCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_singleKeywords_noClassFound() {
        String expectedMessage = String.format(MESSAGE_CLASSES_LISTED_OVERVIEW, 0);
        ClassNameContainsKeywordsPredicate predicate = preparePredicate("Geography");
        FindClassNameCommand command = new FindClassNameCommand(predicate);
        expectedModel.updateFilteredClassList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_singleKeywords_multipleClassFound() {
        String expectedMessage = String.format(MESSAGE_CLASSES_LISTED_OVERVIEW, 2);
        ClassNameContainsKeywordsPredicate predicate = preparePredicate("Physics");
        FindClassNameCommand command = new FindClassNameCommand(predicate);
        expectedModel.updateFilteredClassList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_multipleKeywords_noClassFound() {
        String expectedMessage = String.format(MESSAGE_CLASSES_LISTED_OVERVIEW, 0);
        ClassNameContainsKeywordsPredicate predicate = preparePredicate("sec jc");
        FindClassNameCommand command = new FindClassNameCommand(predicate);
        expectedModel.updateFilteredClassList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_multipleKeywords_singleClassFound() {
        String expectedMessage = String.format(MESSAGE_CLASSES_LISTED_OVERVIEW, 1);
        ClassNameContainsKeywordsPredicate predicate = preparePredicate("jc physics");
        FindClassNameCommand command = new FindClassNameCommand(predicate);
        expectedModel.updateFilteredClassList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
    }

    @Test
    public void equals() {

        //same obj
        FindClassNameCommand command =
                new FindClassNameCommand(new ClassNameContainsKeywordsPredicate(Arrays.asList("Physics", "Maths")));
        assertTrue(command.equals(command));

        //same values
        FindClassNameCommand command2 =
                new FindClassNameCommand(new ClassNameContainsKeywordsPredicate(Arrays.asList("Physics", "Maths")));
        assertTrue(command.equals(command2));

        //different values
        command2 =
                new FindClassNameCommand(new ClassNameContainsKeywordsPredicate(Arrays.asList("Chemistry", "Maths")));
        assertFalse(command.equals(command2));
    }

    private ClassNameContainsKeywordsPredicate preparePredicate(String userInput) {
        return new ClassNameContainsKeywordsPredicate(Arrays.asList(userInput.split("\\s+")));
    }
}
