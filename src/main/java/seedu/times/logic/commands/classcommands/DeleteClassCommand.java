package seedu.times.logic.commands.classcommands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.times.commons.core.Messages;
import seedu.times.commons.core.index.Index;
import seedu.times.logic.commands.Command;
import seedu.times.logic.commands.CommandResult;
import seedu.times.logic.commands.exceptions.CommandException;
import seedu.times.model.Model;
import seedu.times.model.tuitionclass.TuitionClass;
import seedu.times.ui.TabName;

public class DeleteClassCommand extends Command {
    public static final String COMMAND_WORD = "deleteclass";

    public static final String MESSAGE_SUCCESS = "Class deleted: %1$s";
    public static final String MESSAGE_MISSING_CLASS = "This class does not exist in the address book";


    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the class identified by the index in class list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    private final Index index;

    public DeleteClassCommand(Index index) {
        this.index = index;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        List<TuitionClass> lastShownClassList = model.getFilteredTuitionClassList();
        if (index.getOneBased() > lastShownClassList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_CLASS_DISPLAYED_INDEX);
        }
        TuitionClass tuitionClass = lastShownClassList.get(index.getZeroBased());

        if (!model.hasTuitionClass(tuitionClass)) {
            throw new CommandException(MESSAGE_MISSING_CLASS);
        }

        model.deleteTuitionClass(tuitionClass);

        updateView(TabName.CLASSES);

        hideTuitionClassStudentList();

        return new CommandResult(String.format(MESSAGE_SUCCESS, tuitionClass));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteClassCommand // instanceof handles nulls
                && index.equals(((DeleteClassCommand) other).index)); // state check
    }
}
