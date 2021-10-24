package seedu.address.logic.parser.classcommandparsers;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.classcommands.AddToClassCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;

import java.util.ArrayList;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;


/**
 * Parses input arguments and creates a new AddToClassCommand object
 */
public class AddToClassCommandParser implements Parser<AddToClassCommand> {

    @Override
    public AddToClassCommand parse(String args) throws ParseException {
        requireNonNull(args);

        String[] argsArray = args.trim().split("\\s+");
        ArrayList<Index> indexArray = mapToIndex(argsArray);

        return new AddToClassCommand(indexArray);
    }

    private ArrayList<Index> mapToIndex(String[] str) throws ParseException {
        ArrayList<Index> indexArray = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            try {
                indexArray.add(ParserUtil.parseIndex(str[i]));
            } catch (ParseException pe) {
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                        AddToClassCommand.MESSAGE_USAGE), pe);
            }
        }
        return indexArray;
    }


}
