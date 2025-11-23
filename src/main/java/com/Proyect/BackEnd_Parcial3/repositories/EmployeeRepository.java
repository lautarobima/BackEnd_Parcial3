package com.Proyect.BackEnd_Parcial3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Proyect.BackEnd_Parcial3.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
