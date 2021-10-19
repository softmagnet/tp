package seedu.address.logic.parser.classcommandparsers;

import seedu.address.logic.commands.classcommands.AddToClassCommand;
import seedu.address.logic.commands.classcommands.AddToClassCommand.AddToClassDescriptor;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Name;
import seedu.address.model.tuitionclass.ClassName;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CLASS_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.ParserUtil.arePrefixesPresent;

/**
 * Parses input arguments and creates a new AddToClassCommand object
 */
public class AddToClassCommandParser implements Parser<AddToClassCommand> {

    @Override
    public AddToClassCommand parse(String args) throws ParseException {
        requireNonNull(args);

        ArgumentMultimap argMultimap =
                ArgumentTokenizer
                        .tokenize(args, PREFIX_NAME, PREFIX_CLASS_NAME);

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_CLASS_NAME)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddToClassCommand.MESSAGE_USAGE));
        }


        Name name;
        ClassName className;
        name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
        className = ParserUtil.parseClassName(argMultimap.getValue(PREFIX_CLASS_NAME).get());

        return new AddToClassCommand(new AddToClassDescriptor(className, name));
    }


}
