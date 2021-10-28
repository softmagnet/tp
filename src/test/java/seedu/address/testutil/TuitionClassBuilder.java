package seedu.address.testutil;

import seedu.address.model.tuitionclass.ClassName;
import seedu.address.model.tuitionclass.ClassTiming;
import seedu.address.model.tuitionclass.Location;
import seedu.address.model.tuitionclass.Rate;
import seedu.address.model.tuitionclass.StudentNameList;
import seedu.address.model.tuitionclass.TuitionClass;

public class TuitionClassBuilder {

    public static final String DEFAULT_CLASS_NAME = "Sec 4 Physics";
    public static final String DEFAULT_RATE = "60";
    public static final String DEFAULT_LOCATION = "Serangoon NEX #03-33";
    public static final String DEFAULT_CLASS_TIMING = "Wed 16:00-17:00";
    public static final String[] DEFAULT_NAME_LIST = {"Alice", "Benson", "Carl"};

    private ClassName className;
    private ClassTiming classTiming;
    private Rate rate;
    private Location location;
    private StudentNameList studentNameList;

    public TuitionClassBuilder() {
        className = new ClassName(DEFAULT_CLASS_NAME);
        classTiming = new ClassTiming(DEFAULT_CLASS_TIMING);
        rate = new Rate(DEFAULT_RATE);
        location = new Location(DEFAULT_LOCATION);
        studentNameList = new StudentNameList(DEFAULT_NAME_LIST);
    }

    public TuitionClassBuilder(TuitionClass classToCopy) {
        className = classToCopy.getClassName();
        classTiming = classToCopy.getClassTiming();
        rate = classToCopy.getRate();
        location = classToCopy.getLocation();
        studentNameList = classToCopy.getStudentList();
    }

    public TuitionClassBuilder withClassName(String className) {
        this.className = new ClassName(className);
        return this;
    }

    public TuitionClassBuilder withClassTiming(String classTiming) {
        this.classTiming = new ClassTiming(classTiming);
         return this;
    }

    public TuitionClassBuilder withRate(String rate) {
        this.rate = new Rate(rate);
        return this;
    }

    public TuitionClassBuilder withLocation(String location) {
        this.location = new Location(location);
        return this;
    }

    public TuitionClassBuilder withStudentList(String... studentList) {
        this.studentNameList = new StudentNameList(studentList);
        return this;
    }

    public TuitionClass build() {
        return new TuitionClass(className, classTiming, location, rate, studentNameList);
    }
}
