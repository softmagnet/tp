package seedu.address.model.tuitionclass;

import static java.util.Objects.requireNonNull;

import java.util.HashMap;
import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import seedu.address.model.person.Name;
import seedu.address.model.person.Student;


/**
 * Represents the list of students that a tuition {@code TuitionClass} has.
 */
public class UniqueStudentList implements Iterable<Student> {

    private final ObservableMap<Name, Student> internalMap = FXCollections.observableMap(new HashMap<>());
    private final ObservableMap<Name, Student> internalUnmodifiableMap =
            FXCollections.unmodifiableObservableMap(internalMap);

    /**
     * Constructs a {@code StudentList} using a HashMap of {@code Students}.
     *
     * @param students List of students to be added.
     */
    public UniqueStudentList(Student... students) {
        for (Student student : students) {
            internalMap.put(student.getName(), student);
        }
    }

    /**
     * Adds a student to the list.
     *
     * @param student The student to add to the list.
     */
    public void add(Student student) {
        requireNonNull(student);
        internalMap.put(student.getName(), student);
    }

    /**
     * Adds multiple students to the list.
     *
     * @param students The student to add to the list.
     */
    public void add(Student ...students) {
        requireNonNull(students);
        for (Student student : students) {
            internalMap.put(student.getName(), student);
        }
    }

    /**
     * Checks if there is a Student with the specified name.
     */
    public boolean doesStudentExist(Student student) {
        return internalMap.containsKey(student.getName());
    }

    /**
     * Checks if there is a Student with the specified name.
     */
    public boolean doesStudentExist(Name name) {
        return internalMap.containsKey(name);
    }

    /**
     * Returns the student with the specified name.
     */
    public Student getStudent(Name name) {
        requireNonNull(name);
        return internalMap.get(name);
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableMap<Name, Student> asUnmodifiableObservableMap() {
        return internalUnmodifiableMap;
    }

    @Override
    public Iterator<Student> iterator() {
        // Iterates through the values in the internalMap
        return internalMap.values().iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniqueStudentList // instanceof handles nulls
                && internalMap.equals(((UniqueStudentList) other).internalMap));
    }

    @Override
    public int hashCode() {
        return internalMap.hashCode();
    }
}
