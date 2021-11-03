package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Name;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.TuitionClass;

/**
 * Represents the in-memory model of the address book data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final AddressBook addressBook;
    private final UserPrefs userPrefs;
    private FilteredList<Student> filteredStudents;
    private FilteredList<TuitionClass> filteredTuitionClass;


    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public ModelManager(ReadOnlyAddressBook addressBook, ReadOnlyUserPrefs userPrefs) {
        super();
        requireAllNonNull(addressBook, userPrefs);

        logger.fine("Initializing with address book: " + addressBook + " and user prefs " + userPrefs);

        this.addressBook = new AddressBook(addressBook);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredStudents = new FilteredList<>(this.addressBook.getPersonList());
        filteredTuitionClass =
                new FilteredList<>(this.addressBook.getTuitionClassList());
    }

    public ModelManager() {
        this(new AddressBook(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getAddressBookFilePath() {
        return userPrefs.getAddressBookFilePath();
    }

    @Override
    public void setAddressBookFilePath(Path addressBookFilePath) {
        requireNonNull(addressBookFilePath);
        userPrefs.setAddressBookFilePath(addressBookFilePath);
    }

    //=========== AddressBook ================================================================================

    @Override
    public ReadOnlyAddressBook getAddressBook() {
        return addressBook;
    }

    @Override
    public void setAddressBook(ReadOnlyAddressBook addressBook) {
        this.addressBook.resetData(addressBook);
    }

    @Override
    public boolean hasPerson(Student student) {
        requireNonNull(student);
        return addressBook.hasPerson(student);
    }

    @Override
    public boolean hasTuitionClass(TuitionClass tuitionClass) {
        requireNonNull(tuitionClass);
        return addressBook.hasTuitionClass(tuitionClass);
    }

    @Override
    public void deletePerson(Student target) {
        addressBook.removePerson(target);
    }

    @Override
    public void addPerson(Student student) {
        addressBook.addStudent(student);
        updateFilteredStudentList(PREDICATE_SHOW_ALL_PERSONS);
    }

    @Override
    public void addTuitionClass(TuitionClass tuitionClass) {
        addressBook.addTuitionClass(tuitionClass);
        updateFilteredClassList(PREDICATE_SHOW_ALL_CLASS);
    }

    @Override
    public void deleteTuitionClass(TuitionClass tuitionClass) {
        addressBook.deleteTuitionClass(tuitionClass);
    }

    @Override
    public void setPerson(Student target, Student editedStudent) {
        requireAllNonNull(target, editedStudent);

        addressBook.setPerson(target, editedStudent);
    }

    //=========== Filtered Person List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Person} backed by the internal list of
     * {@code versionedAddressBook}
     */
    @Override
    public ObservableList<Student> getFilteredStudentList() {
        return filteredStudents;
    }

    @Override
    public void updateFilteredStudentList(Predicate<Student> predicate) {
        requireNonNull(predicate);
        filteredStudents.setPredicate(predicate);
    }

    @Override
    public void replaceFilteredStudentList(List<Student> studentList) {
        ObservableList<Student> newList = FXCollections.observableArrayList();
        newList.addAll(studentList);
        this.filteredStudents = new FilteredList<>(newList);
    }

    @Override
    public void updateFilteredClassList(Predicate<TuitionClass> predicate) {
        requireNonNull(predicate);
        filteredTuitionClass.setPredicate(predicate);
    }

    @Override
    public void replaceFilteredTuitionClassList(List<TuitionClass> tuitionClassList) {
        ObservableList<TuitionClass> newList = FXCollections.observableArrayList();
        newList.addAll(tuitionClassList);
        this.filteredTuitionClass = new FilteredList<>(newList);
    }

    @Override
    public void updateClassStudentLists(Name newName, Name oldName) {
        requireAllNonNull(newName, oldName);
        if (newName.equals(oldName)) {
            return;
        }
        addressBook.updateClassStudentLists(newName, oldName);
    }

    @Override
    public ObservableList<TuitionClass> getFilteredTuitionClassList() {
        return filteredTuitionClass;
    }

    @Override
    public void setClass(TuitionClass target, TuitionClass editedClass) {
        requireAllNonNull(target, editedClass);
        addressBook.setClass(target, editedClass);
        updateFilteredClassList(PREDICATE_SHOW_ALL_CLASS);
    }

    @Override
    public void setClasses(List<TuitionClass> classes) {
        addressBook.setClasses(classes);
    }

    @Override
    public void setStudents(List<Student> studentsList) {
        addressBook.setStudents(studentsList);
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return addressBook.equals(other.addressBook)
                && userPrefs.equals(other.userPrefs)
                && filteredStudents.equals(other.filteredStudents)
                && filteredTuitionClass.equals(other.filteredTuitionClass);
    }

}
