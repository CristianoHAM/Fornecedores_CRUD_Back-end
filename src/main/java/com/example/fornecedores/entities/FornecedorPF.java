package com.example.fornecedores.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("F")
public class FornecedorPF extends Fornecedor{

    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;

    @Column(name = "rg", nullable = false)
    private String rg;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;


    @Override
    public void setCpf(String cpf) {
        super.setCpf(cpf);
    }
    @Override
    public void setRg(String rg) {
        super.setRg(rg);
    }
    @Override
    public void setDataNascimento(LocalDate dataNascimento) {
        super.setDataNascimento(dataNascimento);
    }

}
