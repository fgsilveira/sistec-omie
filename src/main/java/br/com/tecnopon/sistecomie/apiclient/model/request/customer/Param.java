package br.com.tecnopon.sistecomie.apiclient.model.request.customer;

public class Param {

    private FilterName clientesFiltro;

    public Param() {

    }

    public Param(FilterName clientesFiltro) {
        this.clientesFiltro = clientesFiltro;
    }

    public void setClientesFiltro(FilterName clientesFiltro) {
        this.clientesFiltro = clientesFiltro;
    }

    public FilterName getClientesFiltro() {
        return clientesFiltro;
    }
}
