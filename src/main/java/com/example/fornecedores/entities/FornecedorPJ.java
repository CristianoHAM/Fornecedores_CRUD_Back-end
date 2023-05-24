package com.example.fornecedores.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("J")
public class FornecedorPJ extends Fornecedor{
    @Column(name = "cnpj", unique = true, nullable = false)
    public String cnpj;

    @Override
    public void setCnpj(String cnpj) {
        super.setCnpj(cnpj);
    }

}
