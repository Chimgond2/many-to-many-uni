
package com.ty.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveCabPerson {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Cab cab=new Cab();
		cab.setDriverName("kulkarni");
		cab.setCost(59);
		
		Person person1=new Person();
		person1.setName("sharma");
		person1.setAge(22);
		person1.setEmail("sharma@gmail.com");
		
		Person person2=new Person();
		person2.setName("varma");
		person2.setAge(18);
		person2.setEmail("varma@gmail.com");
		
		
		
		List<Person> persons=new ArrayList<Person>();
		persons.add(person1);
		persons.add(person2);
		
		cab.setPersons(persons);
		
		entityTransaction.begin();
		entityManager.persist(cab);
		entityManager.persist(person1);
		entityManager.persist(person2);
		
		entityTransaction.commit();
		
		
	}

}
