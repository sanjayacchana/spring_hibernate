package com.sanjayacchana.hibernet.demo;

import java.nio.channels.SeekableByteChannel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sanjayacchana.hibernet.entity.Instructor;
import com.sanjayacchana.hibernet.entity.InstructorDetail;
import com.sanjayacchana.hibernet.entity.Student;

public class DeleteDemo {

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
			
			
			
			//start the transaction
			System.out.println("Starting the session transaction: ");
			session.beginTransaction();
			
			// get instructor primary id which is id
			int theId = 1;
			Instructor theInstructor = session.get(Instructor.class, theId);
			System.out.println("Founded Instructor: "+theInstructor);
			
			//delete instructor
			if(theInstructor != null) {
				System.out.println("Deleting the Instructor: "+theInstructor);
				session.delete(theInstructor);
			}
			
			//commit transaction
			System.out.println("Commiting the Transaction: ");
			session.getTransaction().commit();
			
			System.out.println("saving... Done:)");
			
		}finally {
			factory.close();
		}
		
		
		

	}

}
