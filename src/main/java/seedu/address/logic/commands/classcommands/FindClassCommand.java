package seedu.address.logic.commands.classcommands;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.tuitionclass.predicates.ClassTimingContainsKeywordsPredicate;

import static java.util.Objects.requireNonNull;

public class FindClassCommand extends Command {

    public static final String COMMAND_WORD = "findclass";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all classes whose class timing contains all of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Valid keywords are limited to:\n"
            + "    1) 3 letter abbreviation for day of the week\n"
            + "    2) time expressed in HH:MM-HH:MM format.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " Mon 11:30-12:30";

    private final ClassTimingContainsKeywordsPredicate predicate;

    public FindClassCommand(ClassTimingContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.updateFilteredClassList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_CLASSES_LISTED_OVERVIEW, model.getFilteredTuitionClassList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindClassCommand // instanceof handles nulls
                && predicate.equals(((FindClassCommand) other).predicate)); // state check
    }
}
