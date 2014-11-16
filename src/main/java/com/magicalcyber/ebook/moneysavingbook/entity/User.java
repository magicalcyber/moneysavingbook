package com.magicalcyber.ebook.moneysavingbook.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by magicalcyber on 11/16/14.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 25)
    private String username;
    @Column(length = 25)
    private String password;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
