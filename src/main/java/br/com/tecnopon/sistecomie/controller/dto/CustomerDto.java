package br.com.tecnopon.sistecomie.controller.dto;

import br.com.tecnopon.sistecomie.model.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerDto {

    private Long id;
    private String name;

    public CustomerDto(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getTradeName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static List<CustomerDto> convert(List<Customer> customers) {
        return customers.stream().map(CustomerDto::new).collect(Collectors.toList());
    }
}
