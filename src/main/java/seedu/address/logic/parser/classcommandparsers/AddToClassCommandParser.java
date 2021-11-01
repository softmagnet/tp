package seedu.address.logic.parser.classcommandparsers;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX;
import static seedu.address.logic.commands.classcommands.AddToClassCommand.CLASS_INDEX_POSITION;

import java.util.ArrayList;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.classcommands.AddToClassCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;


/**
 * Parses input arguments and creates a new AddToClassCommand object
 */
public class AddToClassCommandParser implements Parser<AddToClassCommand> {


    @Override
    public AddToClassCommand parse(String args) throws ParseException {
        requireNonNull(args);

        String[] argsArray = args.trim().split("\\s+");
        ArrayList<Index> indexArray = mapToIndexArray(argsArray);

        return new AddToClassCommand(indexArray);
    }

    private ArrayList<Index> mapToIndexArray(String[] str) throws ParseException {
        ArrayList<Index> indexArray = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            try {
                indexArray.add(ParserUtil.parseIndex(str[i]));
            } catch (ParseException pe) {
                String errorMessage = i == CLASS_INDEX_POSITION
                        ? AddToClassCommand.INVALID_OR_MISSING_CLASS_INDEX
                        : MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX;
                throw new ParseException(errorMessage);
            }
        }

        if (indexArray.size() < 2) {
            throw new ParseException(AddToClassCommand.NO_STUDENT_INDEX_PROVIDED_MESSAGE);
        }

        return indexArray;
    }


}
