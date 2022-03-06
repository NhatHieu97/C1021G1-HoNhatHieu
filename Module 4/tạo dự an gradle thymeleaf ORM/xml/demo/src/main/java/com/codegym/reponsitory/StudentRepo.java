package com.codegym.reponsitory;

import com.codegym.model.Student;
import org.hibernate.Session;

import java.util.List;

public class StudentRepo implements IStudentRepository{
    @Override
    public List<Student> findAll() {
        Session session = null;
        List<Student> studentList = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            studentList = session.createQuery("from Student ").getResultList();
        }finally {
            if(session!=null){
                session.close();
            }
        }
        return studentList;
    }
//    Public void save(Customer customer){
//        Transaction transaction = null;
//        Session session = null;
//        try{
//            session = ConectionUtil.sessionFactory.openSession();
//            transaction = session.beginTransaction();
//            session.save(customer);
//            transaction.commit();
//        }catch(Exception e){
//            if(transaction!=null){
//                transaction.rollback();
//            }finally{
//                if(session!=null){
//                    session.close();}}
//        }
//    }
}
