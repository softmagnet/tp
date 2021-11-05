package seedu.times.logic.parser.classcommands;

import static seedu.times.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.times.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.times.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.times.logic.commands.classcommands.FindClassNameCommand;
import seedu.times.logic.parser.classcommandparsers.FindClassNameCommandParser;
import seedu.times.model.tuitionclass.predicates.ClassNameContainsKeywordsPredicate;

public class FindClassNameCommandParserTest {
    private FindClassNameCommandParser parser = new FindClassNameCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindClassNameCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindClassNameCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindClassNameCommand() {
        // no leading and trailing whitespaces
        FindClassNameCommand expectedCommand =
                new FindClassNameCommand(new ClassNameContainsKeywordsPredicate(Arrays.asList("Physics", "Maths")));
        assertParseSuccess(parser, "Physics Maths", expectedCommand);

        //multiple whitespaces between keywords
        assertParseSuccess(parser, "    Physics  Maths     ", expectedCommand);
    }



}
