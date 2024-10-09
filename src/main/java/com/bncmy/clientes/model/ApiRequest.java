package com.bncmy.clientes.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class ApiRequest {

    private Clientes cliente;
    private DatosPersonales datospersonales;
    private Domicilio domicilio;

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public DatosPersonales getDatospersonales() {
        return datospersonales;
    }

    public void setDatospersonales(DatosPersonales datospersonales) {
        this.datospersonales = datospersonales;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
}
