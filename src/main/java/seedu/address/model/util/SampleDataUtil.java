package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Nok;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Student;
import seedu.address.model.tag.Tag;
import seedu.address.model.tuitionclass.ClassName;
import seedu.address.model.tuitionclass.ClassTiming;
import seedu.address.model.tuitionclass.Location;
import seedu.address.model.tuitionclass.Rate;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.model.tuitionclass.UniqueNameList;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    private static Student[] getSamplePersons() {
        return new Student[] {
            new Student(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                    new Address("Blk 30 Geylang Street 29, #06-40"),
                    new Nok(
                            new Name("Elise Yeoh"),
                            new Phone("93292556"),
                            new Email("eliseyeoh@gmail.com"),
                            new Address("Blk 30 Geylang Street 29, #06-40")
                    ),
                    getTagSet("A Math")),
            new Student(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                    new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                    new Nok(
                            new Name("Daniel Yu"),
                            new Phone("87338920"),
                            new Email("danielyu@gmail.com"),
                            new Address("Blk 28 Geylang Street 29, #08-30")
                    ),
                    getTagSet("C Math")),
            new Student(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                    new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                    new Nok(
                            new Name("Annabeth Parker"),
                            new Phone("94896758"),
                            new Email("annabethp@yahoo.com"),
                            new Address("Blk 6 Petir Road, #07-16")
                    ),
                    getTagSet("Physics")),
            new Student(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                    new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                    new Nok(
                            new Name("Jacob Li"),
                            new Phone("84739056"),
                            new Email("jacobli@gmail.com"),
                            new Address("Blk 436 Serangoon Gardens Street 26, #16-43")
                    ),
                    getTagSet("A Math")),
            new Student(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                    new Address("Blk 47 Tampines Street 20, #17-35"),
                    new Nok(
                            new Name("Hafez Ibrahim"),
                            new Phone("90308891"),
                            new Email("hafez@gmail.com"),
                            new Address("Blk 47 Tampines Street 20, #17-35")
                    ),
                    getTagSet("H2 Math")),
            new Student(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                    new Address("Blk 45 Aljunied Street 85, #11-31"),
                    new Nok(
                            new Name("Bob Balakrishnan"),
                            new Phone("97776300"),
                            new Email("bobbyb@yahoo.com"),
                            new Address("Blk 45 Aljunied Street 85, #11-31")
                    ),
                    getTagSet("colleagues"))
        };
    }

    private static TuitionClass[] getSampleClasses() {
        return new TuitionClass[] {
            new TuitionClass(new ClassName("Sec 4 A Math"),
                    new ClassTiming("MON 11:30-13:30"),
                    new Location("Blk 30 Geylang Street 29, #06-40"),
                    new Rate("50"),
                    new UniqueNameList(new Name("Alex Yeoh"), new Name("David Li"))),
            new TuitionClass(new ClassName("Sec 3 C Math"),
                    new ClassTiming("MON 14:30-16:30"),
                    new Location("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                    new Rate("60"),
                    new UniqueNameList(new Name("Bernice Yu"))),
            new TuitionClass(new ClassName("Sec 2 Physics"),
                    new ClassTiming("TUE 11:00-12:30"),
                    new Location("Blk 11 Ang Mo Kio Street 74, #11-04"),
                    new Rate("40"),
                    new UniqueNameList(new Name("Charlotte Oliveiro"))),
            new TuitionClass(new ClassName("Sec 4 A Math 2"),
                    new ClassTiming("THU 11:30-13:30"),
                    new Location("Blk 30 Geylang Street 29, #06-40"),
                    new Rate("50"),
                    new UniqueNameList(new Name("Alex Yeoh"), new Name("David Li"))),
            new TuitionClass(new ClassName("JC1 H2 Math"),
                    new ClassTiming("THU 16:30-18:30"),
                    new Location("Blk 30 Geylang Street 29, #06-40"),
                    new Rate("50"),
                    new UniqueNameList(new Name("Alex Yeoh"), new Name("David Li")))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Student sampleStudent : getSamplePersons()) {
            sampleAb.addStudent(sampleStudent);
        }
        for (TuitionClass sampleClass : getSampleClasses()) {
            sampleAb.addTuitionClass(sampleClass);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }
}
