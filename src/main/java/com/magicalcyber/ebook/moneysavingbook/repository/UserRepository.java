package com.magicalcyber.ebook.moneysavingbook.repository;

import com.magicalcyber.ebook.moneysavingbook.entity.User;
import com.magicalcyber.ebook.moneysavingbook.web.register.RegisterForm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by magicalcyber on 11/16/14.
 */
@Repository
public class UserRepository {
    private SessionFactory factory;

    @Autowired
    UserRepository(SessionFactory factory){
        this.factory = factory;
    }

    public void register(RegisterForm form){
        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());

        Session session = factory.openSession();
        session.save(user);
    }

    public boolean existUser(String username){
        Session session = factory.openSession();
        Object user = session.get(User.class, username);
        boolean existUser = user != null;
        return existUser;
    }
}
