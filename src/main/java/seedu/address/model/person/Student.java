package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.tag.Tag;
import seedu.address.model.tuitionclass.ClassTiming;
import seedu.address.model.tuitionclass.Location;
import seedu.address.model.tuitionclass.Rate;
import seedu.address.model.tuitionclass.TuitionClass;

/**
 * Represents a Student in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Student extends Person {

    /* Each Student has 0..1 Nok */
    private Nok nok;
    private final ArrayList<TuitionClass> classList = new ArrayList<>();

    private final Set<Tag> tags = new HashSet<>();

    /**
     * Students have a tag as well as all the specifiers.
     * When a student is created, we create a TuitionClass with that ClassTiming and Location.
     */
    public Student(
            Name name, Phone phone, Email email, Address address, ArrayList<TuitionClass> tuitionClass, Nok nok,
            Set<Tag> tags) {
        super(name, phone, email, address);

        this.classList.addAll(tuitionClass);
        this.nok = nok;
        this.tags.addAll(tags);
    }

    /**
     * Students constructed with an empty list of TuitionClasses.
     *
     */
    public Student(
            Name name, Phone phone, Email email, Address address, Nok nok, Set<Tag> tags) {
        super(name, phone, email, address);

        this.nok = nok;
        this.tags.addAll(tags);
    }

    /**
     * Adds TuitionClass to the student.
     *
     * @param tuitionClass to be added.
     */
    public void addClass(TuitionClass tuitionClass) {
        if (!classList.contains(tuitionClass)) {
            classList.add(tuitionClass);
        }
    }

    public void deleteClass(TuitionClass tuitionClass) {
        classList.remove(tuitionClass);
    }

    public ArrayList<TuitionClass> getClassList() {
        return classList;
    }

    public void setNok(Nok nok) {
        this.nok = nok;
    }

    public Nok getNok() {
        return nok;
    }

    public ClassTiming getClassTiming() {
        // TODO: Placeholder
        return null;
    }

    public ClassTiming getFirstClassTiming() {
        return classList.get(0).getClassTiming();
    }

    public Location getLocation() {
        // TODO: Placeholder
        return null;
    }

    /**
     * Returns tuition {@code Rate} of this student
     */
    public Rate getRate() {
        // Placeholder
        return null;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if any {@code Tag} belonging to this student matches {@code keyword} in name ignoring case.
     */
    public boolean isAnyTagsMatching(String keyword) {
        requireNonNull(keyword);
        return tags.stream()
                .anyMatch(tag -> tag.isNameMatchingIgnoreCase(keyword));
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     * We check if their tags are equal as well.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Student)) {
            return false;
        }

        Student o = (Student) other;
        return super.equals(other)
                && o.getTags().equals(getTags()) && o.getClassList().equals(getClassList());
    }

    @Override
    public int hashCode() {
        // Hashes the hashcode to produce a new hash
        return Objects.hash(super.hashCode(), tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(super.toString());
        builder.append("; Rate: ")
                .append(getRate())
                .append("; Class Timing: ")
                .append(getClassTiming())
                .append("; Location: ")
                .append(getLocation());

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }

        builder.append("\nNext-of-Kin: ");
        builder.append(nok.toString());

        if (classList.size() != 0) {
            builder.append("\nClass List: ");
            builder.append(classList.stream().map(TuitionClass::toString).collect(Collectors.joining(", ")));
        }

        return builder.toString();
    }

}
