package br.com.tecnopon.sistecomie.model;

import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@EqualsAndHashCode
@Entity
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employerIdentificationNumber;
    private String tradeName;
    private String companyName;

    public Customer() {

    }

    public Customer(String employerIdentificationNumber, String tradeName, String companyName) {
        this.employerIdentificationNumber = employerIdentificationNumber;
        this.tradeName = tradeName;
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

}
