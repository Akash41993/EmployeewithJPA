package com.example.demo.Service;



import com.example.demo.Entity.Employee;

import java.util.List;


public interface EmployeeService {
    List<Employee> findall();

    Employee findbyId(int id);

    Employee save(Employee employee);

    void deletebyId(int id);
}
