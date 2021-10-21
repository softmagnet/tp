package seedu.address.logic.commands.classcommands;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.tuitionclass.ClassName;
import seedu.address.model.tuitionclass.ClassTiming;
import seedu.address.model.tuitionclass.Location;
import seedu.address.model.tuitionclass.Rate;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.model.tuitionclass.UniqueNameList;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;


public class EditClassCommand extends Command {

    public static final String COMMAND_WORD = "editclass";

    public static final String MESSAGE_USAGE = "{message usage for edit class}";

    public static final String MESSAGE_EDIT_CLASS_SUCCESS = "Edited class: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DUPLICATE_PERSON = "This class already exists in the address book.";

    private final Index index;
    private final EditClassDescriptor editClassDescriptor;

    public EditClassCommand(Index index, EditClassDescriptor editClassDescriptor) {
        requireAllNonNull(index, editClassDescriptor);
        this.index = index;
        this.editClassDescriptor = editClassDescriptor;
    }


    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        List<TuitionClass> lastShownClassList = model.getFilteredTuitionClassList();
        if (index.getZeroBased() >= lastShownClassList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_CLASS_DISPLAYED_INDEX);
        }

        TuitionClass classToEdit = lastShownClassList.get(index.getZeroBased());
        TuitionClass editedClass = createEditedClass(classToEdit, editClassDescriptor);

        model.setClass(classToEdit, editedClass);
        model.updateFilteredClassList(Model.PREDICATE_SHOW_ALL_CLASS);
        return new CommandResult(String.format(MESSAGE_EDIT_CLASS_SUCCESS, editedClass));
    }

    /**
     * Stores the names of the student and the class involved in an addToClassCommand.
     */
    public static class EditClassDescriptor {
        private ClassName className;
        private ClassTiming classTiming;
        private Location location;
        private Rate rate;
        private UniqueNameList uniqueNameList;

        public EditClassDescriptor() {}

        public void setClassName(ClassName className) {
            this.className = className;
        }

        public Optional<ClassName> getClassName() {
            return Optional.ofNullable(className);
        }

        public void setClassTiming(ClassTiming classTiming) {
            this.classTiming = classTiming;
        }

        public Optional<ClassTiming> getClassTiming() {
            return Optional.ofNullable(classTiming);
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public Optional<Location> getLocation() {
            return Optional.ofNullable(location);
        }

        public void setRate(Rate rate) {
            this.rate = rate;
        }

        public Optional<Rate> getRate() {
            return Optional.ofNullable(rate);
        }

        public void setStudentList(UniqueNameList uniqueNameList) {
            this.uniqueNameList = uniqueNameList;
        }

        public Optional<UniqueNameList> getStudentList() {
            return Optional.ofNullable(uniqueNameList);
        }

        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(className, classTiming, rate, location, uniqueNameList);
        }
    }

    public static TuitionClass createEditedClass(TuitionClass classToEdit, EditClassDescriptor editClassDescriptor) {
        assert classToEdit != null;

        ClassName className = editClassDescriptor.getClassName().orElse(classToEdit.getClassName());
        ClassTiming classTiming = editClassDescriptor.getClassTiming().orElse(classToEdit.getClassTiming());
        Location location = editClassDescriptor.getLocation().orElse(classToEdit.getLocation());
        Rate rate = editClassDescriptor.getRate().orElse(classToEdit.getRate());
        UniqueNameList uniqueNameList = editClassDescriptor.getStudentList().orElse(classToEdit.getStudentList());

        return new TuitionClass(className, classTiming, location, rate, uniqueNameList);

    }
}
