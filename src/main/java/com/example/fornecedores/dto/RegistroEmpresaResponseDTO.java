package com.example.fornecedores.dto;

import com.example.fornecedores.entities.Empresa;
import com.example.fornecedores.entities.Fornecedor;
import com.example.fornecedores.entities.RegistroEmpresa;

public record RegistroEmpresaResponseDTO(Empresa empresa, Fornecedor fornecedor ) {
    public RegistroEmpresaResponseDTO(RegistroEmpresa registroEmpresa){
        this(registroEmpresa.getEmpresa(), registroEmpresa.getFornecedor());

    }
}
