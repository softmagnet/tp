package seedu.address.logic.parser;

import seedu.address.logic.commands.SortCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

public class SortCommandParser implements Parser<SortCommand> {

    private final String[] validSortByKeywords = new String[]{"name", "timing"};
    private final String[] validDirectionOfSortKeywords = new String[]{"asc", "desc"};

    /**
     * Parses the given {@code String} of arguments in the context of the SortCommand.
     * and returns an SortCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public SortCommand parse(String args) throws ParseException {

        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.MESSAGE_USAGE));
        }

        String[] splitArgs = trimmedArgs.split(" ");
        if (splitArgs.length != 2) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.MESSAGE_USAGE));
        }

        String sortBy = splitArgs[0];
        checkSortBy(sortBy);

        // sort by asc or desc
        String directionOfSort = splitArgs[1];
        checkDirectionOfSort(directionOfSort);

        return new SortCommand(sortBy, directionOfSort);
    }

    public void checkSortBy(String sortBy) throws ParseException {
        for (String validSortByKeyword : validSortByKeywords) {
            if (sortBy.equals(validSortByKeyword)) {
                return;
            }
        }

        throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.MESSAGE_USAGE));
    }

    public void checkDirectionOfSort(String directionOfSort) throws ParseException {
        for (String validDirectionOfSortKeyword : validDirectionOfSortKeywords) {
            if (directionOfSort.equals(validDirectionOfSortKeyword)) {
                return;
            }
        }

        throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.MESSAGE_USAGE));
    }
}
