package seedu.address.logic.commands;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.tuitionclass.TuitionClass;

public class SelectClassCommand extends Command {
    public static final String COMMAND_WORD = "class";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Selects the appropriate class\n"
            + "Parameters: CLASS_INDEX\n"
            + "Example: " + COMMAND_WORD + " 1";
    public static final String INVALID_TAB = "This class doesn't exists.\n"
            + "You can only switch to indexes shown in the Classlist.";

    private final Index targetIndex;


    public SelectClassCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<TuitionClass> lastShownList = model.getFilteredTuitionClassList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_CLASS_DISPLAYED_INDEX);
        }

        TuitionClass tuitionClass = lastShownList.get(targetIndex.getZeroBased());

        updateClass(targetIndex.getZeroBased());

        return new CommandResult("Viewing class " + tuitionClass.toString(),
                false, false);
    }
}
