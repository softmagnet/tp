package seedu.address.model.tuitionclass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

public class ClassNameTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ClassName(null));
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        String invalidCLassName = "";
        assertThrows(IllegalArgumentException.class, () -> new ClassName(invalidCLassName));
    }

    @Test
    public void isValidClassName() {
        //null name
        assertThrows(NullPointerException.class, () -> ClassName.isValidClassName(null));

        //invalid name
        assertFalse(ClassName.isValidClassName("")); // empty string
        assertFalse(ClassName.isValidClassName(" ")); // spaces only
        assertFalse(ClassName.isValidClassName("^")); // only non-alphanumeric characters
        assertFalse(ClassName.isValidClassName("physics*")); // contains non-alphanumeric characters
        assertFalse(ClassName.isValidClassName("A-Maths")); //contains mix of alphanumeric and non-alphanumeric

        //valid name
        assertTrue(ClassName.isValidClassName("403")); //numbers only
        assertTrue(ClassName.isValidClassName("biology")); //alphabet only
        assertTrue(ClassName.isValidClassName("sec 4 physics")); //mix of alphanumeric
        assertTrue(ClassName.isValidClassName("CHEMISTRY")); //capital letters
        assertTrue(ClassName.isValidClassName("Learning Lab Tuition center Chemistry Sec 4")); //long name
    }

}
