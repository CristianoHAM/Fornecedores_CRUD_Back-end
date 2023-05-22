package com.example.fornecedores.dto;

import com.example.fornecedores.entities.Fornecedor;

public record FornecedorResponseDTO(String cnpjcpf, String nome, String email, String cep) {
    public FornecedorResponseDTO(Fornecedor fornecedor){
        this(fornecedor.getCnpjcpf(), fornecedor.getNome(), fornecedor.getEmail(), fornecedor.getCep());
    }
}
