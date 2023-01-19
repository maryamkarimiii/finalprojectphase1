package ir.maktab.validation;

import ir.maktab.exception.ValidationException;

import java.util.regex.Pattern;

public class PasswordValidator {
    public static boolean isValidatePassword(String password) {
        String regex = "^(?=.*\\d)(?=.*[a-zA-Z])(?=\\S+$).{8}$";
        if (!Pattern.matches(regex, password))
            throw new ValidationException("the password is not valid");
        return true;
    }
}
