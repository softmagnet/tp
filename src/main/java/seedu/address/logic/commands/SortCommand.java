package seedu.address.logic.commands;

import java.util.ArrayList;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.TuitionClass;

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts students/classes by specified"
            + " parameter and order\n"
            + "Parameters: PARAMETER_TO_SORT_BY DIRECTION_OF_SORT\n"
            + "Example: " + COMMAND_WORD + " name asc";
    public static final String INVALID_SORTBY = "The parameter to sort by can only be: name or timing";
    public static final String INVALID_DIRECTIONOFSORT = "The direction of sort can only be asc or desc";

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

        // sort the studentList;
        if (sortBy.equals("name")) {
            ArrayList<Student> toSort = new ArrayList<Student>(model.getFilteredStudentList());

            if (directionOfSort.equals("asc")) {
                toSort.sort((student1, student2) ->
                        student1.getName().toString().compareTo(student2.getName().toString()));
            } else {
                toSort.sort((student1, student2) ->
                        student2.getName().toString().compareTo(student1.getName().toString()));
            }

            model.setStudents(toSort);
        } else if (sortBy.equals("timing")) {
            ArrayList<TuitionClass> toSort = new ArrayList<TuitionClass>(model.getFilteredTuitionClassList());

            if (directionOfSort.equals("asc")) {
                toSort.sort((class1, class2) ->
                        class1.getClassTiming().compareTo(class2.getClassTiming()));
            } else {
                toSort.sort((class1, class2) ->
                        class2.getClassTiming().compareTo(class1.getClassTiming()));
            }

            model.setClasses(toSort);

        } else {
            return new CommandResult("sort by" + sortBy
                    + " has not been implemented by the developers");
        }



        return new CommandResult("Sorted students based on " + sortBy
                + " in " + directionOfSort + " direction");
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
