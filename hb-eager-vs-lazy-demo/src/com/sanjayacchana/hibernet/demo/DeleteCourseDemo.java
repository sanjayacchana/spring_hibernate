package com.sanjayacchana.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sanjayacchana.hibernet.entity.Course;
import com.sanjayacchana.hibernet.entity.Instructor;
import com.sanjayacchana.hibernet.entity.InstructorDetail;

public class DeleteCourseDemo {

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
			
			//get the course
			int courseId = 10;
			
			Course theCourse = session.get(Course.class, courseId);
			
			//delete the course
			System.out.println("Deleting the course: "+theCourse);
			session.delete(theCourse);
			
			
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
