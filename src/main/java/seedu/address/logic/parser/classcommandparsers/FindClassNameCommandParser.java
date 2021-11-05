package seedu.address.logic.parser.classcommandparsers;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.ParserUtil.FIND_REGEX_WITH_COMMA_DELIMITER;
import static seedu.address.logic.parser.ParserUtil.getSearchTermList;

import seedu.address.logic.commands.classcommands.FindClassNameCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tuitionclass.predicates.ClassNameContainsKeywordsPredicate;

public class FindClassNameCommandParser implements Parser<FindClassNameCommand> {

    @Override
    public FindClassNameCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindClassNameCommand.MESSAGE_USAGE));
        }

        return new FindClassNameCommand(new ClassNameContainsKeywordsPredicate(getSearchTermList(trimmedArgs,
                FIND_REGEX_WITH_COMMA_DELIMITER)));
    }
}
