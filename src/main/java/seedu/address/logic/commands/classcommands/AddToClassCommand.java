package seedu.address.logic.commands.classcommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CLASS_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;


import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Name;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.ClassName;
import seedu.address.model.tuitionclass.ClassTiming;
import seedu.address.model.tuitionclass.Location;
import seedu.address.model.tuitionclass.Rate;
import seedu.address.model.tuitionclass.StudentList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddToClassCommand extends Command {

    public static final String COMMAND_WORD = "addtoclass";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a student to a class.\n"
            + "Parameters: "
            + PREFIX_CLASS_NAME + "CLASS NAME "
            + PREFIX_NAME + "STUDENT NAME \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_CLASS_NAME + "401"
            + PREFIX_NAME + "John Doe";

    public static final String MESSAGE_ADD_SUCCESS = "New Student added: %1$s";
    public static final String MESSAGE_DUPLICATE_STUDENT = "This student is already in this class";

    private final Index toEditClassIndex;
    private final List<Index> studentIndices;

    public AddToClassCommand(ArrayList<Index> indexArray) {
        requireNonNull(indexArray);
        toEditClassIndex = indexArray.get(0);
        studentIndices = indexArray.subList(1, indexArray.size());
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {

        List<Student> lastShownStudentList = model.getFilteredPersonList();
        checkIndicesAreValid(studentIndices);
        ArrayList<Name> namesToAdd = createNameList(studentIndices, lastShownStudentList);

//        List<TuitionClass> lastShownStudentList = model.getFilteredClassList();

        return null;


    }

    private ArrayList<Name> createNameList(List<Index> studentIndices, List<Student> lastShownStudentList) {
        return null;
    }

    private void checkIndicesAreValid(List<Index> studentIndices) {
    }


    /**
     * Stores the names of the student and the class involved in an addToClassCommand.
     */
    public static class EditClassDescriptor {
        private ClassName className;
        private ClassTiming classTiming;
        private Location location;
        private Rate rate;
        private StudentList studentList;

        public EditClassDescriptor() {}

        public void setClassName() {
            this.className = className;
        }

        public Optional<ClassName> getClassName() {
            return Optional.ofNullable(className);
        }

        public void setClassTiming() {
            this.classTiming = classTiming;
        }

        public Optional<ClassTiming> getClassTiming() {
            return Optional.ofNullable(classTiming);
        }

        public void setLocation() {
            this.location = location;
        }

        public Optional<Location> getLocation() {
            return Optional.ofNullable(location);
        }

        public void setRate() {
            this.rate = rate;
        }

        public Optional<Rate> getRate() {
            return Optional.ofNullable(rate);
        }

        public void setStudentList() {
            this.studentList = studentList;
        }

        public Optional<StudentList> getStudentList() {
            return Optional.ofNullable(studentList);
        }
    }
}
