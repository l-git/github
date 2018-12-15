package com.company.reflection;

import org.apache.log4j.Logger;

/**
 * Created by user on 2018/7/18.
 */
public class Aimpl implements A {

    private static final Logger logger=Logger.getLogger(Aimpl.class);

    public String m1(Object o) {

        logger.debug("ff");

        return o.toString();
    }

    public String m1(Object o, Object o1) {
        logger.debug("ff656656");
        return null;
    }
}
