package com.example.fornecedores.dto;

import com.example.fornecedores.entities.RegistroEmpresa;

import java.util.Set;

public record EmpresaRequestDTO(String cnpj, String nomeFantasia, String cep, Set<RegistroEmpresa> registros) {
}
