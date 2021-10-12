package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_NOK;
import static seedu.address.logic.commands.CommandTestUtil.VALID_CLASSTIMING_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_CLASSTIMING_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_NOK;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LOCATION_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LOCATION_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_NOK;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_NOK;
import static seedu.address.logic.commands.CommandTestUtil.VALID_RATE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_RATE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Student;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Student ALICE = new PersonBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withPhone("94351253").withRate("60").withClassTiming("Mon 00:00-01:00")
            .withLocation("132, Jurong East Ave 4, #03-10")
            .withTags("friends").build();
    public static final Student BENSON = new PersonBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withPhone("98765432").withRate("70").withClassTiming("mon 01:00-02:00")
            .withLocation("132, Jurong East Ave 4, #03-10")
            .withTags("owesMoney", "friends").build();
    public static final Student CARL = new PersonBuilder().withName("Carl Kurz").withPhone("95352563")
            .withEmail("heinz@example.com").withAddress("wall street").withRate("80")
            .withClassTiming("tuE 02:00-03:00").withLocation("132, Jurong East Ave 4, #03-10").build();
    public static final Student DANIEL = new PersonBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withAddress("10th street").withRate("75")
            .withClassTiming("wed 03:00-04:00").withLocation("132, Jurong East Ave 4, #03-10").withTags("friends")
            .build();
    public static final Student ELLE = new PersonBuilder().withName("Elle Meyer").withPhone("9482224")
            .withEmail("werner@example.com").withAddress("michegan ave").withRate("85")
            .withClassTiming("thu 04:00-05:00").withLocation("132, Jurong East Ave 4, #03-10").build();
    public static final Student FIONA = new PersonBuilder().withName("Fiona Kunz").withPhone("9482427")
            .withEmail("lydia@example.com").withAddress("little tokyo").withRate("90")
            .withClassTiming("sat 05:00-06:00").withLocation("132, Jurong East Ave 4, #03-10").build();
    public static final Student GEORGE = new PersonBuilder().withName("George Best").withPhone("9482442")
            .withEmail("anna@example.com").withAddress("4th street").withRate("70")
            .withClassTiming("sun 06:00-07:00").withLocation("132, Jurong East Ave 4, #03-10").build();

    // Manually added
    public static final Student HOON = new PersonBuilder().withName("Hoon Meier").withPhone("8482424")
            .withEmail("stefan@example.com").withAddress("little india")
            .withRate("60").withClassTiming("thu 06:00-08:00").withLocation("132, Jurong East Ave 4, #03-10").build();
    public static final Student IDA = new PersonBuilder().withName("Ida Mueller").withPhone("8482131")
            .withEmail("hans@example.com").withAddress("chicago ave").withRate("60")
            .withClassTiming("Mon 07:00-09:00").withLocation("132, Jurong East Ave 4, #03-10").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Student AMY = new PersonBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY).withRate(VALID_RATE_AMY)
            .withClassTiming(VALID_CLASSTIMING_AMY).withLocation(VALID_LOCATION_AMY).withTags(VALID_TAG_FRIEND)
            .withNokName(VALID_NAME_NOK).withNokPhone(VALID_PHONE_NOK).withNokAddress(VALID_ADDRESS_NOK)
            .withNokEmail(VALID_EMAIL_NOK).build();
    public static final Student BOB = new PersonBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .withRate(VALID_RATE_BOB).withClassTiming(VALID_CLASSTIMING_BOB).withLocation(VALID_LOCATION_BOB)
            .withNokName(VALID_NAME_NOK).withNokPhone(VALID_PHONE_NOK).withNokAddress(VALID_ADDRESS_NOK)
            .withNokEmail(VALID_EMAIL_NOK)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {
    } // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Student student : getTypicalPersons()) {
            ab.addPerson(student);
        }
        return ab;
    }

    public static List<Student> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
