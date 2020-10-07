package com.stradtkt.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.stradtkt.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Creating a new student object...");
			Student tempStudent = new Student("Barabra", "Jones", "b.jones@gmail.com");
			session.beginTransaction();
			System.out.println("Saving the student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			session.getTransaction().commit();
			System.out.println("Saved student. Generated ID: " + tempStudent.getId());
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Getting the student with the ID: " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("GET complete: " + myStudent);
			session.getTransaction().commit();
			System.out.println("All done...");
		} finally {
			factory.close();
		}
	}

}
