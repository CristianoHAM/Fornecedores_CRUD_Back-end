package com.example.fornecedores.empresa;

public record EmpresaResponseDTO(String cnpj, String nomeFantasia, String cep) {
    public EmpresaResponseDTO(Empresa empresa){
        this(empresa.getCnpj(), empresa.getNomeFantasia(), empresa.getCep());



    }
}
