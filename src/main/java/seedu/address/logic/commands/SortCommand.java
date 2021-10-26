package seedu.address.logic.commands;

import java.util.ArrayList;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Student;

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": sorts students by specified parameter and order\n"
            + "Parameters: PARAMETER_TO_SORT_BY DIRECTION_OF_SORT\n"
            + "Example: " + COMMAND_WORD + " name asc";;

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
        ArrayList<Student> toSort = new ArrayList<Student>(model.getFilteredStudentList());

        // sort the studentList;
        if (sortBy.equals("name")) {
            if (directionOfSort.equals("asc")) {
                toSort.sort((student1, student2) ->
                        student1.getName().toString().compareTo(student2.getName().toString()));
            } else {
                toSort.sort((student1, student2) ->
                        student2.getName().toString().compareTo(student1.getName().toString()));
            }
        } else if (sortBy.equals("timing")) {
            if (directionOfSort.equals("asc")) {
                toSort.sort((student1, student2) ->
                        student1.getFirstClassTiming().compareTo(student2.getFirstClassTiming()));
            } else {
                toSort.sort((student1, student2) ->
                        student2.getFirstClassTiming().compareTo(student1.getFirstClassTiming()));
            }
        } else {
            return new CommandResult("sort by" + sortBy
                    + " has not been implemented by the developers");
        }

        model.replaceFilteredStudentList(toSort);

        updateStudentList();

        return new CommandResult("Sorted students based on " + sortBy
                + " in " + directionOfSort + " direction");
    }
}
