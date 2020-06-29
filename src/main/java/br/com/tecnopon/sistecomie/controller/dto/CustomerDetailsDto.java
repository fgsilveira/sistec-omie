package br.com.tecnopon.sistecomie.controller.dto;

import br.com.tecnopon.sistecomie.model.Customer;

public class CustomerDetailsDto {

    private Long id;
    private String employerIdentificationNumber;
    private String tradeName;
    private String companyName;

    public CustomerDetailsDto(Customer customer) {
        this.id = customer.getId();
        this.employerIdentificationNumber = customer.getEmployerIdentificationNumber();
        this.tradeName = customer.getTradeName();
        this.companyName = customer.getCompanyName();
    }

    public Long getId() {
        return id;
    }

    public String getEmployerIdentificationNumber() {
        return employerIdentificationNumber;
    }

    public String getTradeName() {
        return tradeName;
    }

    public String getCompanyName() {
        return companyName;
    }

}
