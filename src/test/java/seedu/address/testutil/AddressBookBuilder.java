package seedu.address.testutil;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.TuitionClass;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withPerson("John", "Doe").build();}
 */
public class AddressBookBuilder {

    private AddressBook addressBook;

    public AddressBookBuilder() {
        addressBook = new AddressBook();
    }

    public AddressBookBuilder(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Adds a new {@code Person} to the {@code AddressBook} that we are building.
     */
    public AddressBookBuilder withPerson(Student student) {
        addressBook.addStudent(student);
        return this;
    }

    /**
     * Adds a new {@code TuitionClass} to the {@code AddressBook} that we are building.
     */
    public AddressBookBuilder withTuitionClass(TuitionClass tuitionClass) {
        addressBook.addTuitionClass(tuitionClass);
        return this;
    }

    public AddressBook build() {
        return addressBook;
    }
}
