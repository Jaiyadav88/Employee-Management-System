package io.project.Employee.ManagementSystem.Service;

import io.project.Employee.ManagementSystem.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getallemployees();
    public Employee getemployeebyID(Long employeeId);
    public Employee getemployeebyName(String employeeName);
    public void saveemployee(Employee employee);
    public void deletebyId(Long employeeId);

}
