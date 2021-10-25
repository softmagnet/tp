package seedu.address.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Student;
import seedu.address.model.tag.Tag;
import seedu.address.model.tuitionclass.ClassTiming;
import seedu.address.model.tuitionclass.Location;
import seedu.address.model.tuitionclass.Rate;
import seedu.address.model.tuitionclass.TuitionClass;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditPersonDescriptorBuilder {

    private EditPersonDescriptor descriptor;

    public EditPersonDescriptorBuilder() {
        descriptor = new EditPersonDescriptor();
    }

    public EditPersonDescriptorBuilder(EditPersonDescriptor descriptor) {
        this.descriptor = new EditPersonDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code person}'s details
     */
    public EditPersonDescriptorBuilder(Student student) {
        descriptor = new EditPersonDescriptor();
        descriptor.setName(student.getName());
        descriptor.setPhone(student.getPhone());
        descriptor.setEmail(student.getEmail());
        descriptor.setAddress(student.getAddress());

        TuitionClass tuitionClass = student.getClassList().get(0);
        descriptor.setClassName(tuitionClass.getClassName());
        descriptor.setClassTiming(tuitionClass.getClassTiming());
        descriptor.setRate(tuitionClass.getRate());
        descriptor.setLocation(tuitionClass.getLocation());
        //descriptor.setTuitionClasses(student.getClassList());

        descriptor.setTags(student.getTags());
        descriptor.setNokName(student.getNok().getName());
        descriptor.setNokPhone(student.getNok().getPhone());
        descriptor.setNokEmail(student.getNok().getEmail());
        descriptor.setNokAddress(student.getNok().getAddress());
    }

    /**
     * Sets the {@code Name} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withPhone(String phone) {
        descriptor.setPhone(new Phone(phone));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withAddress(String address) {
        descriptor.setAddress(new Address(address));
        return this;
    }

    /**
     * Sets the {@code rate} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withRate(String rate) {
        descriptor.setRate(new Rate(rate));
        return this;
    }

    /**
     * Sets the {@code ClassTiming} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withClassTiming(String classTiming) {
        descriptor.setClassTiming(new ClassTiming(classTiming));
        return this;
    }

    /**
     * Sets the {@code Location} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withLocation(String location) {
        descriptor.setLocation(new Location(location));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public EditPersonDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    /**
     * Sets the {@code NokName} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withNokName(String name) {
        descriptor.setNokName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code NokPhone} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withNokPhone(String phone) {
        descriptor.setNokPhone(new Phone(phone));
        return this;
    }

    /**
     * Sets the {@code NokEmail} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withNokEmail(String email) {
        descriptor.setNokEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code NokAddress} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withNokAddress(String address) {
        descriptor.setNokAddress(new Address(address));
        return this;
    }

    //public EditPersonDescriptorBuilder withTuitionClasses(String className, String classTiming, String location,
    //                                                      String rate) {
    //    TuitionClass tuitionClass = new TuitionClass(new ClassName(className), new ClassTiming(classTiming)
    //            , new Location(location), new Rate(rate));
    //    descriptor.setTuitionClasses(new ArrayList<>(Arrays.asList(tuitionClass)));
    //    return this;
    //}

    public EditPersonDescriptor build() {
        return descriptor;
    }
}
