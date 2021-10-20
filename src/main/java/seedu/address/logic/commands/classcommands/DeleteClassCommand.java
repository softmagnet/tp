package seedu.address.logic.commands.classcommands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.ClassTiming;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.model.tuitionclass.UniqueNameList;

public class DeleteClassCommand extends Command {
    public static final String COMMAND_WORD = "deleteclass";

    public static final String MESSAGE_SUCCESS = "Class deleted: %1$s";
    public static final String MESSAGE_MISSING_CLASS = "This class does not exist in the address book";


    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the class identified by the class timing.\n"
            + "Parameters: CLASS TIMING (must be in the form DAY HH:MM-HH:MM eg MON 13:00-15:00)\n"
            + "Example: " + COMMAND_WORD + " MON 16:00-18:00";

    private final ClassTiming classTiming;

    public DeleteClassCommand(ClassTiming classTiming) {
        this.classTiming = classTiming;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        //TODO get tuitionClass from classTiming / index?
        TuitionClass tuitionClass = null;
        //search if in list
        if(!model.hasTuitionClass(tuitionClass)) {
            throw new CommandException(MESSAGE_MISSING_CLASS);
        }
        UniqueNameList uniqueNameList = tuitionClass.getStudentList();
        uniqueNameList.iterator().forEachRemaining(name -> {
            //TODO get student from name
            Student student = null;
            student.deleteClass(tuitionClass);
        });


        return new CommandResult(String.format(MESSAGE_SUCCESS, tuitionClass));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteClassCommand // instanceof handles nulls
                && classTiming.equals(((DeleteClassCommand) other).classTiming)); // state check
    }
}
