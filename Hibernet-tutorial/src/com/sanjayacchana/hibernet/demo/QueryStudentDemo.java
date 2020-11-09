package com.sanjayacchana.hibernet.demo;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sanjayacchana.hibernet.entity.Student;

public class QueryStudentDemo {

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
			
			//start the transaction
			System.out.println("Starting the session transaction: ");
			session.beginTransaction();
			
			//query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display list of stuents
			displayStudent(theStudents);
			
			//query student whose first name is sanjay
			theStudents =  session.createQuery("from Student s where s.firstName = 'sanjay'").getResultList();
			
			//display list of stuents
			System.out.println("\n\n Dispaly student where firstName is Sanjay");
			displayStudent(theStudents);
			
			//query students where first name =siva or lastname = acchana
			theStudents = session.createQuery("from Student s where s.firstName='siva' OR s.lastName='acchana'").getResultList();
			
			//display student
			System.out.println("\n\nstudents where first name =siva or lastname = acchana");
			displayStudent(theStudents);
			
			//query student LIKE '@gmail.com'
			theStudents = session.createQuery("from Student s where s.email LIKE '%@gmail.com'").getResultList();
			
			//display Students results
			System.out.println("\n\nquery student LIKE '@gmail.com'");
			displayStudent(theStudents);
			
			//commit transaction
			System.out.println("Commiting the Transaction: ");
			session.getTransaction().commit();
			
			System.out.println("saving... Done:)");
		}finally {
			factory.close();
		}
	}
	public static void displayStudent(List<Student> theStudents) {
		for(Student student: theStudents) {
			System.out.println(student);
		}
	}

}
