package com.sanjayacchana.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sanjayacchana.hibernet.entity.Course;
import com.sanjayacchana.hibernet.entity.Instructor;
import com.sanjayacchana.hibernet.entity.InstructorDetail;
import com.sanjayacchana.hibernet.entity.Review;
import com.sanjayacchana.hibernet.entity.Student;

public class GetCoursesForStudentsDemo {

	public static void main(String[] args) {

		// create a session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.addAnnotatedClass(Review.class)
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();

		try {
			
			// start the transaction
			System.out.println("Starting the session transaction: ");
			session.beginTransaction();
			
			//get student from db
			int studentId = 2;
			Student theStudent = session.get(Student.class, studentId);
			
			
			System.out.println("Fetched Student details: "+theStudent);
			System.out.println("Student with same courses: "+theStudent.getCourses());
			
			
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
