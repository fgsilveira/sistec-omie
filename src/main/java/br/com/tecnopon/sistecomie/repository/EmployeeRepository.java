package br.com.tecnopon.sistecomie.repository;

import br.com.tecnopon.sistecomie.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmployeeUsername(String employeeUsername);
}
