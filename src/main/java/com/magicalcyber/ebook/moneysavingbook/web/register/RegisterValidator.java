package com.magicalcyber.ebook.moneysavingbook.web.register;

import com.magicalcyber.ebook.moneysavingbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by magicalcyber on 11/16/14.
 */
public class RegisterValidator implements Validator {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return RegisterForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RegisterForm form = (RegisterForm) o;
        if(userService.existUser(form.getUsername())){
            errors.rejectValue("username", "Exist user");
        }
    }
}
