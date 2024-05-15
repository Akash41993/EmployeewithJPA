package com.example.demo.Controller;




import com.example.demo.Entity.Employee;
import com.example.demo.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    public EmployeeService employeeService;

    public RestController(EmployeeService employeeService){

        this.employeeService=employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findall(){

        return employeeService.findall();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findbyId(@PathVariable int employeeId){
        Employee employee=employeeService.findbyId(employeeId);
        if(employee==null){
            throw new RuntimeException("Employee not found with id "+ employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theemployee){
        return employeeService.save(theemployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void delete(@PathVariable int employeeId){
       Employee delemployee=employeeService.findbyId(employeeId);
       if (delemployee==null) {
           throw new RuntimeException("Employee not found with id " + employeeId);
       }
       else{
           employeeService.deletebyId(employeeId);
       }
    }
}
