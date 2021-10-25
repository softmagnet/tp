package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ViewCommand;

class ViewCommandParserTest {

    private ViewCommandParser parser = new ViewCommandParser();

    private int studentsIndex = 0;
    private int classesIndex = 1;
    private int timetableIndex = 2;

    @Test
    public void parse_emptyArg_throwParseException() {
        assertParseFailure(parser, " ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_tooManyArgs_throwParseException() {
        assertParseFailure(parser, "view timetable two",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "view classes cat",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "view students seat",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "view students timetable classes",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_invalidArgs_throwParseException() {
        assertParseFailure(parser, "view timetables",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.INVALID_TAB));

        assertParseFailure(parser, "view class",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.INVALID_TAB));

        assertParseFailure(parser, "view student",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.INVALID_TAB));
    }

    @Test
    public void parse_validArgs_returnsViewCommand() {
        assertParseSuccess(parser, "view timetable",
                new ViewCommand(timetableIndex));

        assertParseSuccess(parser, "view classes",
               new ViewCommand(classesIndex));

        assertParseSuccess(parser, "view students",
                new ViewCommand(studentsIndex));
    }
}
