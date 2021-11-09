package com.noegallardo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.noegallardo.entity.Student;

public class TestJdbc {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creatin new Student Object");
			Student tempStudent = new Student("Paul", "Simon", "paul.walker@sanmina.com");
			session.beginTransaction();
			session.save(tempStudent);
			System.out.println("Saving the new Student");
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			factory.close();
		}
	}

}
