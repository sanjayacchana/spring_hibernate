package com.sanjayacchana.hibernet.demo;

import java.nio.channels.SeekableByteChannel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sanjayacchana.hibernet.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		
		//create a session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			//use the session object to save java object
			
			// create the student object
			System.out.println("Creating a new student object:");
			Student theStudent = new Student("sanjay", "acchana", "sanjayacchana@gmail.com");
			
			//start the transaction
			System.out.println("Starting the session transaction: ");
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the Student Object: ");
			session.save(theStudent);
			
			//commit transaction
			System.out.println("Commiting the Transaction: ");
			session.getTransaction().commit();
			
			System.out.println("saving... Done:)");
			
		}finally {
			factory.close();
		}
		
		
		

	}

}
