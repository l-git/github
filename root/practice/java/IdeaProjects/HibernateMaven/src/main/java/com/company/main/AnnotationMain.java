package com.company.main;

import com.company.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.util.Date;

/**
 * Created by Galapagos on 2016/5/7.
 */
public class AnnotationMain {
    public static void main(String args[]){

        Configuration configuration=new AnnotationConfiguration().configure();
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Employee employee=new Employee();
        employee.setLastname("last name");
        employee.setFirstname("first name");
        employee.setBirthDate(new Date());
        employee.setCellphone("1860008844");
        session.save(employee);

        transaction.commit();
        session.close();
        sessionFactory.close();

        System.out.println("ok");


    }
}
