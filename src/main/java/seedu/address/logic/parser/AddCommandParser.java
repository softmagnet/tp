package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOK;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Set;
import java.util.stream.Stream;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Nok;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Student;
import seedu.address.model.tag.Tag;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddCommandParser implements Parser<AddCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddCommand parse(String args) throws ParseException {
        requireNonNull(args);

        // Tokenize twice, once for everything before nok and everything after it
        String argsBeforeNok = args;
        String argsAfterNok = "";

        if (args.contains("nok/")) {
            String[] splitArgs = args.split("nok/");
            argsBeforeNok = splitArgs[0];
            argsAfterNok = splitArgs[1];
        }

        ArgumentMultimap argMultimapBeforeNok =
                ArgumentTokenizer
                        .tokenize(argsBeforeNok, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS, PREFIX_TAG);

        ArgumentMultimap argMultimapAfterNok =
                ArgumentTokenizer.tokenize(argsAfterNok, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS);



        if (!arePrefixesPresent(argMultimapBeforeNok, PREFIX_NAME, PREFIX_ADDRESS, PREFIX_PHONE, PREFIX_EMAIL)
                || !argMultimapBeforeNok.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
        }

        Name name = ParserUtil.parseName(argMultimapBeforeNok.getValue(PREFIX_NAME).get());
        Phone phone = ParserUtil.parsePhone(argMultimapBeforeNok.getValue(PREFIX_PHONE).get());
        Email email = ParserUtil.parseEmail(argMultimapBeforeNok.getValue(PREFIX_EMAIL).get());
        Address address = ParserUtil.parseAddress(argMultimapBeforeNok.getValue(PREFIX_ADDRESS).get());
        Set<Tag> tagList = ParserUtil.parseTags(argMultimapBeforeNok.getAllValues(PREFIX_TAG));

        // TODO: do add functionality of nok
        Nok nok = null;

        if (!argsAfterNok.equals("")) {
            nok = new Nok(
                    ParserUtil.parseName(argMultimapAfterNok.getValue(PREFIX_NAME).get()),
                    ParserUtil.parsePhone(argMultimapAfterNok.getValue(PREFIX_PHONE).get()),
                    ParserUtil.parseEmail(argMultimapAfterNok.getValue(PREFIX_EMAIL).get()),
                    ParserUtil.parseAddress(argMultimapAfterNok.getValue(PREFIX_ADDRESS).get())
            );
        } else {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
        }

        Student student = new Student(name, phone, email, address, nok, tagList);

        return new AddCommand(student);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
