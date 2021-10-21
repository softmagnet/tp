package seedu.address.logic.commands.classcommands;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.model.tuitionclass.exceptions.InvalidClassException;

public class AddClassCommand extends Command {

    public static final String COMMAND_WORD = "addclass";

    public static final String MESSAGE_SUCCESS = "New class added: %1$s";
    public static final String MESSAGE_DUPLICATE_CLASS = "This class already exists in the address book";


    public static final Object MESSAGE_USAGE = "addclass cn/J2O2 r/50 l/Serangoon Tuition Center ct/MON 13:00-14:00";

    private final TuitionClass tuitionClass;

    public AddClassCommand(TuitionClass tuitionClass) {
        this.tuitionClass = tuitionClass;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        if (model.hasTuitionClass(tuitionClass)) {
            throw new CommandException(MESSAGE_DUPLICATE_CLASS);
        }

        try {
            model.addTuitionClass(tuitionClass);
        } catch (InvalidClassException ice) {
            throw new CommandException(Messages.MESSAGE_CLASHING_CLASS_TIMING);
        }

        return new CommandResult(String.format(MESSAGE_SUCCESS, tuitionClass));
    }


}
