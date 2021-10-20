package seedu.address.logic.parser.classcommandparsers;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.classcommands.DeleteClassCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tuitionclass.ClassTiming;


/**
 * Parses input arguments and creates a new DeleteClassCommand object
 */
public class DeleteClassCommandParser implements Parser<DeleteClassCommand> {

    @Override
    public DeleteClassCommand parse(String args) throws ParseException {
        try {
            ClassTiming classTiming = ParserUtil.parseClassTiming(args);
            return new DeleteClassCommand(classTiming);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteClassCommand.MESSAGE_USAGE), pe);
        }
    }
}
