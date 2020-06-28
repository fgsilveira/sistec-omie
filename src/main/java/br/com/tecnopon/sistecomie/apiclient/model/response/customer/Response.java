package br.com.tecnopon.sistecomie.apiclient.model.response.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Response {

    @JsonProperty("pagina")
    int page;
    @JsonProperty("total_de_paginas")
    int totalPages;
    @JsonProperty("registros")
    int registrations;
    @JsonProperty("total_de_registros")
    int totalRegistrations;
    @JsonProperty("clientes_cadastro_resumido")
    List<CustomerSummaryRegistration> registrationSummaries;

    public Response() {

    }

    public Response(int page, int totalPages, int registrations, int totalRegistrations, List<CustomerSummaryRegistration> summaries) {
        this.page = page;
        this.totalPages = totalPages;
        this.registrations = registrations;
        this.registrationSummaries = summaries;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getRegistrations() {
        return registrations;
    }

    public void setRegistrations(int registrations) {
        this.registrations = registrations;
    }

    public int getTotalRegistrations() {
        return totalRegistrations;
    }

    public void setTotalRegistrations(int totalRegistrations) {
        this.totalRegistrations = totalRegistrations;
    }

    public List<CustomerSummaryRegistration> getRegistrationSummaries() {
        return registrationSummaries;
    }

    public void setRegistrationSummaries(List<CustomerSummaryRegistration> registrationSummaries) {
        this.registrationSummaries = registrationSummaries;
    }

    @Override
    public String toString() {
        return "Response{" +
                "page=" + page +
                ", totalPages=" + totalPages +
                ", registrations=" + registrations +
                ", totalRegistrations=" + totalRegistrations +
                ", registrationSummaries=" + registrationSummaries +
                '}';
    }
}
