package com.ty.manytomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveGetStudentById {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Student student=entityManager.find(Student.class, 1);
		if(student!=null) {
			System.out.println("student age is : "+student.getAge());
			System.out.println("student name is : "+student.getName());
			System.out.println("student id is : "+student.getId());
			
			System.err.println("=====================");
			
			List<Course> courses=student.getCourse();
			for(Course course:courses) {
				System.out.println("course id is : "+course.getId());
				System.out.println("course durention is : "+course.getDuration());
				System.out.println("course name is : "+course.getName());
				System.out.println("_________________");
			}
		}
		
		
	}

}
