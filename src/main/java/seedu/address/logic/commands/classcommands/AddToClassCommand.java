package seedu.address.logic.commands.classcommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CLASS_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;


import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Name;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.ClassName;
import seedu.address.model.tuitionclass.TuitionClass;

public class AddToClassCommand extends Command {

    public static final String COMMAND_WORD = "addtoclass";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a student to a class.\n"
            + "Parameters: "
            + PREFIX_CLASS_NAME + "CLASS NAME "
            + PREFIX_NAME + "STUDENT NAME \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_CLASS_NAME + "401"
            + PREFIX_NAME + "John Doe";

    public static final String MESSAGE_ADD_SUCCESS = "New Student added: %1$s";
    public static final String MESSAGE_DUPLICATE_STUDENT = "This student is already in this class";

    private final AddToClassDescriptor addToClassDescriptor;

    public AddToClassCommand(AddToClassDescriptor addToClassDescriptor) {
        requireNonNull(addToClassDescriptor);
        this.addToClassDescriptor = addToClassDescriptor;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {

        if (model.isPersonInClass(toAdd, tuitionClass)) {
            throw new CommandException(MESSAGE_DUPLICATE_STUDENT);
        }
    }


    /**
     * Stores the names of the student and the class involved in an addToClassCommand.
     */
    public static class AddToClassDescriptor {
        private ClassName className;
        private Name studentName;

        public AddToClassDescriptor(ClassName className, Name studentName) {
            requireAllNonNull(className, studentName);
            this.className = className;
            this.studentName = studentName;
        }

        public ClassName getClassName() {
            return className;
        }

        public Name getStudentName() {
            return studentName;
        }
    }
}
