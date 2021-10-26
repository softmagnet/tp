package seedu.address.logic.commands;

import seedu.address.logic.CommandObserver;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

import java.util.ArrayList;

/**
 * Sets the UI to View the tab selected.
 */
public class ViewCommand extends Command {

    public static final String COMMAND_WORD = "view";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Switches tab to specified tab\n"
            + "Parameters: TAB NAME\n"
            + "Example: " + COMMAND_WORD + " timetable";
    public static final String INVALID_TAB = "This tab doesn't exists.\n"
            + "You can only switch to students, timetable or classes.";

    private final int indexToView;

    /**
     * Creates an ViewCommand to view the specified tab index.
     */
    public ViewCommand(int indexToView) {
        this.indexToView = indexToView;
    }


    @Override
    public CommandResult execute(Model model) throws CommandException {
        String tabToView = "";

        if (indexToView == 0) {
            tabToView = "students";
        } else if (indexToView == 1) {
            tabToView = "classes";
        } else if (indexToView == 2) {
            tabToView = "timetable";
        }

        updateView(indexToView);

        return new CommandResult("Successfully switched to " + tabToView + " tab",
                false, false);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof ViewCommand) {
            ViewCommand viewCommand = (ViewCommand) obj;
            return this.indexToView == viewCommand.indexToView;
        } else {
            return false;
        }
    }
}
