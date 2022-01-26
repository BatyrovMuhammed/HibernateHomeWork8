package peaksoft;

import org.hibernate.Session;
import peaksoft.entity.Works;
import util.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
                Works student = new Works("Muhammed","Batyrov ","Java",18);
                Works student1 = new Works("Aza","Akylov ","Js",32);
                Works student2 = new Works("Zyinatullo","Sulaimanov ","Java",18);
                Works student3 = new Works("Rahim","Kurbanov ","Java",19);
                Works student4 = new Works("Kubat","Batyrov ","Java",43);
                Works student5 = new Works("Aza","Ulukov ","Js",21);
                Works student6 = new Works("Azamat","Gaparov ","Java",56);
                Works student7 = new Works("Akyl","Atakanov ","Js",34);
                Works student8 = new Works("Nurullo","Salimov ","Java",17);
                Works student9 = new Works("Aza","Toktogulov ","Js",12);
                Works student10 = new Works("Nurlam","Atairov ","Java",22);
//create(student10);
       // System.out.println(getAllStudent());
        //System.out.println(getAllStudent2());

//        System.out.println(getById(1));
//
//        for ( Student s:getAllStudent()) {
//            System.out.println(s);
//
//            System.out.println(update(1,"Rahim","Kurbanov","Java",19));
//
//            deleteById(2);
  //      }

    }

    public static int create(Works student) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
        System.out.println("Added successfully :" + student);
        return student.getId();

    }
    public static List<Works> getAllStudent(){
        Session session = HibernateUtil.getSession().openSession();
        session.getTransaction();
        List<Works> students = session.createSQLQuery("FROM Student where age >20 and name = 'Aza'").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println(students.size());
        return students;

    }
    public static List<Works> getAllStudent2(){
        Session session = HibernateUtil.getSession().openSession();
        session.getTransaction();
        List<Works> students = session.createSQLQuery("UPDATE students SET age =18 " +
                "where name = 'Aza' ").getResultList();
        session.getTransaction().commit();
        System.out.println("Finded: " + students.size() + "students ");
        return students;

    }
    public static void deleteAll3(){
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery("DELETE from Student WHERE name = 'Aza'");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleteAll:");
    }
}

 //}
//public static Works update(int id, String name, String surname, String course, int age){
//        Session session = HibernateUtil.getSession().openSession();
//        session.beginTransaction();
//        Works student= session.get(Works.class,id);
//        student.setId(id);
//        student.setName(name);
//        student.setSurname(surname);
//        student.setCourse(course);
//        student.setAge(age);
//        session.getTransaction().commit();
//        session.close();
//        System.out.println("Successfully updated: ");
//        return student;
//        }
//public static void deleteById(int id){
//        Session session = HibernateUtil.getSession().openSession();
//        session.beginTransaction();
//        Works student = session.get(Works.class,id);
//        session.delete(student);
//        session.getTransaction().commit();
//        session.close();
//        System.out.println("Successfully delete:");
//        }
//public static void deleteAll(){
//        Session session = HibernateUtil.getSession().openSession();
//        session.beginTransaction();
//        Query query = session.createQuery("DELETE from Works ");
//        query.executeUpdate();
//        session.getTransaction().commit();
//        session.close();
//        System.out.println("Successfully deleteAll:");
//
//
//        }
//public static Works getById(int id){
//        Session session = HibernateUtil.getSession().openSession();
//        Works student = session.get(Works.class,id);
//        session.close();
//        return student;