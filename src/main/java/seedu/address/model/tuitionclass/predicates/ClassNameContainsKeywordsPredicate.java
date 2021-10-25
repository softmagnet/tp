package seedu.address.model.tuitionclass.predicates;

import seedu.address.commons.util.StringUtil;
import seedu.address.model.tuitionclass.TuitionClass;

import java.util.List;
import java.util.function.Predicate;

public class ClassNameContainsKeywordsPredicate implements Predicate<TuitionClass> {

    private final List<String> keywords;

    public ClassNameContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(TuitionClass tuitionClass) {
        return keywords.stream()
                .allMatch(keyword -> StringUtil.containsWordIgnoreCase(tuitionClass.getClassName().className, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ClassNameContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((ClassNameContainsKeywordsPredicate) other).keywords)); // state check
    }
}
