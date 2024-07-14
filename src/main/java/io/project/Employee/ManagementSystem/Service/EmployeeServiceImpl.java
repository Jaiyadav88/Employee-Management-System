package io.project.Employee.ManagementSystem.Service;

import io.project.Employee.ManagementSystem.Entity.Employee;
import io.project.Employee.ManagementSystem.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getallemployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getemployeebyID(Long employeeId) {
        Employee e=null;
        if(Objects.nonNull(employeeId)){
            Optional<Employee> emp=employeeRepository.findById(employeeId);
            if(emp.isPresent()) e=emp.get();
            else throw new RuntimeException("Employee not found with ID: "+employeeId);
        }
        return e;
    }

    @Override
    public Employee getemployeebyName(String employeeName) {
        return null;
    }

    @Override
    public void saveemployee(Employee employee) {
        if(Objects.nonNull(employee)) employeeRepository.save(employee);
    }

    @Override
    public void deletebyId(Long employeeId) {
        if(Objects.nonNull(employeeId)) employeeRepository.deleteById(employeeId);
    }
}
