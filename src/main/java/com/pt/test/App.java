package com.pt.test;

import com.pt.dao.EmployeeDAO;
import com.pt.domain.Employee;

public class App {
	public static void main(String[] args) {
		Employee emp = null;
		EmployeeDAO dao;
		dao = new EmployeeDAO();
		emp = dao.GetDetails(16);
		System.out.println("-----98689");
		System.out.println(emp);
			
	}
}
