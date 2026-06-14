package com.afeez.ems;

public class Employee {

	private int empId;
	private String empName;
	private long empPhone;
	private double empSalary;

	public Employee() {
	}

	public Employee(int empId, String empName, long empPhone, double empSalary) {
		this.empId = empId;
		this.empName = empName;
		this.empPhone = empPhone;
		this.empSalary = empSalary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public long getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(long empPhone) {
		this.empPhone = empPhone;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empPhone=" + empPhone
				+ ", empSalary=" + empSalary + "]";
	}
}