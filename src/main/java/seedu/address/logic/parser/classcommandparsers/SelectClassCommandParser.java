package seedu.address.logic.parser.classcommandparsers;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.SelectClassCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;

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

        Index indexOfClassToView = Index.fromOneBased(Integer.parseInt(splitArgs[1]));

        return new SelectClassCommand(indexOfClassToView);
    }
}
