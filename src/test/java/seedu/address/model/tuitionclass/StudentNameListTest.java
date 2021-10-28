package seedu.address.model.tuitionclass;


import org.junit.jupiter.api.Test;
import seedu.address.model.person.Name;
import seedu.address.model.tuitionclass.exceptions.DuplicateStudentInClassException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for {@code StudentNameList}
 * Contains integration test with {@code Name}
 */
public class StudentNameListTest {
    private Name AMELIA = new Name("Amelia");
    private Name JAKE = new Name("Jake");
    private Name PETER = new Name("Peter");
    private Name WANG = new Name("Wang Lu Xun");
    private Name NAOMI = new Name("Naomi");
    private Name TERRY = new Name("Terry");
    private Name GUOJUN = new Name("Guo Jun");
    private Name YAOMING = new Name("Yao Ming");

    private List<Name> nameList = new ArrayList<>(Arrays.asList(AMELIA, JAKE, PETER, WANG));

    private String[] validNames1 = {"Amelia", "Jake", "Peter", "Wang Lu Xun"};
    private String[] validNames2 = {"Guo Jun", "Naomi", "Terry", "Yao Ming"};
    private String[] validNamesCombined = {"Amelia", "Jake", "Peter", "Wang Lu Xun",
            "Guo Jun", "Naomi", "Terry", "Yao Ming"};
    private StudentNameList STUDENTNAMELIST_SAMPLE_ONE = new StudentNameList(validNames1);
    private StudentNameList STUDENTNAMELIST_SAMPLE_TWO = new StudentNameList(validNames2);
    private StudentNameList STUDENTNAMELIST_SAMPLE_COMBINED = new StudentNameList(validNamesCombined);

    @Test void equals() {
        String[] validNames3 = {"Jake", "Amelia", "Peter", "Wang Lu Xun"};

        //same obj returns true
        assertTrue(STUDENTNAMELIST_SAMPLE_ONE.equals(STUDENTNAMELIST_SAMPLE_ONE));

        //list of same name returns true
        assertTrue(STUDENTNAMELIST_SAMPLE_ONE.equals(new StudentNameList(validNames1)));

        //different list returns false
        assertFalse(STUDENTNAMELIST_SAMPLE_ONE.equals(STUDENTNAMELIST_SAMPLE_TWO));

        //same list with different order returns false
        assertFalse(STUDENTNAMELIST_SAMPLE_ONE.equals(new StudentNameList(validNames3)));
    }

    @Test
    public void contains() {
        //null
        assertThrows(NullPointerException.class, () -> STUDENTNAMELIST_SAMPLE_ONE.contains(null));

        //contains returns true
        assertTrue(STUDENTNAMELIST_SAMPLE_ONE.contains(AMELIA));
        assertTrue(STUDENTNAMELIST_SAMPLE_ONE.contains(JAKE));
        assertTrue(STUDENTNAMELIST_SAMPLE_TWO.contains(GUOJUN));
        assertTrue(STUDENTNAMELIST_SAMPLE_TWO.contains(NAOMI));

        //not contain returns false
        assertFalse(STUDENTNAMELIST_SAMPLE_ONE.contains(YAOMING));
        assertFalse(STUDENTNAMELIST_SAMPLE_ONE.contains(TERRY));
        assertFalse(STUDENTNAMELIST_SAMPLE_TWO.contains(WANG));
        assertFalse(STUDENTNAMELIST_SAMPLE_TWO.contains(PETER));
    }

    @Test
    public void add() {
        StudentNameList studentList = new StudentNameList(validNames1);

        //null
        assertThrows(NullPointerException.class, () -> studentList.add(null));

        //duplicate
        assertThrows(DuplicateStudentInClassException.class, () -> studentList.add(JAKE));

        //non-duplicate adds successfully
        studentList.add(GUOJUN);
        studentList.add(NAOMI);
        studentList.add(TERRY);
        studentList.add(YAOMING);
        assertEquals(studentList, STUDENTNAMELIST_SAMPLE_COMBINED);
    }

    @Test
    public void addAll() {
        //duplicates are not added
        StudentNameList studentList = new StudentNameList(validNames1);
        studentList.addAll(STUDENTNAMELIST_SAMPLE_ONE);
        assertEquals(studentList, STUDENTNAMELIST_SAMPLE_ONE);

        //new names are added successfully
        StudentNameList studentList2 = new StudentNameList(validNames2);
        studentList.addAll(studentList2);
        assertEquals(studentList, STUDENTNAMELIST_SAMPLE_COMBINED);
    }

    @Test
    public void remove() {
        StudentNameList studentList = new StudentNameList(validNamesCombined);

        //remove a name that doesn't exists does nothing
        studentList.remove(new Name("Maurice"));
        assertEquals(studentList, STUDENTNAMELIST_SAMPLE_COMBINED);

        //remove names that exist removes them successfully
        studentList.remove(AMELIA);
        studentList.remove(JAKE);
        studentList.remove(PETER);
        studentList.remove(WANG);
        assertEquals(studentList, STUDENTNAMELIST_SAMPLE_TWO);
    }

    @Test
    public void removeAll() {
        StudentNameList studentList = new StudentNameList(validNamesCombined);

        //remove names that don't exists does nothing
        studentList.removeAll(Arrays.asList(new Name("James"), new Name("Kobe")));
        assertEquals(studentList, STUDENTNAMELIST_SAMPLE_COMBINED);

        //remove names that exist removes them successfully
        studentList.removeAll(Arrays.asList(PETER, WANG, JAKE, AMELIA));
        assertEquals(studentList, STUDENTNAMELIST_SAMPLE_TWO);
    }
}
