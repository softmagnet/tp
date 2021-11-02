package seedu.address.logic.commands.classcommands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_CLASS_DISPLAYED_INDEX;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.classcommands.AddToClassCommand.MESSAGE_ADD_SUCCESS;
import static seedu.address.logic.commands.classcommands.EditClassCommand.MESSAGE_DUPLICATE_STUDENT;
import static seedu.address.testutil.TestUtil.getClassOneBased;
import static seedu.address.testutil.TestUtil.getIndexList;
import static seedu.address.testutil.TestUtil.getStudentOneBased;
import static seedu.address.testutil.TypicalTimestable.BENSON;
import static seedu.address.testutil.TypicalTimestable.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ClearCommand;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.testutil.TuitionClassBuilder;



public class AddToClassCommandTest {



    @Test
    public void execute_addSingleStudentToClass_success() {
        //create model to used in actual execution
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

        //create command to be tested
        AddToClassCommand addToClassCommand = new AddToClassCommand(getIndexList(1, 3));

        //create expected model by manually setting target class to updated class
        Model expectedModel = new ModelManager(new AddressBook(getTypicalAddressBook()), new UserPrefs());
        TuitionClass classToAddto = getClassOneBased(expectedModel, 1);
        TuitionClass editedClass = new TuitionClassBuilder(classToAddto)
                .withStudentList(classToAddto.getStudentList().getNames()).build();
        editedClass.addStudent(getStudentOneBased(model, 3).getName());
        expectedModel.setClass(classToAddto, editedClass);

        //run assertCommand function with corresponding message
        String expectedMessage = MESSAGE_ADD_SUCCESS;
        assertCommandSuccess(addToClassCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_addMultipleStudentsToClass_success() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

        AddToClassCommand addToClassCommand = new AddToClassCommand(getIndexList(2, 1, 2));

        Model expectedModel = new ModelManager(new AddressBook(getTypicalAddressBook()), new UserPrefs());
        TuitionClass classToAddto = getClassOneBased(expectedModel, 2);
        TuitionClass editedClass = new TuitionClassBuilder(classToAddto)
                .withStudentList(classToAddto.getStudentList().getNames()).build();
        editedClass.addAllStudents(
                getStudentOneBased(model, 1).getName(),
                getStudentOneBased(model, 2).getName()
        );
        expectedModel.setClass(classToAddto, editedClass);

        String expectedMessage = MESSAGE_ADD_SUCCESS;
        assertCommandSuccess(addToClassCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_classIndexOutOfRange_failure() {
        Model failureModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        AddToClassCommand addToClassCommand = new AddToClassCommand(getIndexList(22, 1, 2));
        assertCommandFailure(addToClassCommand, failureModel, MESSAGE_INVALID_CLASS_DISPLAYED_INDEX);
    }

    @Test
    public void execute_indexOutOfRange_failure() {
        Model failureModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        AddToClassCommand addToClassCommand = new AddToClassCommand(getIndexList(1, 12, 2));
        assertCommandFailure(addToClassCommand, failureModel, MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX);
    }

    @Test
    public void execute_addDuplicateStudentsToClass_failure() {
        Model failureModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

        //student indexed 1 is already in class indexed 1
        AddToClassCommand addToClassCommand = new AddToClassCommand(getIndexList(1, 2, 3));

        String expectedMessage = MESSAGE_DUPLICATE_STUDENT + BENSON.getName();
        assertCommandFailure(addToClassCommand, failureModel, expectedMessage);
    }

    @Test
    public void equals() {
        AddToClassCommand standardCommand = new AddToClassCommand(getIndexList(1, 2, 3));

        // failure

        //null returns false
        assertFalse(standardCommand.equals(null));

        //different value returns false
        assertFalse(standardCommand.equals(new AddToClassCommand(getIndexList(1, 4, 3))));

        //different command returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // success

        //same obj returns true
        assertTrue(standardCommand.equals(standardCommand));

        //same value returns true
        assertTrue(standardCommand.equals(new AddToClassCommand(getIndexList(1, 2, 3))));
    }






}

