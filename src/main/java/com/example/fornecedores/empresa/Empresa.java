package com.example.fornecedores.empresa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "empresa")
@Entity(name = "empresa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

    @Id
    private String cnpj;
    private String nomeFantasia;
    private String cep;

    public Empresa(EmpresaRequestDTO data) {
        this.cnpj = data.cnpj();
        this.nomeFantasia = data.nomeFantasia();
        this.cep = data.cep();
    }
}
