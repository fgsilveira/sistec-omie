package br.com.tecnopon.sistecomie.config.security;

import br.com.tecnopon.sistecomie.model.Employee;
import br.com.tecnopon.sistecomie.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public AuthenticationService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String employeeUsername) throws UsernameNotFoundException {
        Optional<Employee> employee = employeeRepository.findByEmployeeUsername(employeeUsername);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new UsernameNotFoundException("User not found");
    }
}
