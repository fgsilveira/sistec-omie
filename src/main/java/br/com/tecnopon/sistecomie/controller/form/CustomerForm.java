package br.com.tecnopon.sistecomie.controller.form;

import br.com.tecnopon.sistecomie.apiclient.ApiClient;
import br.com.tecnopon.sistecomie.apiclient.model.response.customer.Response;
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
        ApiClient apiClient = new ApiClient();

        Response response = apiClient.requestCustomer(employerIdentificationNumber);

        return new Customer(response.getRegistrationSummaries().get(0).getEmployerIdentificationNumber(), response.getRegistrationSummaries().get(0).getTradeName(), response.getRegistrationSummaries().get(0).getCompanyName());
    }
}
