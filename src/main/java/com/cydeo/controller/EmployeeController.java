package com.cydeo.controller;


import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {


    @RequestMapping("/register")
    public String createEmployee(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("states", DataGenerator.getAllStates());

        return "employee/employee-create";
    }

    @PostMapping("/list")
    public String employeeList(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult,
                               //we have to put BindingResult right after validation object
                               //we cannot put BindingResult interface anywhere we want, ex: cannot put after Model model interface
                               Model model){
        if(bindingResult.hasErrors()){

            model.addAttribute("states", DataGenerator.getAllStates());
            return "employee/employee-create";
        }
      DataGenerator.saveEmployee(employee);
      model.addAttribute("employees",DataGenerator.readAllEmployees());

        return "employee/employee-list";
    }


}
