package com.bncmy.clientes.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="datospersonales")
public class DatosPersonales implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional=false)
    @Column(name="id")
    private Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido_pat")
    private String apellido_pat;
    @Column(name="apellido_mat")
    private String apellido_mat;
    @Column(name="estatus")
    private boolean estatus;
    @Column(name="domicilioid")
    private String dom_id;
    @Column(name="fecha_crea")
    private String fec_crea;
    @Column(name="fecha_mod")
    private String fec_mod;

    public Long getId() {
        return id;
    }

    public void setDatosId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_pat() {
        return apellido_pat;
    }

    public void setApellido_pat(String apellido_pat) {
        this.apellido_pat = apellido_pat;
    }

    public String getApellido_mat() {
        return apellido_mat;
    }

    public void setApellido_mat(String apellido_mat) {
        this.apellido_mat = apellido_mat;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public String getDom_id() {
        return dom_id;
    }

    public void setDom_id(String dom_id) {
        this.dom_id = dom_id;
    }

    public String getFec_crea() {
        return fec_crea;
    }

    public void setFec_crea(String fec_crea) {
        this.fec_crea = fec_crea;
    }

    public String getFec_mod() {
        return fec_mod;
    }

    public void setFec_mod(String fec_mod) {
        this.fec_mod = fec_mod;
    }
}
