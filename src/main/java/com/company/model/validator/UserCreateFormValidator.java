package com.company.model.validator;


import com.company.model.UserCreateForm;
import com.company.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserCreateFormValidator implements Validator {
    private final UserService userService;

    @Autowired
    public UserCreateFormValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserCreateForm form = (UserCreateForm) target;
        validatePasswords(errors, form);
    }

    private void validatePasswords(Errors errors, UserCreateForm form) {
        if (!(form.getPassword().length() > 5) || !(form.getPassword().matches(".*\\d.*"))) {
            errors.reject("password.incorrect", "Password length might be more then 5 symbols and contains a number");
        }
    }
}
