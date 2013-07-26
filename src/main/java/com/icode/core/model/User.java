package com.icode.core.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-26
 * Time: 下午2:52
 */
@Entity
@Table
public class User extends AbstractEntity {

    private String username;

    private String password;

    private String introduction;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getIntroduction() {
        return introduction;
    }
}
