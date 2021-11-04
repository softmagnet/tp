package seedu.address.logic.parser.classcommandparsers;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CLASSTIMING;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CLASS_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_LOCATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RATE;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.classcommands.EditClassCommand;
import seedu.address.logic.commands.classcommands.EditClassCommand.EditClassDescriptor;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;

public class EditClassCommandParser implements Parser<EditClassCommand> {
    @Override
    public EditClassCommand parse(String args) throws ParseException {
        requireNonNull(args);

        ArgumentMultimap argMultimap =
                ArgumentTokenizer
                        .tokenize(args, PREFIX_CLASS_NAME, PREFIX_CLASSTIMING, PREFIX_RATE, PREFIX_LOCATION);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    EditClassCommand.MESSAGE_USAGE));
        }

        EditClassDescriptor editClassDescriptor = new EditClassDescriptor();

        if (argMultimap.getValue(PREFIX_CLASS_NAME).isPresent()) {
            editClassDescriptor.setClassName(ParserUtil.parseClassName(argMultimap.getValue(PREFIX_CLASS_NAME).get()));
        }
        if (argMultimap.getValue(PREFIX_CLASSTIMING).isPresent()) {
            editClassDescriptor.setClassTiming(ParserUtil
                    .parseClassTiming(argMultimap.getValue(PREFIX_CLASSTIMING).get()));
        }
        if (argMultimap.getValue(PREFIX_RATE).isPresent()) {
            editClassDescriptor.setRate(ParserUtil.parseRate(argMultimap.getValue(PREFIX_RATE).get()));
        }
        if (argMultimap.getValue(PREFIX_LOCATION).isPresent()) {
            editClassDescriptor.setLocation(ParserUtil.parseLocation(argMultimap.getValue(PREFIX_LOCATION).get()));
        }

        if (!editClassDescriptor.isAnyFieldEdited()) {
            throw new ParseException(EditClassCommand.MESSAGE_NO_FIELD_PROVIDED);
        }

        return new EditClassCommand(index, editClassDescriptor);
    }
}
