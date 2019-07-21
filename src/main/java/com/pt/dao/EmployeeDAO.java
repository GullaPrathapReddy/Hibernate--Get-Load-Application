package com.pt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.pt.domain.Employee;
import com.pt.utility.HibernateUtility;

public class EmployeeDAO {
	Transaction tx = null;
	private Session ses;
	boolean flag = false;

	public Employee GetDetails(int eno) {
		ses = HibernateUtility.getInstance();
		Transaction tx = null;
		Employee emp = null;
		try {
			System.out.println("------");
			tx = ses.beginTransaction();
			emp = ses.get(Employee.class, eno);
			flag = true;
		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("Getting Record Successfully");
			} else {
				tx.rollback();
				System.out.println("Sorry internal problem");
			}
			
			/*HibernateUtility.closeSession(ses);*/
		}
		return emp;
	}

}
