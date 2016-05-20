package com.anton.controller;

import com.anton.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FormValidator implements Validator {
    private Pattern pattern;
    private Matcher matcher;

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

            ValidationUtils.rejectIfEmptyOrWhitespace(errors,"age", "age.is.empty" ,"Field \"Age\" must be filled.");


            if (user.getAge() != 0) {
                pattern = Pattern.compile("[0-9]{0,3}");
                matcher = pattern.matcher(String.valueOf(user.getAge()));
                if (!matcher.matches()) {
                    errors.rejectValue("age", "age.is.bad", "Fill the field \"Age\" correctly");

                }

                else if (user.getAge() > 120) {
                    errors.rejectValue("age", "age.to.long", "It's too large age");
                }

        }
        ValidationUtils.rejectIfEmpty(errors,"name", "name.empty", "Field \"name\" must be filled.");

    }
}
