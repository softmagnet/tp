package seedu.address.testutil;

import seedu.address.logic.commands.classcommands.EditClassCommand.EditClassDescriptor;
import seedu.address.model.tuitionclass.ClassName;
import seedu.address.model.tuitionclass.ClassTiming;
import seedu.address.model.tuitionclass.Location;
import seedu.address.model.tuitionclass.Rate;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.model.tuitionclass.UniqueNameList;

public class EditClassDescriptorBuilder {
    private EditClassDescriptor descriptor;

    public EditClassDescriptorBuilder() {
        descriptor = new EditClassDescriptor();
    }

    public EditClassDescriptorBuilder(EditClassDescriptor descriptor) {
        this.descriptor = new EditClassDescriptor(descriptor);
    }

    public EditClassDescriptorBuilder(TuitionClass tuitionClass) {
        descriptor = new EditClassDescriptor();

        descriptor.setClassName(tuitionClass.getClassName());
        descriptor.setClassTiming(tuitionClass.getClassTiming());
        descriptor.setRate(tuitionClass.getRate());
        descriptor.setLocation(tuitionClass.getLocation());
        descriptor.setUniqueNameList(tuitionClass.getStudentList());
    }

    public EditClassDescriptorBuilder withClassName(String className) {
        descriptor.setClassName(new ClassName(className));
        return this;
    }
    public EditClassDescriptorBuilder withClassTiming(String classTiming) {
        descriptor.setClassTiming(new ClassTiming(classTiming));
        return this;
    }
    public EditClassDescriptorBuilder withRate(String rate) {
        descriptor.setRate(new Rate(rate));
        return this;
    }
    public EditClassDescriptorBuilder withLocation(String location) {
        descriptor.setLocation(new Location(location));
        return this;
    }
    public EditClassDescriptorBuilder withStudentList(String... studentList) {
        descriptor.setUniqueNameList(new UniqueNameList(studentList));
        return this;
    }

    public EditClassDescriptor build() {
        return descriptor;
    }
}
