package io.project.Employee.ManagementSystem.Controller;

import io.project.Employee.ManagementSystem.Entity.Employee;
import io.project.Employee.ManagementSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("allemployeelist",employeeService.getallemployees());
        return "index";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee){
        employeeService.saveemployee(employee);
        return "redirect:/";
    }

    @GetMapping("/addnewemployee")
    public String addnewEmployee(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "addnewemployee";
    }
    @GetMapping("/updateform/{id}")
    public String showUpdateForm(@PathVariable("id") Long employeeID, Model model) {
        Employee employee = employeeService.getemployeebyID(employeeID);
        model.addAttribute("employee", employee);
        return "updateform";
    }
    @GetMapping("/delete/{id}")
    public String deleteByID(@PathVariable(value = "id") Long ID){
        employeeService.deletebyId(ID);
        return "redirect:/";
    }
    @PostMapping("/updateform/{id}")
    public String updateEmployee(@PathVariable("id") Long employeeId, @ModelAttribute("employee") Employee updatedEmployee) {
        Employee existingEmployee = employeeService.getemployeebyID(employeeId);
        existingEmployee.setEmployeeName(updatedEmployee.getEmployeeName());
        existingEmployee.setEmployeeEmail(updatedEmployee.getEmployeeEmail());
        existingEmployee.setEmployeeAge(updatedEmployee.getEmployeeAge());
        existingEmployee.setEmployeeDesignation(updatedEmployee.getEmployeeDesignation());
        employeeService.saveemployee(existingEmployee);
        return "redirect:/";
    }

}
