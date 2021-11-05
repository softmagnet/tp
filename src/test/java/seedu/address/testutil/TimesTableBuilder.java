package seedu.address.testutil;

import seedu.address.model.TimesTable;
import seedu.address.model.person.Student;
import seedu.address.model.tuitionclass.TuitionClass;

/**
 * A utility class to help with building TimesTable objects.
 * Example usage: <br>
 *     {@code TimesTable ab = new TimesTableBuilder().withPerson("John", "Doe").build();}
 */
public class TimesTableBuilder {

    private TimesTable timesTable;

    public TimesTableBuilder() {
        timesTable = new TimesTable();
    }

    public TimesTableBuilder(TimesTable timesTable) {
        this.timesTable = timesTable;
    }

    /**
     * Adds a new {@code Person} to the {@code TimesTable} that we are building.
     */
    public TimesTableBuilder withStudent(Student student) {
        timesTable.addStudent(student);
        return this;
    }

    /**
     * Adds a new {@code TuitionClass} to the {@code TimesTable} that we are building.
     */
    public TimesTableBuilder withTuitionClass(TuitionClass tuitionClass) {
        timesTable.addTuitionClass(tuitionClass);
        return this;
    }

    public TimesTable build() {
        return timesTable;
    }
}
