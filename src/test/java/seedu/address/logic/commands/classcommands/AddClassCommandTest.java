package seedu.address.logic.commands.classcommands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.person.Name;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.testutil.AddressBookBuilder;
import seedu.address.testutil.TuitionClassBuilder;

public class AddClassCommandTest {

    @Test
    public void constructor_nullTuitionClass_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddClassCommand(null));
    }

    @Test
    public void execute_tuitionClassAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingTuitionClassAdded modelStub = new ModelStubAcceptingTuitionClassAdded();

        //create TuitionClass to be added
        TuitionClass classToAdd = new TuitionClassBuilder().build();
        CommandResult commandResult = new AddClassCommand(classToAdd).execute(modelStub);

        assertEquals(String.format(AddClassCommand.MESSAGE_SUCCESS, classToAdd), commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(classToAdd), modelStub.tuitionClassesAdded);
    }

    @Test
    public void execute_duplicateTuitionClass_throwsCommandException() {
        TuitionClass validTuitionClass = new TuitionClassBuilder().build();
        AddClassCommand addClassCommand = new AddClassCommand(validTuitionClass);
        ModelStub modelStub = new ModelStubWithTuitionClass(validTuitionClass);

        assertThrows(CommandException.class, Messages.MESSAGE_CLASHING_CLASS_TIMING, ()
            -> addClassCommand.execute(modelStub));
    }

    @Test
    public void execute_tuitionClassWithOverlappingClassTiming_throwsCommandException() {
        TuitionClass validTuitionClass1 = new TuitionClassBuilder().withClassTiming("SUN 11:30-13:30").build();
        TuitionClass validTuitionClass2 = new TuitionClassBuilder().withClassTiming("SUN 09:30-12:00").build();
        AddClassCommand addClassCommand = new AddClassCommand(validTuitionClass2);
        ModelStub modelStub = new ModelStubWithTuitionClass(validTuitionClass1);

        assertThrows(CommandException.class, Messages.MESSAGE_CLASHING_CLASS_TIMING, ()
            -> addClassCommand.execute(modelStub));
    }

    @Test
    public void equals_className() {
        TuitionClass classTiming13 = new TuitionClassBuilder().withClassName("Maths").build();
        TuitionClass classTiming12 = new TuitionClassBuilder().withClassName("Timing13").build();
        AddClassCommand addTiming12ClassCommand = new AddClassCommand(classTiming13);
        AddClassCommand addTiming13ClassCommand = new AddClassCommand(classTiming12);

        // same object -> returns true
        assertTrue(addTiming12ClassCommand.equals(addTiming12ClassCommand));

        // same values -> returns true
        AddClassCommand addTiming12ClassCommandCopy = new AddClassCommand(classTiming13);
        assertTrue(addTiming12ClassCommand.equals(addTiming12ClassCommandCopy));

        // different types -> returns false
        assertFalse(addTiming12ClassCommand.equals("null"));

        // null -> returns false
        assertFalse(addTiming12ClassCommand.equals(null));

        // different tuition class -> returns false
        assertFalse(addTiming12ClassCommand.equals(addTiming13ClassCommand));
    }

    @Test
    public void equals_classTiming() {
        TuitionClass classTiming12 = new TuitionClassBuilder().withClassTiming("TUE 12:00-13:30").build();
        TuitionClass classTiming13 = new TuitionClassBuilder().withClassTiming("TUE 13:00-15:00").build();
        AddClassCommand addTiming12ClassCommand = new AddClassCommand(classTiming12);
        AddClassCommand addTiming13ClassCommand = new AddClassCommand(classTiming13);

        // same object -> returns true
        assertTrue(addTiming12ClassCommand.equals(addTiming12ClassCommand));

        // same values -> returns true
        AddClassCommand addTiming12ClassCommandCopy = new AddClassCommand(classTiming12);
        assertTrue(addTiming12ClassCommand.equals(addTiming12ClassCommandCopy));

        // different types -> returns false
        assertFalse(addTiming12ClassCommand.equals("null"));

        // null -> returns false
        assertFalse(addTiming12ClassCommand.equals(null));

        // different tuition class -> returns false
        assertFalse(addTiming12ClassCommand.equals(addTiming13ClassCommand));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getAddressBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPerson(Student student) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPerson(Student student) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePerson(Student target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasTuitionClass(TuitionClass tuitionClass) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addTuitionClass(TuitionClass tuitionClass) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteTuitionClass(TuitionClass target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPerson(Student target, Student editedStudent) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Student> getFilteredStudentList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredStudentList(Predicate<Student> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredClassList(Predicate<TuitionClass> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<TuitionClass> getFilteredTuitionClassList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setClass(TuitionClass target, TuitionClass editedClass) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void replaceFilteredStudentList(List<Student> studentList) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void replaceFilteredTuitionClassList(List<TuitionClass> tuitionClassList) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setClasses(List<TuitionClass> classes) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setStudents(List<Student> students) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateClassStudentLists(Name newName, Name oldName) {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single tuition class.
     */
    private class ModelStubWithTuitionClass extends ModelStub {
        private final AddressBook addressBook;

        ModelStubWithTuitionClass(TuitionClass tuitionClass) {
            requireNonNull(tuitionClass);
            this.addressBook = new AddressBookBuilder().withTuitionClass(tuitionClass).build();
        }

        @Override
        public void addTuitionClass(TuitionClass tuitionClass) {
            addressBook.addTuitionClass(tuitionClass);
        }
    }

    /**
     * A Model stub that always accept the person being added.
     */
    private class ModelStubAcceptingTuitionClassAdded extends ModelStub {
        //final ArrayList<Student> personsAdded = new ArrayList<>();
        final ArrayList<TuitionClass> tuitionClassesAdded = new ArrayList<>();

        @Override
        public void addTuitionClass(TuitionClass tuitionClass) {
            requireNonNull(tuitionClass);
            tuitionClassesAdded.add(tuitionClass);
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            return new AddressBook();
        }
    }
}
