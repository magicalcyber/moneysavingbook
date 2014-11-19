package com.magicalcyber.ebook.moneysavingbook.web.register;

import com.magicalcyber.ebook.moneysavingbook.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by magicalcyber on 11/16/14.
 */
public class RegisterValidator implements Validator {

    private static final Logger log = Logger.getLogger(RegisterValidator.class);

    private UserService userService;

    public RegisterValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return RegisterForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RegisterForm form = (RegisterForm) o;
        boolean isExist = userService.existUser(form.getUsername());
        log.info("isExist: " + isExist);
        if(isExist){
            errors.rejectValue("username", null, "Exist username");
        }
    }
}
