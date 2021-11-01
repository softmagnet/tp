package seedu.address.logic.commands.classcommands;

import org.junit.jupiter.api.Test;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.testutil.TuitionClassBuilder;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.classcommands.AddToClassCommand.MESSAGE_ADD_SUCCESS;
import static seedu.address.testutil.TestUtil.getClassOneBased;
import static seedu.address.testutil.TestUtil.getIndexList;
import static seedu.address.testutil.TestUtil.getStudentOneBased;
import static seedu.address.testutil.TypicalTimestable.getTypicalAddressBook;

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
        //create model to used in actual execution
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

        //create command to be tested
        AddToClassCommand addToClassCommand = new AddToClassCommand(getIndexList(2, 1, 2));

        //create expected model by manually setting target class to updated class
        Model expectedModel = new ModelManager(new AddressBook(getTypicalAddressBook()), new UserPrefs());
        TuitionClass classToAddto = getClassOneBased(expectedModel, 2);
        TuitionClass editedClass = new TuitionClassBuilder(classToAddto)
                .withStudentList(classToAddto.getStudentList().getNames()).build();
        editedClass.addAllStudents(
                getStudentOneBased(model, 1).getName(),
                getStudentOneBased(model, 2).getName()
        );
        expectedModel.setClass(classToAddto, editedClass);

        //run assertCommand function with corresponding message
        String expectedMessage = MESSAGE_ADD_SUCCESS;
        assertCommandSuccess(addToClassCommand, model, expectedMessage, expectedModel);
    }
}

