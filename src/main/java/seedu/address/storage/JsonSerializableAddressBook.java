package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.TuitionClass;

/**
 * An Immutable AddressBook that is serializable to JSON format.
 */
@JsonRootName(value = "addressbook")
class JsonSerializableAddressBook {

    public static final String MESSAGE_DUPLICATE_PERSON = "Persons list contains duplicate person(s).";
    public static final String MESSAGE_DUPLICATE_CLASS = "Class list contains duplicate class(es).";

    private final List<JsonAdaptedStudent> persons = new ArrayList<>();
    private final List<JsonAdaptedTuitionClass> classes = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableAddressBook} with the given persons.
     */
    @JsonCreator
    public JsonSerializableAddressBook(@JsonProperty("persons") List<JsonAdaptedStudent> persons,
                                       @JsonProperty("classes") List<JsonAdaptedTuitionClass> classes) {
        this.persons.addAll(persons);
        this.classes.addAll(classes);
    }

    /**
     * Converts a given {@code ReadOnlyAddressBook} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableAddressBook}.
     */
    public JsonSerializableAddressBook(ReadOnlyAddressBook source) {
        persons.addAll(source.getPersonList().stream().map(JsonAdaptedStudent::new).collect(Collectors.toList()));
        classes.addAll(source.getTuitionClassList().stream().map(JsonAdaptedTuitionClass::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this address book into the model's {@code AddressBook} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public AddressBook toModelType() throws IllegalValueException {
        AddressBook addressBook = new AddressBook();

        for (JsonAdaptedStudent jsonAdaptedStudent : persons) {
            Student student = jsonAdaptedStudent.toModelType();
            if (addressBook.hasPerson(student)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_PERSON);
            }
            addressBook.addStudent(student);
        }

        for (JsonAdaptedTuitionClass jsonAdaptedTuitionClass : classes) {
            TuitionClass tuitionClass = jsonAdaptedTuitionClass.toModelType();
            if (addressBook.hasTuitionClass(tuitionClass)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_CLASS);
            }
            addressBook.addTuitionClass(tuitionClass);
        }

        return addressBook;
    }

}
