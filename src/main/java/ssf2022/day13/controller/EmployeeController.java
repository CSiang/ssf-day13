package ssf2022.day13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import ssf2022.day13.model.Employee;
import ssf2022.day13.repository.EmployeeRepo;

@Controller
@RequestMapping(path = {"/employees","/","/home"})
public class EmployeeController {
    
    @Autowired
    EmployeeRepo empRepo;

    @GetMapping() //Must have this @GetMapping annotation so it will get you to the mapped html.
    public String employListPage(Model model) {

        List<Employee> employees = empRepo.findAll();
        model.addAttribute("employees", employees);

        return "employeelist";
    }

    @GetMapping("/addnew")
    public String addPage(Model model) {
        Employee emp = new Employee();
        model.addAttribute("employeeMod", emp);

        return "employeeadd";
    }

    @PostMapping("/addnew") 
    //@ModelAttribute to bind the model with the employee entity
    // The BindingResult must be in front of the Model, if not it won't work.
    public String addEmployee( @Valid @ModelAttribute("employeeMod") Employee employeeForm, BindingResult result,Model model) {

        if(result.hasErrors()) {
            return "employeeadd";
        }

        Boolean bResult = false;
        bResult =empRepo.save(employeeForm);


        return "redirect:/employees";  //Must use this redirect, if not it doesn't work.
    }

    // @GetMapping must be used because we need to display a page, which GetMapping MUST be used.
    @GetMapping("/deleteEmployee/{email}")
    public String delEmployee(@PathVariable("email") String email) {

        Employee emp = empRepo.findByEmployee(email);

        Boolean bResult = empRepo.delete(emp);

        return "redirect:/employees";
    }

}
