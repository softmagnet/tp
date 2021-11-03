package seedu.address.logic.commands.classcommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.classcommands.RemoveFromClassCommand.MESSAGE_REMOVE_SUCCESS;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TestUtil.getIndexList;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Student;
import seedu.address.model.person.UniqueStudentList;
import seedu.address.model.tuitionclass.ClassName;
import seedu.address.model.tuitionclass.ClassTiming;
import seedu.address.model.tuitionclass.Location;
import seedu.address.model.tuitionclass.Rate;
import seedu.address.model.tuitionclass.StudentNameList;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.model.tuitionclass.UniqueClassList;
import seedu.address.testutil.TypicalTimestable;

public class RemoveFromClassCommandTest {


    @Test
    public void constructor_nullInput_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new RemoveFromClassCommand(null));
    }

    @Test
    public void execute_removeSingleStudent_success() {
        // model stub with a class containing ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE.
        Model model = new ModelStubWithClass(TypicalTimestable.getTypicalPersons());

        // command to execute
        RemoveFromClassCommand command = new RemoveFromClassCommand(getIndexList(1, 1));

        // expected model
        List<Student> studentList = TypicalTimestable.getTypicalPersons();
        studentList.remove(TypicalTimestable.ALICE);
        Model expectedModel = new ModelStubWithClass(studentList);

        String expectedMessage = MESSAGE_REMOVE_SUCCESS;
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_removeMultipleStudents_success() {
        // model stub with a class containing ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE.
        Model model = new ModelStubWithClass(TypicalTimestable.getTypicalPersons());

        // command to execute
        RemoveFromClassCommand command = new RemoveFromClassCommand(getIndexList(1, 1, 3));

        // expected model
        List<Student> studentList = TypicalTimestable.getTypicalPersons();
        studentList.remove(TypicalTimestable.ALICE);
        studentList.remove(TypicalTimestable.CARL);
        Model expectedModel = new ModelStubWithClass(studentList);

        String expectedMessage = MESSAGE_REMOVE_SUCCESS;
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_duplicateStudentIndexes_success() {
        // model stub with a class containing ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE.
        Model model = new ModelStubWithClass(TypicalTimestable.getTypicalPersons());

        // command to execute
        RemoveFromClassCommand command = new RemoveFromClassCommand(getIndexList(1, 1, 3, 1));

        // expected model
        List<Student> studentList = TypicalTimestable.getTypicalPersons();
        studentList.remove(TypicalTimestable.ALICE);
        studentList.remove(TypicalTimestable.CARL);
        Model expectedModel = new ModelStubWithClass(studentList);

        String expectedMessage = MESSAGE_REMOVE_SUCCESS;
        assertCommandSuccess(command, model, expectedMessage, expectedModel);

    }

    @Test
    public void execute_studentIndexGreaterThanNumberOfStudents_throwsCommandException() {
        // model stub with a class containing ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE.
        Model model = new ModelStubWithClass(TypicalTimestable.getTypicalPersons());

        // command to execute
        RemoveFromClassCommand command = new RemoveFromClassCommand(getIndexList(1, 8));

        String expectedMessage = Messages.MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX;
        assertThrows(CommandException.class, expectedMessage, () -> command.execute(model));
    }


    @Test
    public void execute_classIndexGreaterThanClassNumber_throwsCommandException() {
        // model stub with a class containing ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE.
        Model model = new ModelStubWithClass(TypicalTimestable.getTypicalPersons());

        // command to execute
        RemoveFromClassCommand command = new RemoveFromClassCommand(getIndexList(2, 1));

        String expectedMessage = Messages.MESSAGE_INVALID_CLASS_DISPLAYED_INDEX;
        assertThrows(CommandException.class, expectedMessage, () -> command.execute(model));
    }

    @Test
    public void execute_removeSingleStudentFromEmptyClass_failure() {
        // model stub with a empty class;
        Model model = new ModelStubWithClass(new ArrayList<Student>());

        // command to execute
        RemoveFromClassCommand command = new RemoveFromClassCommand(getIndexList(1, 1));

        String expectedMessage = Messages.MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX;
        assertThrows(CommandException.class, expectedMessage, () -> command.execute(model));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
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
        public void setAddressBook(ReadOnlyAddressBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
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
    private class ModelStubWithClass extends ModelStub {
        private TuitionClass tuitionClass;
        private List<Student> studentList;

        ModelStubWithClass(List<Student> studentList) {
            requireNonNull(studentList);
            this.studentList = studentList;
            Name[] names = studentList.stream().map(Person::getName)
                    .collect(Collectors.toList()).toArray(new Name[]{});
            StudentNameList nameList = new StudentNameList(names);

            this.tuitionClass = new TuitionClass(new ClassName("class"), new ClassTiming("MON 13:30-14:30"),
                    new Location("Home"), new Rate("60"), nameList);
        }

        @Override
        public ObservableList<TuitionClass> getFilteredTuitionClassList() {
            UniqueClassList classList = new UniqueClassList();
            classList.add(this.tuitionClass);

            return new FilteredList<>(classList.asUnmodifiableObservableList());
        }

        @Override
        public ObservableList<Student> getFilteredStudentList() {
            UniqueStudentList studentList = new UniqueStudentList();
            for (Student student : this.studentList) {
                studentList.add(student);
            }
            return new FilteredList<>(studentList.asUnmodifiableObservableList());
        }

        @Override
        public void setClass(TuitionClass classToRemoveFrom, TuitionClass editedClass) {
            this.tuitionClass = editedClass;
        }

        @Override
        public boolean equals(Object obj) {
            // short circuit if same object
            if (obj == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(obj instanceof ModelStubWithClass)) {
                return false;
            }

            // state check
            ModelStubWithClass other = (ModelStubWithClass) obj;
            return this.tuitionClass.equals(other.tuitionClass);
        }
    }
}
