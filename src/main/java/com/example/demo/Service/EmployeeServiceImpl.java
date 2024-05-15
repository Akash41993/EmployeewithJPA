package com.example.demo.Service;


import com.example.demo.DAO.EmployeeRepository;

import com.example.demo.Entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    public EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){

        this.employeeRepository=employeeRepository;
    }
    @Override
    public List<Employee> findall() {

        return employeeRepository.findAll();
    }

    @Override
    public Employee findbyId(int id) {
        Optional<Employee> result=employeeRepository.findById(id);
        Employee emp= null;
        if(result.isPresent()){
            emp=result.get();
        }
        else{
            throw new RuntimeException("Employee not found with id "+id);
        }
        return emp;
    }
    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void deletebyId(int id) {
        employeeRepository.deleteById(id);
    }


}
