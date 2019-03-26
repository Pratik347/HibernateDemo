package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.Address;
import entity.StudentEntity;
import util.HibernateUtil;

public class StudentManager {
	
	public void insert() {
		
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		StudentEntity studentEntity = new StudentEntity(102,"Smith",70,"B");
		
		Address address = new Address ();
		address.setStreet("OMR");
		address.setArea("Siruseri");
		
		studentEntity.setAddress(address);
		
		session.save(studentEntity);
		System.out.println("------after save------");
		transaction.commit();
		System.out.println("------after commit-----");
		
		session.close();
	}
	
	public void delete() {
		StudentEntity studentEntity=null;
		
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		List list = session.createQuery("from StudentEntity").list();
		studentEntity = (StudentEntity)list.get(0);
		
		session.delete(studentEntity);
		
        /*Query qry = session.createQuery("delete from Student where id=102");
		int query = qry.executeUpdate();*/
		transaction.commit();
		
		session.close();
	}
	
	public void update() {
		StudentEntity studentEntity=null;
		
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		List list = session.createQuery("from StudentEntity").list();
		studentEntity = (StudentEntity)list.get(0);
		
		studentEntity.setMarks(100);
		transaction.commit();

	}
	
	public void list() {
        StudentEntity studentEntity=null;
		
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		
		List list = session.createQuery("from StudentEntity").list();
		
        for(int i=0;i<list.size();i++) {			
			studentEntity = (StudentEntity)list.get(i);
			System.out.println(studentEntity.getId()+" "+studentEntity.getCname()+" "+studentEntity.getMarks()+" "+studentEntity.getGrade());
		}
		
        session.close();		
		
	}
}
