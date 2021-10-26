package seedu.address.logic.parser.classcommandparsers;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.ArrayList;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.classcommands.RemoveFromClassCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new RemoveFromClassCommand object
 */
public class RemoveFromClassCommandParser implements Parser<RemoveFromClassCommand> {

    @Override
    public RemoveFromClassCommand parse(String args) throws ParseException {
        requireNonNull(args);

        String[] argsArray = args.trim().split("\\s+");
        ArrayList<Index> indexArray = mapToIndex(argsArray);

        return new RemoveFromClassCommand(indexArray);
    }

    private ArrayList<Index> mapToIndex(String[] str) throws ParseException {
        ArrayList<Index> indexArray = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            try {
                indexArray.add(ParserUtil.parseIndex(str[i]));
            } catch (ParseException pe) {
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                        RemoveFromClassCommand.MESSAGE_USAGE), pe);
            }
        }
        return indexArray;
    }
}
