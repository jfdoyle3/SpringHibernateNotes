package entity.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;

public class EagerLazyExample {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);


			System.out.println("Fetching example: Instructor: " + tempInstructor);
			
			// option 1: call getter method while the session is open
			System.out.println("Fetching example: Courses: " + tempInstructor.getCourses());
			
			
			// commit transaction
			session.getTransaction().commit();

			// close session
			session.close();

			System.out.println("\nFetching example: The session is now closed.\n");
			System.out.println("Fetching LAZY emample: Using the getter while the session is open to retrieve the data");
			System.out.println("Fetching LAZY emample: The data is stored in the variable");
			System.out.println("Fetching LAZY emample: The code can call the getter and retrieve the data");
			System.out.println("Fetching LAZY example: after the session is closed\n");
			
			// get course for the instructor
			System.out.println("Fetching LAZY example: Courses: " + tempInstructor.getCourses());
			System.out.println("Fetching example: Done!");

		} finally {
			session.close();
			factory.close();
		}
	}
}
