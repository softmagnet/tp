package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

public class ClassTimingContainsKeywordsPredicate implements Predicate<Student> {

    private final List<String> keywords;

    public ClassTimingContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Student student) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(student.getClassTiming().value, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ClassTimingContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((ClassTimingContainsKeywordsPredicate) other).keywords)); // state check
    }
}
