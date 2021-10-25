package seedu.address.logic.commands.classcommands;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.model.tuitionclass.exceptions.InvalidClassException;

import static seedu.address.logic.parser.CliSyntax.PREFIX_CLASSTIMING;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CLASS_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_LOCATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RATE;

public class AddClassCommand extends Command {

    public static final String COMMAND_WORD = "addclass";

    public static final String MESSAGE_SUCCESS = "New class added: %1$s";
    public static final String MESSAGE_DUPLICATE_CLASS = "This class already exists in the address book";
    public static final Object MESSAGE_USAGE = COMMAND_WORD + ": Adds a class to the address book.\n"
            + "Parameters: "
            + PREFIX_CLASS_NAME + "CLASS NAME "
            + PREFIX_CLASSTIMING + "CLASS TIMING "
            + PREFIX_RATE + "RATE "
            + PREFIX_LOCATION + "LOCATION\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_CLASS_NAME + "Sec 4 A Maths "
            + PREFIX_CLASSTIMING + "MON 11:30-13:30 "
            + PREFIX_RATE + "70 "
            + PREFIX_LOCATION + "Nex Tuition Center";

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
