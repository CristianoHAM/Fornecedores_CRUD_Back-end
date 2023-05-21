package com.example.fornecedores.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class RegistroEmpresaKey implements Serializable {

    @Column(name = "empresa_fk")
    String empresa_fk;
    @Column(name = "fornecedor_fk")
    String fornecedor_fk;


}
