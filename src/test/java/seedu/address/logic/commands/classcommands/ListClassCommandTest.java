package seedu.address.logic.commands.classcommands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showClassAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST;
import static seedu.address.testutil.TypicalTimestable.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

class ListClassCommandTest {
    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_classListIsNotFiltered_showsSameList() {
        assertCommandSuccess(new ListClassCommand(), model, ListClassCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_classListIsFiltered_showsEverything() {
        showClassAtIndex(model, INDEX_FIRST);
        assertCommandSuccess(new ListClassCommand(), model, ListClassCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
