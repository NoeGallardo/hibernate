package com.noegallardo.jdbc;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.noegallardo.entity.Student;

public class TestJdbc {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		try {
			/*
			 * System.out.println("Creatin new Student Object"); Student tempStudent = new
			 * Student("Noe", "Gallardo", "noe.gallardo@sanmina.com"); Student tempStudent2
			 * = new Student("Faby", "Ramirez", "Faby.Ramirez@sanmina.com"); Student
			 * tempStudent3 = new Student("Ana", "Mendez", "Ana.Mendez@sanmina.com");
			 * Student tempStudent4 = new Student("Emma", "Ureña",
			 * "Emma.Ureña@sanmina.com");
			 */
			session.beginTransaction();
			
			System.out.println("Antes del Get result");
			
			List<Student> students = session.createQuery("from Student s where s.first_name='Noe' AND s.last_name = 'Silva'").getResultList();
			
			System.out.println("Despues del Get Result");
			
			for(Student student: students) {
				System.out.println(student.toString());
			}
			/*
			 * System.out.println(tempStudent.toString()); session.save(tempStudent);
			 * session.save(tempStudent2); session.save(tempStudent3);
			 * session.save(tempStudent4);
			 */
			System.out.println("Saving the new Student");
			
			session.getTransaction().commit();
			System.out.println("Done");
			
		}finally {
			factory.close();
		}
	}

}
