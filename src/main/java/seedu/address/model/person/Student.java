package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.StringUtil;
import seedu.address.model.tag.Tag;

/**
 * Represents a Student in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Student extends Person {

    /* Each Student has 0..1 Nok */
    /**
     * TODO: To prevent repeat of information, rename Person to Student such that
     *     _both_ Nok and Student inherits from Person (to share common fields)
     *     For now, Nok and Person has duplicate fields.
     */
    private Nok nok;
    private final Rate rate;
    private final ClassTiming classTiming;
    private final Location location;

    private final Set<Tag> tags = new HashSet<>();

    /**
     * Students have a tag as well as all the specifiers.
     */

    public Student(
            Name name, Phone phone, Email email, Address address, Rate rate, ClassTiming classTiming,
            Location location, Nok nok, Set<Tag> tags) {
        super(name, phone, email, address);
        requireAllNonNull(rate, classTiming, location);
        this.rate = rate;
        this.classTiming = classTiming;
        this.location = location;
        this.nok = nok;
        this.tags.addAll(tags);
    }

    public void setNok(Nok nok) {
        this.nok = nok;
    }

    public Nok getNok() {
        return nok;
    }

    public ClassTiming getClassTiming() {
        return classTiming;
    }

    public Location getLocation() {
        return location;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns tuition {@code Rate} of this student
     */
    public Rate getRate() {
        return rate;
    }

    /**
     * Returns true if any {@code Tag} belonging to this student matches {@code keyword} in name ignoring case.
     */
    public boolean isAnyTagsMatching(String keyword) {
        requireNonNull(keyword);
        return tags.stream().
                anyMatch(tag -> tag.isNameMatchingIgnoreCase(keyword));
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
                && o.rate.equals(getRate())
                && o.classTiming.equals(getClassTiming())
                && o.location.equals(getLocation())
                && o.getTags().equals(getTags());
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
        return builder.toString();
    }

}
