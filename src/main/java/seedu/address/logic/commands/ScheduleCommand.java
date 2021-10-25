package seedu.address.logic.commands;

import seedu.address.model.Model;
import seedu.address.model.tuitionclass.predicates.ClassTimingContainsKeywordsPredicate;

public class ScheduleCommand extends Command {

    public static final String COMMAND_WORD = "schedule";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose class timing contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " wed tue";

    private final ClassTimingContainsKeywordsPredicate predicate;

    public ScheduleCommand(ClassTimingContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        //requireNonNull(model);
        //model.updateFilteredPersonList(predicate);
        //return new CommandResult(
        //        String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredStudentList().size()));
        return null;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ScheduleCommand // instanceof handles nulls
                && predicate.equals(((ScheduleCommand) other).predicate)); // state check
    }
}
