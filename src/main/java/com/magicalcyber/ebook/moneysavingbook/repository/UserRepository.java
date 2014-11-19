package com.magicalcyber.ebook.moneysavingbook.repository;

import com.magicalcyber.ebook.moneysavingbook.entity.User;
import com.magicalcyber.ebook.moneysavingbook.web.register.RegisterForm;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by magicalcyber on 11/16/14.
 */
@Repository
public class UserRepository {
    private SessionFactory factory;

    @Autowired
    UserRepository(SessionFactory factory) {
        this.factory = factory;
    }

    public void register(RegisterForm form) {
        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        user.setCreateDate(new Date());

        Session session = factory.openSession();
        session.save(user);
    }

    public boolean existUser(String username) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        List users = criteria.add(Restrictions.eq("username", username)).list();
        boolean isExist = false;
        if (users != null && users.size() > 0) {
            isExist = true;
        }
        return isExist;
    }
}
