package seedu.address.logic.commands;

import static seedu.address.model.Model.PREDICATE_SHOW_ALL_CLASS;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.ArrayList;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.ui.TabName;

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts students/classes by specified"
            + " parameter and order\n"
            + "Parameters: PARAMETER_TO_SORT_BY DIRECTION_OF_SORT\n"
            + "Example: " + COMMAND_WORD + " name asc";
    public static final String INVALID_SORTBY = "The parameter to sort by can only be: name or timing";
    public static final String INVALID_DIRECTIONOFSORT = "The direction of sort can only be asc or desc";
    public static final String MESSAGE_SUCCESS = "Sorted %s based on %s in %s direction";

    // input keywords
    public static final String SORT_BY_NAME = "name";
    public static final String SORT_BY_CLASS_TIMING = "timing";
    public static final String DIRECTION_OF_SORT_ASC = "asc";
    public static final String DIRECTION_OF_SORT_DESC = "desc";
    public static final String STUDENT_TAB_SORTED = "students";
    public static final String CLASSES_TAB_SORTED = "classes";

    private final String sortBy;

    private final String directionOfSort;

    /**
     * Constructs a new SortCommand.
     *
     * @param sortBy sortBy keyword.
     * @param directionOfSort directionOfSort keyword.
     */
    public SortCommand(String sortBy, String directionOfSort) {
        this.sortBy = sortBy;
        this.directionOfSort = directionOfSort;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {

        // sort the StudentNameList;
        if (sortBy.equals(SORT_BY_NAME)) {
            model.updateFilteredStudentList(PREDICATE_SHOW_ALL_PERSONS);

            ArrayList<Student> studentsToSort = new ArrayList<>(model.getFilteredStudentList());

            if (directionOfSort.equals(DIRECTION_OF_SORT_ASC)) {
                studentsToSort.sort((student1, student2) ->
                        student1.getName().toString().compareTo(student2.getName().toString()));
            } else {
                studentsToSort.sort((student1, student2) ->
                        student2.getName().toString().compareTo(student1.getName().toString()));
            }

            model.setStudents(studentsToSort);

            updateView(TabName.STUDENTS);

            return new CommandResult(String.format(MESSAGE_SUCCESS, STUDENT_TAB_SORTED, sortBy, directionOfSort));

        } else if (sortBy.equals(SORT_BY_CLASS_TIMING)) {
            model.updateFilteredClassList(PREDICATE_SHOW_ALL_CLASS);

            ArrayList<TuitionClass> classesToSort = new ArrayList<>(model.getFilteredTuitionClassList());

            if (directionOfSort.equals(DIRECTION_OF_SORT_ASC)) {
                classesToSort.sort((class1, class2) ->
                        class1.getClassTiming().compareTo(class2.getClassTiming()));
            } else {
                classesToSort.sort((class1, class2) ->
                        class2.getClassTiming().compareTo(class1.getClassTiming()));
            }


            model.setClasses(classesToSort);

            updateView(TabName.CLASSES);

            hideTuitionClassStudentList();

            return new CommandResult(String.format(MESSAGE_SUCCESS, CLASSES_TAB_SORTED, sortBy, directionOfSort));
        } else {
            return new CommandResult("sort by" + sortBy
                    + " has not been implemented by the developers");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this == obj) {
            return true;
        } else if (obj instanceof SortCommand) {
            SortCommand sortCommand = (SortCommand) obj;
            return this.directionOfSort.equals(sortCommand.directionOfSort) && this.sortBy.equals(sortCommand.sortBy);
        } else {
            return false;
        }
    }
}
