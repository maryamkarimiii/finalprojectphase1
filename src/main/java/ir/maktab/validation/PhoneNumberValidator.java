package ir.maktab.validation;

import ir.maktab.exception.ValidationException;

import java.util.regex.Pattern;

public class PhoneNumberValidator {
    public static boolean isValidatePhoneNumber(String phoneNumber) {
        String regex = "^09[0|123]\\d{8}$";
        if (!Pattern.matches(regex, phoneNumber))
            throw new ValidationException("the phone number is not valid");
        return true;
    }
}
