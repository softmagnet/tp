package seedu.address.logic.commands;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class ViewCommand extends Command {

    public static final String COMMAND_WORD = "view";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Switches tab to specified tab\n"
            + "Parameters: TAB NAME\n"
            + "Example: " + COMMAND_WORD + " timetable";
    public static final String INVALID_TAB = "This tab doesn't exists.\n" +
            "You can only switch to students, timetable or classes.";

    public int indexToView;

    public ViewCommand(int indexToView) {
        this.indexToView = indexToView;
    }


    @Override
    public CommandResult execute(Model model) throws CommandException {
        String tabToView = "";

        if (indexToView == 0) {
            tabToView = "students";
        } else if (indexToView == 1) {
            tabToView = "timetable";
        } else if (indexToView == 2) {
            tabToView = "classes";
        }

        return new CommandResult("Successfully switched to " + tabToView + " tab.",
                false, false, indexToView);
    }
}
