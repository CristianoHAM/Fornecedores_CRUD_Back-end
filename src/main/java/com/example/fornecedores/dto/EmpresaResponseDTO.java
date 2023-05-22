package com.example.fornecedores.dto;

import com.example.fornecedores.entities.Empresa;

public record EmpresaResponseDTO(String cnpj, String nomeFantasia, String cep) {
    public EmpresaResponseDTO(Empresa empresa){
        this(empresa.getCnpj(), empresa.getNomefantasia(), empresa.getCep());
    }

}
