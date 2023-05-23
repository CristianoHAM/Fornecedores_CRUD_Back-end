package com.example.fornecedores.dto;

import com.example.fornecedores.entities.Fornecedor;
import com.example.fornecedores.entities.FornecedorPF;
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
public class FornecedorPJResponseDTO {

    private Long id;
    private String tipo;
    private String cnpj;
    private String nome;
    private String email;
    private String cep;

    public FornecedorPJResponseDTO(FornecedorPJ fornecedor){
        id = fornecedor.getId();
        tipo = fornecedor.getTipo();
        nome = fornecedor.getNome();
        email = fornecedor.getEmail();
        cep = fornecedor.getCep();
        cnpj = fornecedor.getCnpj();
    }


}
