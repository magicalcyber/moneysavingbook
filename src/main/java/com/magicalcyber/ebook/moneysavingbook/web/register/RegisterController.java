package com.magicalcyber.ebook.moneysavingbook.web.register;

import com.magicalcyber.ebook.moneysavingbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by magicalcyber on 11/16/14.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    private UserService userService;

    @Autowired
    public RegisterController(UserService userService){
        this.userService = userService;
    }

    @ModelAttribute
    public RegisterForm registerForm() {
        return new RegisterForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute RegisterForm registerForm, BindingResult result) {
        if(!result.hasErrors()){
            RegisterValidator validator = new RegisterValidator();
            validator.validate(registerForm, result);
            if(!result.hasErrors()){
                userService.register(registerForm);
            }
        }
        return "register";
    }
}
