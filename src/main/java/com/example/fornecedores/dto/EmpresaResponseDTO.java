package com.example.fornecedores.dto;

import com.example.fornecedores.entities.Empresa;
import com.example.fornecedores.entities.RegistroEmpresa;

import java.util.Set;

public record EmpresaResponseDTO(String cnpj, String nomeFantasia, String cep, Set<RegistroEmpresa> registros) {
    public EmpresaResponseDTO(Empresa empresa){
        this(empresa.getCnpj(), empresa.getNomefantasia(), empresa.getCep(), empresa.getRegistros());



    }

}
