package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CLASSTIMING;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_LOCATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.ParserUtil.arePrefixesPresent;

import java.util.Set;
import java.util.stream.Stream;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Address;
import seedu.address.model.tuitionclass.ClassTiming;
import seedu.address.model.person.Email;
import seedu.address.model.tuitionclass.Location;
import seedu.address.model.person.Name;
import seedu.address.model.person.Nok;
import seedu.address.model.person.Phone;
import seedu.address.model.tuitionclass.Rate;
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
                        .tokenize(argsBeforeNok, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS,
                                PREFIX_RATE, PREFIX_CLASSTIMING, PREFIX_LOCATION, PREFIX_TAG);

        ArgumentMultimap argMultimapAfterNok =
                ArgumentTokenizer.tokenize(argsAfterNok, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS);

        if (!arePrefixesPresent(argMultimapBeforeNok, PREFIX_NAME, PREFIX_ADDRESS, PREFIX_PHONE,
                PREFIX_RATE, PREFIX_CLASSTIMING, PREFIX_LOCATION, PREFIX_EMAIL)
                || !arePrefixesPresent(argMultimapAfterNok, PREFIX_NAME, PREFIX_ADDRESS, PREFIX_PHONE, PREFIX_EMAIL)
                || !argMultimapBeforeNok.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
        }

        Name name = ParserUtil.parseName(argMultimapBeforeNok.getValue(PREFIX_NAME).get());
        Phone phone = ParserUtil.parsePhone(argMultimapBeforeNok.getValue(PREFIX_PHONE).get());
        Email email = ParserUtil.parseEmail(argMultimapBeforeNok.getValue(PREFIX_EMAIL).get());
        Address address = ParserUtil.parseAddress(argMultimapBeforeNok.getValue(PREFIX_ADDRESS).get());
        Rate rate = ParserUtil.parseRate(argMultimapBeforeNok.getValue(PREFIX_RATE).get());
        ClassTiming classTiming = ParserUtil.parseClassTiming(argMultimapBeforeNok.getValue(PREFIX_CLASSTIMING).get());
        Location location = ParserUtil.parseLocation(argMultimapBeforeNok.getValue(PREFIX_LOCATION).get());
        Set<Tag> tagList = ParserUtil.parseTags(argMultimapBeforeNok.getAllValues(PREFIX_TAG));

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

        Student student = new Student(name, phone, email, address, rate, classTiming, location, nok, tagList);

        return new AddCommand(student);
    }
}
