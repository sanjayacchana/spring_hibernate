package com.sanjayacchana.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sanjayacchana.hibernet.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		
		//create a session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 3;
			
			//start the transaction
			System.out.println("Starting the session transaction: ");
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrive the student based on primary key
			System.out.println("\n\nretrive the student based on primary key"+ studentId);
			Student student = session.get(Student.class, studentId);
			
			//Deleting  the student 
			System.out.println("Deleting the student");
			session.delete(studentId);
			
			//commit transaction
			System.out.println("Commiting the Transaction: ");
			session.getTransaction().commit();
		
			//start new transaction
			System.out.println("\n\n Starting new session Transaction");
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//Deleting the email of student whose lastname =akkineni
			System.out.println("DELETE FROM Student s  WHERE s.lastname =akkineni");
			session.createQuery("DELETE FROM Student s  WHERE s.lastName ='akkineni'").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("saving... Done:)");
			
		}finally {
			factory.close();
		}
		
		
		

	}

}
