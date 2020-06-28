package br.com.tecnopon.sistecomie.apiclient.model.response.customer;

import br.com.tecnopon.sistecomie.model.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerSummaryRegistration {

    @JsonProperty("cnpj_cpf")
    String employerIdentificationNumber;
    @JsonProperty("codigo_cliente")
    String customerCode;
    @JsonProperty("codigo_cliente_integracao")
    String customerIntegrationCode;
    @JsonProperty("nome_fantasia")
    String tradeName;
    @JsonProperty("razao_social")
    String companyName;

    public CustomerSummaryRegistration() {

    }

    public CustomerSummaryRegistration(String employerIdentificationNumber, String customerCode, String customerIntegrationCode, String tradeName, String companyName) {
        this.employerIdentificationNumber = employerIdentificationNumber;
        this.customerCode = customerCode;
        this.customerIntegrationCode = customerIntegrationCode;
        this.tradeName = tradeName;
        this.companyName = companyName;
    }

    public String getEmployerIdentificationNumber() {
        return employerIdentificationNumber;
    }

    public void setEmployerIdentificationNumber(String employerIdentificationNumber) {
        this.employerIdentificationNumber = employerIdentificationNumber;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerIntegrationCode() {
        return customerIntegrationCode;
    }

    public void setCustomerIntegrationCode(String customerIntegrationCode) {
        this.customerIntegrationCode = customerIntegrationCode;
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

    @Override
    public String toString() {
        return "CustomerSummaryRegistration{" +
                "employerIdentificationNumber='" + employerIdentificationNumber + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", customerIntegrationCode='" + customerIntegrationCode + '\'' +
                ", tradeName='" + tradeName + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
