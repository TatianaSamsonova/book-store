package sam.ecommerce.bookstore.validation.password;

import org.passay.DigitCharacterRule;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.RuleResult;
import org.passay.SpecialCharacterRule;
import org.passay.UppercaseCharacterRule;
import org.passay.WhitespaceRule;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    private static final Integer LENGTH_MIN = 6;
    private static final Integer LENGTH_MAX = 10;
    private static final Integer UPPERCASE_MIN = 1;
    private static final Integer DIGITS_MIN = 1;
    private static final Integer SPECIAL_CHAR_MIN = 1;

    @Override
    public void initialize(ValidPassword arg0) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        org.passay.PasswordValidator validator = new org.passay.PasswordValidator(Arrays.asList(
                new LengthRule(LENGTH_MIN, LENGTH_MAX),
                new UppercaseCharacterRule(UPPERCASE_MIN),
                new DigitCharacterRule(DIGITS_MIN),
                new SpecialCharacterRule(SPECIAL_CHAR_MIN),
                new WhitespaceRule()));

        RuleResult result = validator.validate(new PasswordData(password));

        if (result.isValid()) {
            return true;
        }

        context.buildConstraintViolationWithTemplate(
                validator.getMessages(result)
                        .stream()
                        .collect(Collectors.joining(",")))
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}
