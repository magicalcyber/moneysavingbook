package com.magicalcyber.ebook.moneysavingbook.web.register;

import com.magicalcyber.ebook.moneysavingbook.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    private static final Logger log = Logger.getLogger(RegisterController.class);

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
    public String register(@Valid @ModelAttribute RegisterForm registerForm, BindingResult result, Model model) {
        if(!result.hasErrors()){
            RegisterValidator validator = new RegisterValidator(userService);
            validator.validate(registerForm, result);
            log.info("validate result: " + result.hasErrors());
            if(!result.hasErrors()){
                userService.register(registerForm);
                model.addAttribute("message", "Register Complete.");
            }
        }
        return "register";
    }
}
