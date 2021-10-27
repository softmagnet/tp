package seedu.address.testutil;

import seedu.address.model.tuitionclass.ClassName;
import seedu.address.model.tuitionclass.ClassTiming;
import seedu.address.model.tuitionclass.Location;
import seedu.address.model.tuitionclass.Rate;
import seedu.address.model.tuitionclass.TuitionClass;
import seedu.address.model.tuitionclass.UniqueNameList;

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
    private UniqueNameList uniqueNameList;

    public TuitionClassBuilder() {
        className = new ClassName(DEFAULT_CLASS_NAME);
        classTiming = new ClassTiming(DEFAULT_CLASS_TIMING);
        rate = new Rate(DEFAULT_RATE);
        location = new Location(DEFAULT_LOCATION);
        uniqueNameList = new UniqueNameList(DEFAULT_NAME_LIST);
    }

    public TuitionClassBuilder(TuitionClass classToCopy) {
        className = classToCopy.getClassName();
        classTiming = classToCopy.getClassTiming();
        rate = classToCopy.getRate();
        location = classToCopy.getLocation();
        uniqueNameList = classToCopy.getStudentList();
    }

    public TuitionClassBuilder withClassName(ClassName className) {
        this.className = className;
        return this;
    }

    public TuitionClassBuilder withClassTiming(ClassTiming classTiming) {
         return this;
    }

    public TuitionClassBuilder withRate(Rate rate) {
        this.rate = rate;
        return this;
    }

    public TuitionClassBuilder withLocation(Location location) {
        this.location = location;
        return this;
    }

    public TuitionClassBuilder withStudentList(UniqueNameList uniqueNameList) {
        this.uniqueNameList = uniqueNameList;
        return this;
    }

    public TuitionClass build() {
        return new TuitionClass(className, classTiming, location, rate, uniqueNameList);
    }
}
