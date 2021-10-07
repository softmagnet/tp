package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents a Student in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Student extends Person {

    /* Each Student has 0..1 Noks */
    /**
     * TODO: To prevent repeat of information, rename Person to Student such that
     *     _both_ Nok and Student inherits from Person (to share common fields)
     *     For now, Nok and Person has duplicate fields.
     */
    private Nok nok;

    private final Set<Tag> tags = new HashSet<>();

    /**
     * Students have a tag as well as well as all the specifiers.
     */
    public Student(Name name, Phone phone, Email email, Address address, Nok nok, Set<Tag> tags) {
        super(name, phone, email, address);
        requireAllNonNull(name, phone, email, address, tags);
        this.nok = nok;
        this.tags.addAll(tags);
    }

    public void setNok(Nok nok) {
        this.nok = nok;
    }

    public Nok getNok() {
        return nok;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }


    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     * We check if their tags are equal as well.
     */
    @Override
    public boolean equals(Object other) {
        return super.equals(other)
                && other instanceof Student
                && ((Student) other).getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // Hashes the hashcode to produce a new hash
        return Objects.hash(super.hashCode(), tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(super.toString());

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }
        return builder.toString();
    }

}
