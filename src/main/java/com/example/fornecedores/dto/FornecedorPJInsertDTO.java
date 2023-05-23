package com.example.fornecedores.dto;

import com.example.fornecedores.entities.Fornecedor;
import com.example.fornecedores.entities.FornecedorPJ;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorPJInsertDTO {
    private String nome;
    private String email;
    private String cep;
    private String cnpj;




    public FornecedorPJInsertDTO(FornecedorPJ fornecedor){
         nome = fornecedor.getNome();
         email = fornecedor.getEmail();
         cep = fornecedor.getCep();
         cnpj = fornecedor.getCnpj();
    }

}
