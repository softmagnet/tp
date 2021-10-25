package seedu.address.logic.parser.classcommandparsers;

import seedu.address.logic.commands.classcommands.FindClassNameCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tuitionclass.predicates.ClassNameContainsKeywordsPredicate;

import java.util.Arrays;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

public class FindClassNameCommandParser implements Parser<FindClassNameCommand> {

    @Override
    public FindClassNameCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindClassNameCommand.MESSAGE_USAGE));
        }

        String[] classTimingKeywords = trimmedArgs.split("\\s+");

        return new FindClassNameCommand(new ClassNameContainsKeywordsPredicate(Arrays.asList(classTimingKeywords)));
    }
}
