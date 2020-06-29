package br.com.tecnopon.sistecomie.controller.form;

import br.com.tecnopon.sistecomie.model.Customer;
import br.com.tecnopon.sistecomie.repository.CustomerRepository;

public class UpdateCustomerForm {

    private String employerIdentificationNumber;
    private String tradeName;
    private String companyName;

    public String getEmployerIdentificationNumber() {
        return employerIdentificationNumber;
    }

    public void setEmployerIdentificationNumber(String employerIdentificationNumber) {
        this.employerIdentificationNumber = employerIdentificationNumber;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Customer update(Long id, CustomerRepository customerRepository) {
        Customer customer = customerRepository.getOne(id);

        customer.setEmployerIdentificationNumber(this.employerIdentificationNumber);
        customer.setTradeName(this.tradeName);
        customer.setCompanyName(this.companyName);

        return customer;

    }
}
