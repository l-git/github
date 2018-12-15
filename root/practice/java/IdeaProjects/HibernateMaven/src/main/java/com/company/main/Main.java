package com.company.main;

import com.company.HibernateUtil;
import com.company.domain.Employee;
import org.apache.log4j.Logger;
import org.dom4j.io.ElementModifier;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Galapagos on 2016/5/7.
 */
public class Main {

    private static final Logger logger=Logger.getLogger(Main.class);

    private static SessionFactory sessionFactory=HibernateUtil.getSessionFactory();

    public static void main(String args[]){

        Employee employee=new Employee();
        employee.setFirstname("American");
        employee.setLastname("los angles");
        employee.setBirthDate(new Date());
        employee.setCellphone("1470000000");
        Serializable serializable=save(employee);



        /*List<Employee> employees=selectEmployee();

        for(Employee e:employees){
            logger.debug(e.toString());
            updateEmployee(e);
            logger.debug(e.toString());
        }*/
        updateEmployee(serializable);
        logger.debug(employee.toString());

        delete(serializable);





        logger.debug("success");


        sessionFactory.close();

    }

    public static Serializable save(Employee employee){

        /*SessionFactory sessionFactory=HibernateUtil.getSessionFactory();*/
        Session session=sessionFactory.openSession();

        Transaction transaction=session.beginTransaction();

        Serializable serializable=session.save(employee);

        logger.debug(serializable);

        transaction.commit();
        session.close();
        /*sessionFactory.close();*/

        return serializable;


    }

    public static List<Employee> selectEmployee(){

        /*SessionFactory sessionFactory=HibernateUtil.getSessionFactory();*/
        Session session=sessionFactory.openSession();

        Transaction transaction=session.beginTransaction();
        List<Employee> employees=session.createQuery("from com.company.domain.Employee").list();
        transaction.commit();
        session.close();
        /*sessionFactory.close();*/
        return employees;
    }

    public static void updateEmployee(Serializable serializable){
        /*SessionFactory sessionFactory=HibernateUtil.getSessionFactory();*/
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Employee employee= (Employee) session.get(Employee.class,serializable);
        employee.setLastname(new Date()+"");
        /*session.update(e);*/

        transaction.commit();
        session.close();
        /*sessionFactory.close();*/
    }

    public static void delete(Serializable serializable){
        /*SessionFactory sessionFactory=HibernateUtil.getSessionFactory();*/
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Employee employee= (Employee) session.get(Employee.class, serializable);
        session.delete(employee);
        transaction.commit();
        session.close();
        /*sessionFactory.close();*/


    }


}
