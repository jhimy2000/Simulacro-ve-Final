package com.examenfinal.apiexamenfinal201818218.controller;


import com.examenfinal.apiexamenfinal201818218.exception.ValidationException;
import com.examenfinal.apiexamenfinal201818218.model.Employee;
import com.examenfinal.apiexamenfinal201818218.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public   EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    //Endopint (url): http://locahost:8080/api/v1/employees
    //Method: POST
    @Transactional
    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        validateEmployee(employee);
        existsEmployeeByNameOrDni(employee);
        return new ResponseEntity<Employee>(employeeRepository.save(employee), HttpStatus.CREATED);

    }

    //Endopint (url): http://locahost:8080/api/v1/employees
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);

    }

    //Reglas de negocio
    //Validaciones
    private void validateEmployee(Employee employee){
        if (employee.getName()==null || employee.getName().trim().isEmpty()){
            throw new ValidationException("El nombre del empleado es obligatorio");
        }
        if (employee.getName().length()>30){
            throw new ValidationException("El nombre del empleado no debe de exceder los 30 ca");
        }
        if (employee.getDni()==null || employee.getDni().trim().isEmpty()){
            throw new ValidationException("“El dni del empleado" + "es obligatorio");
        }
        if (employee.getDni().length()>8){
            throw new ValidationException("El dni del empleado no debe de exceder los 8 c");
        }
        if (employee.getDni().length()>8){
            throw new ValidationException("El dni del empleado no debe de exceder los 8 c");
        }
        if (employee.getHorasTrabajadas()<20||employee.getHorasTrabajadas()>30)
        {
            throw new ValidationException("Las horas trabajadas del empleado debe estar en un rango de 20 y 30");
        }
        if (employee.getHorasExtras()<2||employee.getHorasExtras()>10)
        {
            throw new ValidationException("Las horas extras del empleado debe estar en un rango de 2 y 10");
        }
    }

    private void existsEmployeeByNameOrDni(Employee employee)
    {
        if (employeeRepository.existsByName(employee.getName())&&employeeRepository.existsByDni(employee.getDni()))
        {
            throw new ValidationException("“El nombre y dni del empleado ya existe");
        }
        if (employeeRepository.existsByName(employee.getName()))
        {
            throw new ValidationException("El nombre del empleado ya existee");
        }
        if (employeeRepository.existsByDni(employee.getDni()))
        {
            throw new ValidationException("El dni del empleado ya existe");
        }
    }
}
