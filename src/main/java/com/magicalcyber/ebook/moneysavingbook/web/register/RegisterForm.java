package com.magicalcyber.ebook.moneysavingbook.web.register;

import javax.validation.constraints.Size;

/**
 * Created by magicalcyber on 11/16/14.
 */
public class RegisterForm {

    @Size(min = 5, max = 25, message = "Length must be between {min} and {max}")
    private String username;

    @Size(min = 5, max = 25)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
