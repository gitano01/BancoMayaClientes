package com.bncmy.clientes.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="domicilio")
public class Domicilio implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional=false)
    @Column(name="id")
    private Long id;
    @Column(name="calle")
    private String calle;
    @Column(name="colonia")
    private String colonia;
    @Column(name="cod_postal")
    private String cod_postal;
    @Column(name="delegacion")
    private String delegacion;
    @Column(name="estado")
    private String estado;
    @Column(name="ciudad")
    private String ciudad;
    @Column(name="pais")
    private String pais;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(String cod_postal) {
        this.cod_postal = cod_postal;
    }

    public String getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(String delegacion) {
        this.delegacion = delegacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
