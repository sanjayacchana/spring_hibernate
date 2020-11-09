package com.sanjayacchana.hibernet.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sanjayacchana.hibernet.entity.Instructor;
import com.sanjayacchana.hibernet.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			
			//get instructor detail object
			int myId = 2;
			InstructorDetail theInstructorDetail = session.get(InstructorDetail.class, myId);
			
			//print the instructor detail
			System.out.println("theInstructorDetail :"+theInstructorDetail);
			
			//print the associated instructor
			System.out.println("the associated instructor :"+theInstructorDetail.getInstructor());
			
			//now let's delete the instructor detail
			System.out.println("Deleting the Instructor detail: " +theInstructorDetail);
			
			session.delete(theInstructorDetail);
			
			//commit transaction
			System.out.println("Commiting the Transaction: ");
			session.getTransaction().commit();
			
			System.out.println("saving... Done:)");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
