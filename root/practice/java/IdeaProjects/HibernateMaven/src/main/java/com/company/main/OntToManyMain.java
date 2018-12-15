package com.company.main;

import com.company.HibernateUtil;
import com.company.domain.Department;
import com.company.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

/**
 * Created by Galapagos on 2016/5/7.
 */
public class OntToManyMain {

    public static void main(String args[]){

        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();

        Session session=sessionFactory.openSession();

        Transaction transaction=session.beginTransaction();

        Department department=new Department();
        department.setDepartmentName("it");

        session.save(department);

        Employee e1=new Employee();

        e1.setLastname("e1 lastname");
        e1.setFirstname("e1 firstname");
        e1.setCellphone("1");
        e1.setBirthDate(new Date());
        e1.setDepartment(department);

        Employee e2=new Employee();
        e2.setLastname("e2 lastname");
        e2.setFirstname("e2 firstname");
        e2.setCellphone("2");
        e2.setBirthDate(new Date());
        e2.setDepartment(department);


        session.save(e1);
        session.save(e2);
        transaction.commit();
        session.close();
        sessionFactory.close();

        System.out.println("ok");





    }

}
