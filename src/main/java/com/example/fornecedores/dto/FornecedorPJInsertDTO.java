package com.example.fornecedores.dto;

import com.example.fornecedores.entities.FornecedorPJ;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorPJInsertDTO {
    private String nome;
    private String email;
    private String cep;
    private String cnpj;

}
