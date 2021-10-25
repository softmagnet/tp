package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_RATE = "70";
    public static final String DEFAULT_CLASSTIMING = "Wed 16:00-17:00";
    public static final String DEFAULT_LOCATION = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_NOK_NAME = "Zhenglin Ong";
    public static final String DEFAULT_NOK_PHONE = "97762839";
    public static final String DEFAULT_NOK_EMAIL = "zhenglin@gmail.com";
    public static final String DEFAULT_NOK_ADDRESS = "345, Clementi Ave 6, #02-141";
    public static final String DEFAULT_CLASS_NAME = "Math wed class";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Set<Tag> tags;

    private Name nokName;
    private Phone nokPhone;
    private Email nokEmail;
    private Address nokAddress;

    private ArrayList<TuitionClass> classList;
    private ClassName className;
    private ClassTiming classTiming;
    private Location location;
    private Rate rate;
    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        tags = new HashSet<>();

        nokName = new Name(DEFAULT_NOK_NAME);
        nokPhone = new Phone(DEFAULT_NOK_PHONE);
        nokEmail = new Email(DEFAULT_NOK_EMAIL);
        nokAddress = new Address(DEFAULT_NOK_ADDRESS);

        classList = new ArrayList<>();
        className = new ClassName(DEFAULT_CLASS_NAME);
        classTiming = new ClassTiming(DEFAULT_CLASSTIMING);
        location = new Location(DEFAULT_LOCATION);
        rate = new Rate(DEFAULT_RATE);
        classList.add(new TuitionClass(className, classTiming, location, rate));
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Student studentToCopy) {
        name = studentToCopy.getName();
        phone = studentToCopy.getPhone();
        email = studentToCopy.getEmail();
        address = studentToCopy.getAddress();
        tags = new HashSet<>(studentToCopy.getTags());
        nokName = studentToCopy.getNok().getName();
        nokPhone = studentToCopy.getNok().getPhone();
        nokEmail = studentToCopy.getNok().getEmail();
        nokAddress = studentToCopy.getNok().getAddress();
        classList = studentToCopy.getClassList();
        //className = studentToCopy.
//        classTiming = studentToCopy.getClassTiming();
//        location = studentToCopy.getLocation();
//        rate = studentToCopy.getRate();
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Rate} of the {@code Person} that we are building.
     */
    public PersonBuilder withRate(String rate) {
        TuitionClass defaultTuitionClass = classList.get(0);
        TuitionClass editedTuitionClass = new TuitionClass(defaultTuitionClass.getClassName()
                , defaultTuitionClass.getClassTiming(), defaultTuitionClass.getLocation(), new Rate(rate));
        ArrayList<TuitionClass> editedClassList= new ArrayList<>(Arrays.asList(editedTuitionClass));
        this.classList = editedClassList;
        return this;
    }

    /**
     * Sets the {@code ClassTiming} of the {@code Person} that we are building.
     */
    public PersonBuilder withClassTiming(String classTiming) {
        TuitionClass defaultTuitionClass = classList.get(0);
        TuitionClass editedTuitionClass = new TuitionClass(defaultTuitionClass.getClassName()
                , new ClassTiming(classTiming), defaultTuitionClass.getLocation(), defaultTuitionClass.getRate());
        ArrayList<TuitionClass> editedClassList= new ArrayList<>(Arrays.asList(editedTuitionClass));
        this.classList = editedClassList;
        return this;
    }

    /**
     * Sets the {@code Location} of the {@code Person} that we are building.
     */
    public PersonBuilder withLocation(String location) {
        TuitionClass defaultTuitionClass = classList.get(0);
        TuitionClass editedTuitionClass = new TuitionClass(defaultTuitionClass.getClassName()
                , defaultTuitionClass.getClassTiming(), new Location(location), defaultTuitionClass.getRate());
        ArrayList<TuitionClass> editedClassList= new ArrayList<>(Arrays.asList(editedTuitionClass));
        this.classList = editedClassList;
        return this;
    }

    /**
     * Sets the {@code NokName} of the {@code EditPersonDescriptor} that we are building.
     */
    public PersonBuilder withNokName(String name) {
        this.nokName = new Name(name);
        return this;
    }

    /**
     * Sets the {@code NokPhone} of the {@code EditPersonDescriptor} that we are building.
     */
    public PersonBuilder withNokPhone(String phone) {
        this.nokPhone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code NokEmail} of the {@code EditPersonDescriptor} that we are building.
     */
    public PersonBuilder withNokEmail(String email) {
        this.nokEmail = new Email(email);
        return this;
    }

    /**
     * Sets the {@code NokAddress} of the {@code EditPersonDescriptor} that we are building.
     */
    public PersonBuilder withNokAddress(String address) {
        this.nokAddress = new Address(address);
        return this;
    }

    public PersonBuilder withTuitionClasses(ArrayList<TuitionClass> tuitionClasses) {
        this.classList = tuitionClasses;
        return this;
    }

    /**
     * Builds student with all details included in the builder.
     *
     * @return Student with all the deatils included in the builder.
     */
    public Student build() {
        Nok nok = new Nok(nokName, nokPhone, nokEmail, nokAddress);
        //TuitionClass tuitionClass = new TuitionClass(className,)
        return new Student(name, phone, email, address, classList, nok, tags);
    }

}
