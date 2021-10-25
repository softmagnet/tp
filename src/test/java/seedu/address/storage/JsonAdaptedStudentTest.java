package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedStudent.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.BENSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.tuitionclass.ClassTiming;
import seedu.address.model.tuitionclass.Location;
import seedu.address.model.tuitionclass.Rate;

public class JsonAdaptedStudentTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_ADDRESS = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_RATE = "-32";
    private static final String INVALID_CLASSTIMING = " ";
    private static final String INVALID_LOCATION = " ";
    private static final String INVALID_TAG = "#friend";

    private static final String VALID_NAME = BENSON.getName().toString();
    private static final String VALID_PHONE = BENSON.getPhone().toString();
    private static final String VALID_EMAIL = BENSON.getEmail().toString();
    private static final String VALID_ADDRESS = BENSON.getAddress().toString();
    private static final List<JsonAdaptedTuitionClass> VALID_CLASSES = BENSON.getClassList().stream()
            .map(JsonAdaptedTuitionClass::new)
            .collect(Collectors.toList());
    private static final JsonAdaptedNok VALID_NOK = new JsonAdaptedNok(BENSON.getNok());
    private static final List<JsonAdaptedTag> VALID_TAGS = BENSON.getTags().stream()
            .map(JsonAdaptedTag::new)
            .collect(Collectors.toList());

    @Test
    public void toModelType_validPersonDetails_returnsPerson() throws Exception {
        JsonAdaptedStudent student = new JsonAdaptedStudent(BENSON);
        assertEquals(BENSON, student.toModelType());
    }

    @Test
    public void toModelType_nullNok_success() throws Exception {
        assertDoesNotThrow(() -> new JsonAdaptedStudent(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
               VALID_CLASSES, null, VALID_TAGS));
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedStudent student =
                new JsonAdaptedStudent(INVALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                        VALID_CLASSES, VALID_NOK, VALID_TAGS);
        String expectedMessage = Name.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, student::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedStudent student = new JsonAdaptedStudent(null, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                VALID_CLASSES, VALID_NOK, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, student::toModelType);
    }

    @Test
    public void toModelType_invalidPhone_throwsIllegalValueException() {
        JsonAdaptedStudent student =
                new JsonAdaptedStudent(VALID_NAME, INVALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                        VALID_CLASSES, VALID_NOK, VALID_TAGS);
        String expectedMessage = Phone.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, student::toModelType);
    }

    @Test
    public void toModelType_nullPhone_throwsIllegalValueException() {
        JsonAdaptedStudent student = new JsonAdaptedStudent(VALID_NAME, null, VALID_EMAIL, VALID_ADDRESS,
                VALID_CLASSES, VALID_NOK, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, student::toModelType);
    }

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        JsonAdaptedStudent student =
                new JsonAdaptedStudent(VALID_NAME, VALID_PHONE, INVALID_EMAIL, VALID_ADDRESS,
                        VALID_CLASSES, VALID_NOK, VALID_TAGS);
        String expectedMessage = Email.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, student::toModelType);
    }

    @Test
    public void toModelType_nullEmail_throwsIllegalValueException() {
        JsonAdaptedStudent student = new JsonAdaptedStudent(VALID_NAME, VALID_PHONE, null, VALID_ADDRESS,
                VALID_CLASSES, VALID_NOK, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, student::toModelType);
    }

    @Test
    public void toModelType_invalidAddress_throwsIllegalValueException() {
        JsonAdaptedStudent student =
                new JsonAdaptedStudent(VALID_NAME, VALID_PHONE, VALID_EMAIL, INVALID_ADDRESS,
                        VALID_CLASSES, VALID_NOK, VALID_TAGS);
        String expectedMessage = Address.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, student::toModelType);
    }

    @Test
    public void toModelType_nullAddress_throwsIllegalValueException() {
        JsonAdaptedStudent student = new JsonAdaptedStudent(VALID_NAME, VALID_PHONE, VALID_EMAIL, null,
                VALID_CLASSES, VALID_NOK, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, student::toModelType);
    }

    @Test
    public void toModelType_invalidTags_throwsIllegalValueException() {
        List<JsonAdaptedTag> invalidTags = new ArrayList<>(VALID_TAGS);
        invalidTags.add(new JsonAdaptedTag(INVALID_TAG));
        JsonAdaptedStudent student =
                new JsonAdaptedStudent(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                        VALID_CLASSES, VALID_NOK, invalidTags);
        assertThrows(IllegalValueException.class, student::toModelType);
    }

//    @Test
//    public void toModelType_invalidClassTiming_throwsIllegalValueException() {
//        JsonAdaptedStudent student =
//                new JsonAdaptedStudent(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
//                        VALID_RATE, INVALID_CLASSTIMING, VALID_LOCATION, VALID_NOK, VALID_TAGS);
//        String expectedMessage = ClassTiming.MESSAGE_CONSTRAINTS;
//        assertThrows(IllegalValueException.class, expectedMessage, student::toModelType);
//    }
//
//    @Test
//    public void toModelType_nullClassTiming_throwsIllegalValueException() {
//        JsonAdaptedStudent student = new JsonAdaptedStudent(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
//                VALID_RATE, null, VALID_LOCATION, VALID_NOK, VALID_TAGS);
//        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, ClassTiming.class.getSimpleName());
//        assertThrows(IllegalValueException.class, expectedMessage, student::toModelType);
//    }
//
//    @Test
//    public void toModelType_invalidRate_throwsIllegalValueException() {
//        JsonAdaptedStudent student =
//                new JsonAdaptedStudent(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
//                        INVALID_RATE, VALID_CLASSTIMING, VALID_LOCATION, VALID_NOK, VALID_TAGS);
//        String expectedMessage = Rate.MESSAGE_CONSTRAINTS;
//        assertThrows(IllegalValueException.class, expectedMessage, student::toModelType);
//    }
//
//    @Test
//    public void toModelType_nullRate_throwsIllegalValueException() {
//        JsonAdaptedStudent student = new JsonAdaptedStudent(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
//                null, VALID_CLASSTIMING, VALID_LOCATION, VALID_NOK, VALID_TAGS);
//        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Rate.class.getSimpleName());
//        assertThrows(IllegalValueException.class, expectedMessage, student::toModelType);
//    }
//
//    @Test
//    public void toModelType_invalidLocation_throwsIllegalValueException() {
//        JsonAdaptedStudent student =
//                new JsonAdaptedStudent(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
//                        VALID_RATE, VALID_CLASSTIMING, INVALID_LOCATION, VALID_NOK, VALID_TAGS);
//        String expectedMessage = Location.MESSAGE_CONSTRAINTS;
//        assertThrows(IllegalValueException.class, expectedMessage, student::toModelType);
//    }
//
//    @Test
//    public void toModelType_nullLocation_throwsIllegalValueException() {
//        JsonAdaptedStudent student = new JsonAdaptedStudent(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
//                VALID_RATE, VALID_CLASSTIMING, null, VALID_NOK, VALID_TAGS);
//        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Location.class.getSimpleName());
//        assertThrows(IllegalValueException.class, expectedMessage, student::toModelType);
//    }

}
