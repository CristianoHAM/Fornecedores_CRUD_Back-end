package com.example.fornecedores.dto;

import com.example.fornecedores.entities.Fornecedor;
import com.example.fornecedores.entities.RegistroEmpresa;

import java.util.Set;

public record FornecedorResponseDTO(String cpfCnpj, String nome, String email, String cep, Set<RegistroEmpresa> registros) {
    public FornecedorResponseDTO(Fornecedor fornecedor){
        this(fornecedor.getCnpjcpf(), fornecedor.getNome(), fornecedor.getEmail(), fornecedor.getCep(), fornecedor.getRegistros());
    }
}
