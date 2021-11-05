package seedu.times.logic.parser.classcommandparsers;

import static seedu.times.commons.core.Messages.MESSAGE_INVALID_CLASS_DISPLAYED_INDEX;
import static seedu.times.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.times.commons.core.index.Index;
import seedu.times.logic.commands.classcommands.EditClassCommand;
import seedu.times.logic.commands.classcommands.SelectClassCommand;
import seedu.times.logic.parser.Parser;
import seedu.times.logic.parser.ParserUtil;
import seedu.times.logic.parser.exceptions.ParseException;

public class SelectClassCommandParser implements Parser<SelectClassCommand> {

    @Override
    public SelectClassCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, SelectClassCommand.MESSAGE_USAGE));
        }

        String[] splitArgs = args.split(" ");
        if (splitArgs.length > 2) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, SelectClassCommand.MESSAGE_USAGE));
        }

        Index indexOfClassToView;

        try {
            indexOfClassToView = ParserUtil.parseIndex(splitArgs[1]);
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_CLASS_DISPLAYED_INDEX,
                    EditClassCommand.MESSAGE_USAGE));
        }

        return new SelectClassCommand(indexOfClassToView);
    }
}
