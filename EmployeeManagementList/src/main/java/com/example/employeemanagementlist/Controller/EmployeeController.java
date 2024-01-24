package com.example.employeemanagementlist.Controller;

import com.example.employeemanagementlist.Domain.Employee;
import com.example.employeemanagementlist.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/EmployeeHomepage")
    public String homePage(Model model){
        model.addAttribute("employee",employeeService.getAllEmployees());
        return "home";

    }
    @GetMapping("/ShowEmployeeForm")
    public String showEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        model.addAttribute("nextPage","New Employee");
        return "New_Employee";

    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes){
        employeeService.saveEmployee(employee);
        redirectAttributes.addFlashAttribute("message", "Employee employed");
        redirectAttributes.addFlashAttribute("color", "success");

        return "redirect:/EmployeeHomepage";
    }
    @GetMapping("/updateEmployeeRecord/{id}")
    public String showEditForm(@PathVariable("id") Integer Id, Model model, RedirectAttributes redirectAttributes) {
        try {
           Employee employee = employeeService.getEmployeeById(Id);
            model.addAttribute("employee", employee);
            model.addAttribute("pageTitle", "Edit Employee Id:" + Id);
            return "updateEmployeeRecord";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            redirectAttributes.addFlashAttribute("color", "danger");

            return "redirect:/EmployeeHomepage";
        }
    }
    @PostMapping("/updateEmployeeRecord")
    public String updateEmployeeRecord(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes){
        try {
            employeeService.saveEmployee(employee);
            redirectAttributes.addFlashAttribute("message", "Employee Record updated successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Error updating employee: " + e.getMessage());
        }
        return "redirect:/EmployeeHomepage";
    }
    @GetMapping("deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable long id, RedirectAttributes redirectAttributes) {
        try {
            employeeService.deleteEmployee(id);
            redirectAttributes.addFlashAttribute("message", "Employee Deleted successfully");
            redirectAttributes.addFlashAttribute("color", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            redirectAttributes.addFlashAttribute("color", "danger");
        }

        return "redirect:/EmployeeHomepage";
    }
}
