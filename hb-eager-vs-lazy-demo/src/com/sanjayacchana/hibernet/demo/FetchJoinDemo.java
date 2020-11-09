package com.sanjayacchana.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.sanjayacchana.hibernet.entity.Course;
import com.sanjayacchana.hibernet.entity.Instructor;
import com.sanjayacchana.hibernet.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		// create a session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();

		try {
			
			// start the transaction
			System.out.println("Starting the session transaction: ");
			session.beginTransaction();
			
			// hibernate query with HQL
			
			//get the instructor from db
			int myId = 1;
			Query<Instructor> query = session.createQuery("SELECT i FROM Instructor i JOIN FETCH i.courses WHERE i.id = :theInstructorId", Instructor.class);
			
			//set parameter on query
			query.setParameter("theInstructorId", myId);
			
			//execute the query and get the instructor
			Instructor theInstructor = query.getSingleResult();
			System.out.println("Instructor: "+theInstructor);
			
			// commit transaction
			System.out.println("Commiting the Transaction: ");
			session.getTransaction().commit();

			System.out.println("saving... Done:)");

		} finally {
			session.close();
			factory.close();
		}

	}

}
