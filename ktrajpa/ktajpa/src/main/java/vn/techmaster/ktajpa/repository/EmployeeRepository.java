package vn.techmaster.ktajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.techmaster.ktajpa.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String>,CustomRepo<Employee> {

}

