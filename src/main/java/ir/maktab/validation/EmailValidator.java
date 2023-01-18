package ir.maktab.validation;

import ir.maktab.exception.ValidationException;

import java.util.regex.Pattern;

public class EmailValidator {
    public static boolean isValidateEmail(String email) {
        String regex = "^(?=.{1,64}@)[A-Za-z\\d_-]+(\\.[A-Za-z\\d_-]+)*@"
                + "[^-][A-Za-z\\d-]+(\\.[A-Za-z\\d-]+)*(\\.[A-Za-z]{2,})$";
        if (!Pattern.matches(regex, email))
            throw new ValidationException("the email is not valid");
        return true;
    }
}
