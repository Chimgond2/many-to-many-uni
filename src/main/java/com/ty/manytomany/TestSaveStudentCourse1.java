package com.ty.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveStudentCourse1 {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student = new Student();
		student.setAge(56);
		student.setName("kavya");

		Course course1 = entityManager.find(Course.class, 2);
		Course course2 = entityManager.find(Course.class, 3);
		
		List<Course> courses=new ArrayList<Course>();
		courses.add(course1);
		courses.add(course2);
		
		student.setCourse(courses);
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();

		
	}

}
