package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ScheduleCommand;
import seedu.address.model.person.ClassTimingContainsKeywordsPredicate;


public class ScheduleCommandParserTest {

    private ScheduleCommandParser parser = new ScheduleCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                ScheduleCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsScheduleCommand() {
        // no leading and trailing whitespaces
        ScheduleCommand expectedScheduleCommand =
                new ScheduleCommand(new ClassTimingContainsKeywordsPredicate(Arrays.asList("wednesday", "thursday")));
        assertParseSuccess(parser, "wednesday thursday", expectedScheduleCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n wednesday \n \t thursday  \t", expectedScheduleCommand);
    }
}
