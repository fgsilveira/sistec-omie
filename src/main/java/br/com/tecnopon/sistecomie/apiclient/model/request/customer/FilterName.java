package br.com.tecnopon.sistecomie.apiclient.model.request.customer;

public class FilterName {

    private String cnpj_cpf;

    public FilterName() {

    }

    public FilterName(String cnpj_cpf) {
        this.cnpj_cpf = cnpj_cpf;
    }

    public void setCnpj_cpf(String cnpj_cpf) {
        this.cnpj_cpf = cnpj_cpf;
    }

    public String getCnpj_cpf() {
        return cnpj_cpf;
    }
}
