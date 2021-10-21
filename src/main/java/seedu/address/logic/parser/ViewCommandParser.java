package seedu.address.logic.parser;

import seedu.address.logic.commands.ViewCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

public class ViewCommandParser implements Parser<ViewCommand> {

    @Override
    public ViewCommand parse(String args) throws ParseException {

        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.MESSAGE_USAGE));
        }

        String[] splitArgs = args.split(" ");
        if (splitArgs.length > 2) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.MESSAGE_USAGE));
        }

        String tabToView = splitArgs[1];
        int indexOfTabToView;

        switch (tabToView) {
        case "students":
            indexOfTabToView = 0;
            break;
        case "timetable":
            indexOfTabToView = 1;
            break;
        case "classes":
            indexOfTabToView = 2;
            break;
        default:
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.INVALID_TAB));
        }

        return new ViewCommand(indexOfTabToView);
    }
}
