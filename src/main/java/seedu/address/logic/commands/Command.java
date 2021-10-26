package seedu.address.logic.commands;

import seedu.address.logic.CommandObserver;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

import java.util.ArrayList;

/**
 * Represents a command with hidden internal logic and the ability to be executed.
 */
public abstract class Command {

    public static final ArrayList<CommandObserver> commandObservers = new ArrayList<>();

    public static void setCommandObserver(CommandObserver commandObserver) {
        commandObservers.add(commandObserver);
    }

    public void updateView(Integer indexToView) {
        for (CommandObserver commandObserver : commandObservers) {
            commandObserver.updateView(indexToView);
        }
    }

    public void updateClass(Integer indexOfClassToSelect) {
        for (CommandObserver commandObserver : commandObservers) {
            commandObserver.updateClass(indexOfClassToSelect);
        }
    }

    public void updateStudentList() {
        for (CommandObserver commandObserver : commandObservers) {
            commandObserver.updateStudentList();
        }
    }
    /**
     * Executes the command and returns the result message.
     *
     * @param model {@code Model} which the command should operate on.
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
    public abstract CommandResult execute(Model model) throws CommandException;

}
