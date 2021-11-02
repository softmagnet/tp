package seedu.address.logic.commands.classcommands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.tuitionclass.predicates.ClassNameContainsKeywordsPredicate;
import seedu.address.ui.TabName;

public class FindClassNameCommand extends Command {

    public static final String COMMAND_WORD = "findclassname";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all classes whose class name contains all of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " sec4 physics";

    private final ClassNameContainsKeywordsPredicate predicate;

    public FindClassNameCommand(ClassNameContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.updateFilteredClassList(predicate);

        updateView(TabName.CLASSES);
        hideTuitionClassStudentList();

        return new CommandResult(
                String.format(Messages.MESSAGE_CLASSES_LISTED_OVERVIEW, model.getFilteredTuitionClassList().size()));
    }
}
