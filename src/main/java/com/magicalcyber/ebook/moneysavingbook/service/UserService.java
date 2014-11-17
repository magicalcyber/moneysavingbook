package com.magicalcyber.ebook.moneysavingbook.service;

import com.magicalcyber.ebook.moneysavingbook.repository.UserRepository;
import com.magicalcyber.ebook.moneysavingbook.web.register.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by magicalcyber on 11/16/14.
 */
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void register(RegisterForm form){
        userRepository.register(form);
    }

    public boolean existUser(String username){
        return userRepository.existUser(username);
    }
}
