package br.com.tecnopon.sistecomie.controller.form;

import br.com.tecnopon.sistecomie.model.Customer;

public class CustomerForm {

    private String employerIdentificationNumber;

    public String getEmployerIdentificationNumber() {
        return employerIdentificationNumber;
    }

    public void setEmployerIdentificationNumber(String employerIdentificationNumber) {
        this.employerIdentificationNumber = employerIdentificationNumber;
    }

    public Customer convert() {

        return new Customer(employerIdentificationNumber);
    }
}
