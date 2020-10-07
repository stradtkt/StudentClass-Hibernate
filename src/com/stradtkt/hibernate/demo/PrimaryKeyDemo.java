package com.stradtkt.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.stradtkt.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Creating 3 new student objects...");
			Student tempStudent1 = new Student("Patrick", "James", "p.james@yahoo.com");
			Student tempStudent2 = new Student("Mary", "Johnson", "m.johnson@hotmail.com");
			Student tempStudent3 = new Student("John", "Doe", "j.doe@outlook.com");
			session.beginTransaction();
			System.out.println("Saving the student");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			session.getTransaction().commit();
			System.out.println("All done...");
		} finally {
			factory.close();
		}
	}

}
