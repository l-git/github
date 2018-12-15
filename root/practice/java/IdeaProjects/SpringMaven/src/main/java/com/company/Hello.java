package com.company;

import com.company.bean.User;

/**
 * Created by Galapagos on 2016/10/31.
 */
public class Hello {

    private User user;


    public Hello(){
        System.out.println("hello constructor");
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void say(){

        System.out.println(user);

        System.out.println("hello");
    }

}
