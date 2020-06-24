package br.com.tecnopon.sistecomie.controller;

import br.com.tecnopon.sistecomie.controller.dto.CustomerDto;
import br.com.tecnopon.sistecomie.controller.form.CustomerForm;
import br.com.tecnopon.sistecomie.model.Customer;
import br.com.tecnopon.sistecomie.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<CustomerDto> list() {
        List<Customer> customers = customerRepository.findAll();
        return CustomerDto.convert(customers);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> add(@RequestBody CustomerForm customerForm, UriComponentsBuilder uriComponentsBuilder) {
        Customer customer = customerForm.convert();
        customerRepository.save(customer);

        URI uri = uriComponentsBuilder.path("/customers/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(new CustomerDto(customer));
    }
}
