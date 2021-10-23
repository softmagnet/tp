package seedu.address.logic.commands;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.TuitionClass;

import java.util.List;

public class SelectClassCommand extends Command {
    public static final String COMMAND_WORD = "class";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Selects the appropriate class\n"
            + "Parameters: CLASS INDEX\n"
            + "Example: " + COMMAND_WORD + " 1";
    public static final String INVALID_TAB = "This class doesn't exists.\n"
            + "You can only switch to indexes shown in the Classlist.";

    private final Index targetIndex;


    public SelectClassCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<TuitionClass> lastShownList = model.getFilteredTuitionClassList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_CLASS_DISPLAYED_INDEX);
        }

        TuitionClass tuitionClass = lastShownList.get(targetIndex.getZeroBased());
        ObservableList<Student> observableList = FXCollections.observableArrayList();

        tuitionClass.getStudentList().forEach(student -> observableList.add(model..get(student)));
        ObservableList<Student> studentObservableList = FXCollections.observableArrayList(tuitionClass.getStudentList());

        // Handle click here
        model.updateFilteredPersonList(student -> tuitionClass.containsStudent(student.getName()));

        return new CommandResult("Viewing class " + tuitionClass.toString());
    }
}
