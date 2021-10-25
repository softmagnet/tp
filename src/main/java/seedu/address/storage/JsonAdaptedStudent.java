package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Nok;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Student;
import seedu.address.model.tag.Tag;
import seedu.address.model.tuitionclass.TuitionClass;

/**
 * Jackson-friendly version of {@link Student}.
 */
class JsonAdaptedStudent {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    private final String name;
    private final String phone;
    private final String email;
    private final String address;
    //    private final String rate;
    //    private final String classTiming;
    //    private final String location;
    private final List<JsonAdaptedTuitionClass> tuitionClasses = new ArrayList<>();
    private final JsonAdaptedNok nok;
    private final List<JsonAdaptedTag> tagged = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedStudent(@JsonProperty("name") String name, @JsonProperty("phone") String phone,
                              @JsonProperty("email") String email, @JsonProperty("address") String address,
                              @JsonProperty("tuitionClasses") List<JsonAdaptedTuitionClass> tuitionClasses,
                              @JsonProperty("nok") JsonAdaptedNok nok,
                              @JsonProperty("tagged") List<JsonAdaptedTag> tagged) {

        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        //        this.rate = rate;
        //        this.classTiming = classTiming;
        //        this.location = location;
        if (tuitionClasses != null) {
            this.tuitionClasses.addAll(tuitionClasses);
        }
        this.nok = nok;
        if (tagged != null) {
            this.tagged.addAll(tagged);
        }
    }

    /**
     * Converts a given {@code Student} into this class for Jackson use.
     */
    public JsonAdaptedStudent(Student source) {
        name = source.getName().fullName;
        phone = source.getPhone().value;
        email = source.getEmail().value;
        address = source.getAddress().value;
        // TODO: add back when these fields are coupled with the class
        //        rate = source.getRate().value;
        //        classTiming = source.getClassTiming().value;
        //        location = source.getLocation().value;
        tuitionClasses.addAll(source.getClassList().stream()
                .map(JsonAdaptedTuitionClass::new)
                .collect(Collectors.toList()));
        nok = source.getNok() != null ? new JsonAdaptedNok(source.getNok()) : null;
        tagged.addAll(source.getTags().stream()
                .map(JsonAdaptedTag::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Student toModelType() throws IllegalValueException {
        final List<Tag> personTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tagged) {
            personTags.add(tag.toModelType());
        }

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }
        if (!Phone.isValidPhone(phone)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Phone modelPhone = new Phone(phone);

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        if (address == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName()));
        }
        if (!Address.isValidAddress(address)) {
            throw new IllegalValueException(Address.MESSAGE_CONSTRAINTS);
        }
        final Address modelAddress = new Address(address);

        final List<TuitionClass> personTuitionClasses = new ArrayList<>();
        for (JsonAdaptedTuitionClass tuitionClass : tuitionClasses) {
            personTuitionClasses.add(tuitionClass.toModelType());
        }

        //        if (rate == null) {
        //            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
        //            Rate.class.getSimpleName()));
        //        }
        //        if (!Rate.isValidRate(rate)) {
        //            throw new IllegalValueException(Rate.MESSAGE_CONSTRAINTS);
        //        }
        //        final Rate modelRate = new Rate(rate);
        //
        //        if (classTiming == null) {
        //            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
        //                    ClassTiming.class.getSimpleName()));
        //        }
        //        if (!ClassTiming.isValidClassTiming(classTiming)) {
        //            throw new IllegalValueException(ClassTiming.MESSAGE_CONSTRAINTS);
        //        }
        //        final ClassTiming modelClassTiming = new ClassTiming(classTiming);
        //
        //        if (location == null) {
        //            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
        //                    Location.class.getSimpleName()));
        //        }
        //        if (!Location.isValidLocation(location)) {
        //            throw new IllegalValueException(Location.MESSAGE_CONSTRAINTS);
        //        }
        //        final Location modelLocation = new Location(location);

        final Nok modelNok = nok == null ? null : nok.toModelType();

        final Set<Tag> modelTags = new HashSet<>(personTags);

        final ArrayList<TuitionClass> modelTuitionClasses = new ArrayList<>(personTuitionClasses);

        return new Student(modelName, modelPhone, modelEmail, modelAddress, modelTuitionClasses, modelNok, modelTags);
    }

}
