package br.com.tecnopon.sistecomie.repository;

import br.com.tecnopon.sistecomie.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
