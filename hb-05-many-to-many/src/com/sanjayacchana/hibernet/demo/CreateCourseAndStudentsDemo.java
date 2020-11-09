package com.sanjayacchana.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sanjayacchana.hibernet.entity.Course;
import com.sanjayacchana.hibernet.entity.Instructor;
import com.sanjayacchana.hibernet.entity.InstructorDetail;
import com.sanjayacchana.hibernet.entity.Review;
import com.sanjayacchana.hibernet.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			// create a course
			Course theCourse = new Course("Mastering chess");
			
			
			//save the corse
			session.save(theCourse);
			System.out.println("Saving is done: "+theCourse);
			
			//create the students
			Student theStudent1 = new Student("kumar", "acchana",  "kumar@gmil.com");
			Student theStudent2 = new Student("ram", "acchana",  "ram@gmil.com");
			
			//add students to course
			theCourse.addStudent(theStudent1);
			theCourse.addStudent(theStudent2);
			
			//save the students
			session.save(theStudent1);
			session.save(theStudent2);
			System.out.println("Saving the Students done: "+theCourse.getStudents());
			
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
