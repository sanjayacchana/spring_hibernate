package com.sanjayacchana.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sanjayacchana.hibernet.entity.Instructor;
import com.sanjayacchana.hibernet.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		
		//create a session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			/*
			 * //create the objects Instructor theInstructor = new Instructor("sanjay",
			 * "acchana", "sanjayacchana@gmail.com");
			 * 
			 * InstructorDetail theInstructorDetail = new InstructorDetail(
			 * "https://www.luv2code.com/youtube","Luv 2 Code");
			 */
			
			//create the objects
			Instructor theInstructor = new Instructor("kumar", "acchana", "kumaracchana@gmail.com");
			
			InstructorDetail theInstructorDetail = new InstructorDetail(
					"https://www.luv2code.com/youtube","Ludo");
			
			//associate the objects
			theInstructor.setInstructorDetail(theInstructorDetail);
			
			//start the transaction
			System.out.println("Starting the session transaction: ");
			session.beginTransaction();
			
			
			//save the instructor
			System.out.println("Saving Instructor: " + theInstructor);
			session.save(theInstructor);
			
			
			//commit transaction
			System.out.println("Commiting the Transaction: ");
			session.getTransaction().commit();
			
			System.out.println("saving... Done:)");
			
		}finally {
			factory.close();
		}
		
		
		

	}

}
