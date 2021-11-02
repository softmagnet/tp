package seedu.address.logic.parser.classcommands;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX;
import static seedu.address.commons.core.index.Index.fromOneBased;
import static seedu.address.logic.commands.classcommands.AddToClassCommand.INVALID_OR_MISSING_CLASS_INDEX;
import static seedu.address.logic.commands.classcommands.AddToClassCommand.NO_STUDENT_INDEX_PROVIDED_MESSAGE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.classcommands.AddToClassCommand;
import seedu.address.logic.parser.classcommandparsers.AddToClassCommandParser;

public class AddToClassCommandParserTest {
    private Index validIndex1 = fromOneBased(1);
    private Index validIndex2 = fromOneBased(2);
    private Index validIndex3 = fromOneBased(3);

    private AddToClassCommandParser parser = new AddToClassCommandParser();

    @Test
    public void parse_emptyArgs_failure() {
        assertParseFailure(parser, "", INVALID_OR_MISSING_CLASS_INDEX); //nothing
        assertParseFailure(parser, "  ", INVALID_OR_MISSING_CLASS_INDEX); //whitespace
    }

    @Test
    public void parse_noStudentIndex_failure() {
        assertParseFailure(parser, "1", NO_STUDENT_INDEX_PROVIDED_MESSAGE); //without trailing space
        assertParseFailure(parser, "2  ", NO_STUDENT_INDEX_PROVIDED_MESSAGE); //with trailing space
    }

    @Test
    public void parse_invalidClassIndex_failure() {
        //non-digit with no student index
        assertParseFailure(parser, "ds", INVALID_OR_MISSING_CLASS_INDEX);
        //non-digit with student index
        assertParseFailure(parser, "dsajkdha 3", INVALID_OR_MISSING_CLASS_INDEX);
        //negative
        assertParseFailure(parser, "-3 3", INVALID_OR_MISSING_CLASS_INDEX);
        //zero
        assertParseFailure(parser, "0 3", INVALID_OR_MISSING_CLASS_INDEX);
    }

    @Test
    public void parse_invalidStudentIndex_failure() {
        //non-digit
        assertParseFailure(parser, "3 dsa", MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX);
        //negative
        assertParseFailure(parser, "3 -3", MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX);
        //zero
        assertParseFailure(parser, "3 0", MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX);
        //first valid second invalid
        assertParseFailure(parser, "3 2 0", MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX);
    }

    @Test
    public void parse_all_sucess() {
        //add single student
        List<Index> indexArray1 = Arrays.asList(validIndex1, validIndex2);
        AddToClassCommand expectedCommand1 = new AddToClassCommand(indexArray1);
        assertParseSuccess(parser, "1 2", expectedCommand1);

        //add multiple students
        List<Index> indexArray2 = Arrays.asList(validIndex1, validIndex1, validIndex2, validIndex3);
        AddToClassCommand expectedCommand2 = new AddToClassCommand(indexArray2);
        assertParseSuccess(parser, "1 1 2 3", expectedCommand2);

        //duplicate student indices in command will parse sucessfully with only one index in result
        List<Index> indexArray3 = Arrays.asList(validIndex1, validIndex1, validIndex3);
        AddToClassCommand expectedCommand3 = new AddToClassCommand(indexArray3);
        assertParseSuccess(parser, "1 1 1 3", expectedCommand3);
    }
}