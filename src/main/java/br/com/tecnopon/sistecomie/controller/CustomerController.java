package br.com.tecnopon.sistecomie.controller;

import br.com.tecnopon.sistecomie.controller.dto.CustomerDetailsDto;
import br.com.tecnopon.sistecomie.controller.dto.CustomerDto;
import br.com.tecnopon.sistecomie.controller.form.CustomerForm;
import br.com.tecnopon.sistecomie.controller.form.UpdateCustomerForm;
import br.com.tecnopon.sistecomie.model.Customer;
import br.com.tecnopon.sistecomie.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    private CustomerRepository customerRepository;

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
    @Transactional
    public ResponseEntity<CustomerDto> add(@RequestBody CustomerForm customerForm, UriComponentsBuilder uriComponentsBuilder) {
        Customer customer = customerForm.convert();
        customerRepository.save(customer);

        URI uri = uriComponentsBuilder.path("/customers/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(new CustomerDto(customer));
    }

    @GetMapping("/{id}")
    public CustomerDetailsDto details(@PathVariable Long id) {
        Customer customer = customerRepository.getOne(id);
        return new CustomerDetailsDto(customer);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CustomerDetailsDto> update(@PathVariable Long id, @RequestBody UpdateCustomerForm updateCustomerForm) {
        Customer customer = updateCustomerForm.update(id, customerRepository);

        return ResponseEntity.ok(new CustomerDetailsDto(customer));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        customerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
