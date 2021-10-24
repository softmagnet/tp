package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CLASSTIMING;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_LOCATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOK;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_CLASS;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.model.tuitionclass.exceptions.InvalidClassException;

/**
 * Adds a person to the address book.
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person to the address book.\n"
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_PHONE + "PHONE "
            + PREFIX_EMAIL + "EMAIL "
            + PREFIX_ADDRESS + "ADDRESS "
            + PREFIX_RATE + "RATE"
            + PREFIX_CLASSTIMING + "CLASS TIMING "
            + PREFIX_LOCATION + "LOCATION "
            + "[" + PREFIX_TAG + "TAG]...\n"
            + PREFIX_NOK + " "
            + PREFIX_NAME + "NAME "
            + PREFIX_PHONE + "PHONE "
            + PREFIX_EMAIL + "EMAIL "
            + PREFIX_ADDRESS + "ADDRESS \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "John Doe "
            + PREFIX_PHONE + "98765432 "
            + PREFIX_EMAIL + "johnd@example.com "
            + PREFIX_ADDRESS + "311, Clementi Ave 2, #02-25 "
            + PREFIX_RATE + "70 "
            + PREFIX_CLASSTIMING + "Mon 11:30-13:30 "
            + PREFIX_LOCATION + "311, Clementi Ave 2, #02-25 "
            + PREFIX_TAG + "friends "
            + PREFIX_TAG + "owesMoney \n"
            + PREFIX_NOK + " "
            + PREFIX_NAME + "Jack Doe "
            + PREFIX_PHONE + "10987654 "
            + PREFIX_EMAIL + "jackd@example.com "
            + PREFIX_ADDRESS + "311, Clementi Ave 2, #02-25 ";

    public static final String MESSAGE_SUCCESS = "New Student added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book";

    private final Student studentToAdd;
    private final TuitionClass classToAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}.
     * We always pass in a new {@code TuitionClass}, and check if it alr exists
     */
    public AddCommand(Student student, TuitionClass tuitionClass) {
        requireNonNull(student);
        studentToAdd = student;
        classToAdd = tuitionClass;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasPerson(studentToAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        try {
            // Add student to the existing class
            classToAdd.addStudent(studentToAdd.getName());

            model.addTuitionClass(classToAdd);


            // Add class to the student
            studentToAdd.addClass(classToAdd);

            model.addPerson(studentToAdd);
            model.updateFilteredClassList(PREDICATE_SHOW_ALL_CLASS);
            return new CommandResult(String.format(MESSAGE_SUCCESS, studentToAdd));
        } catch (InvalidClassException e) {
            throw new CommandException(Messages.MESSAGE_CLASHING_CLASS_TIMING);
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddCommand // instanceof handles nulls
                && studentToAdd.equals(((AddCommand) other).studentToAdd));
    }
}
