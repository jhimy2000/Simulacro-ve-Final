package com.examenfinal.apiexamenfinal201818218.repository;

import com.examenfinal.apiexamenfinal201818218.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //Usando Query Method (Keywords)
    boolean existsByName(String name);
    boolean existsByDni(String dni);
}
