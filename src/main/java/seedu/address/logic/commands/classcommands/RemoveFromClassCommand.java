package seedu.address.logic.commands.classcommands;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Name;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.StudentNameList;
import seedu.address.model.tuitionclass.TuitionClass;

public class RemoveFromClassCommand extends Command {
    public static final String COMMAND_WORD = "removefromclass";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Removes students from a class by the index"
            + " number used "
            + "in the displayed class and person list.\n"
            + "Parameters: CLASS_INDEX "
            + "STUDENT_INDEX\n"
            + "Example: " + COMMAND_WORD + " "
            + "2 "
            + "3 4 5 "
            + "(removes students indexed 3, 4 and 5 from class indexed 2)";

    public static final String MESSAGE_REMOVE_SUCCESS = "Successfully removed students from class ";

    private final Index toEditClassIndex;
    private final List<Index> studentIndices;

    /**
     * Constructs a remove from class command.
     *
     * @param indexArray Array with index of class to remove from and index of students.
     */
    public RemoveFromClassCommand(ArrayList<Index> indexArray) {
        requireNonNull(indexArray);

        //the first index is the index of class in filtered class list that students would be removed from
        toEditClassIndex = indexArray.get(0);

        //the remaining indices are those of the students in filtered student list
        studentIndices = indexArray.subList(1, indexArray.size());
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {

        //get names to be added
        List<Student> lastShownStudentList = model.getFilteredStudentList();
        checkIndicesAreValid(studentIndices, lastShownStudentList);
        ArrayList<Name> namesToRemove = createNameList(studentIndices, lastShownStudentList);

        //get class to remove from
        List<TuitionClass> lastShownClassList = model.getFilteredTuitionClassList();
        TuitionClass classToRemoveFrom = lastShownClassList.get(toEditClassIndex.getZeroBased());

        //get updated student list
        StudentNameList currentStudentNameList = classToRemoveFrom.getStudentList();
        StudentNameList updatedStudentNameList = new StudentNameList();
        updatedStudentNameList.addAll(currentStudentNameList);
        updatedStudentNameList.removeAll(namesToRemove);

        //create edit class descriptor
        EditClassCommand.EditClassDescriptor editClassDescriptor = new EditClassCommand.EditClassDescriptor();
        editClassDescriptor.setUniqueNameList(updatedStudentNameList);

        //swap out old tuition class with new tuition class
        TuitionClass editedClass = EditClassCommand.createEditedClass(classToRemoveFrom, editClassDescriptor);
        model.setClass(classToRemoveFrom, editedClass);

        return new CommandResult(String.format(MESSAGE_REMOVE_SUCCESS, editedClass));
    }

    private ArrayList<Name> createNameList(List<Index> studentIndices, List<Student> lastShownStudentList) {
        ArrayList<Name> nameList = new ArrayList<>();
        studentIndices.stream().forEach(index -> {
            Student student = lastShownStudentList.get(index.getZeroBased());
            nameList.add(student.getName());
        });
        return nameList;
    }

    private void checkIndicesAreValid(List<Index> studentIndices, List<Student> lastShownStudentList)
            throws CommandException {
        int size = lastShownStudentList.size();
        for (Index index : studentIndices) {
            if (index.getZeroBased() >= size) {
                throw new CommandException(Messages.MESSAGE_INVALID_CLASS_DISPLAYED_INDEX);
            }
        }
    }
}
