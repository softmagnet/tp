package seedu.address.logic.commands.classcommands;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_CLASS;

public class ListClassCommand extends Command {

    public static final String COMMAND_WORD = "listclass";

    public static final String MESSAGE_SUCCESS = "Listed all classes";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredClassList(PREDICATE_SHOW_ALL_CLASS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
