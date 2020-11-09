package com.sanjayacchana.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sanjayacchana.hibernet.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// create a session factory
		SessionFactory factor = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		//create a session
		Session session = factor.getCurrentSession();
		
		try {
			//use the session object to save java object
			
			// create 3  student object
			System.out.println("Creating  3 new student object:");
			Student theStudent1 = new Student("sravani", "acchana", "sravaniacchana@gmail.com");
			Student theStudent2 = new Student("siva", "acchana", "sivaacchana@gmail.com");
			Student theStudent3 = new Student("kumar", "acchana", "kumaracchana@gmail.com");
			
			//start the transaction
			System.out.println("Starting the session transaction: ");
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the Student Object: ");
			session.save(theStudent1);
			session.save(theStudent2);
			session.save(theStudent3);
			
			//commit transaction
			System.out.println("Commiting the Transaction: ");
			session.getTransaction().commit();
			
			System.out.println("saving... Done:)");
			
		}finally {
			factor.close();
		}
		
		
		
		

	}

}
