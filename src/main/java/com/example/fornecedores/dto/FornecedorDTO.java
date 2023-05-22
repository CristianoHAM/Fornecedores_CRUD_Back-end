package com.example.fornecedores.dto;

import com.example.fornecedores.entities.Fornecedor;

public class FornecedorDTO {
    private String cpfCnpj;
    private String nome;
    private String email;
    private String cep;

    public FornecedorDTO() {
    }

    public FornecedorDTO(String cpfCnpj, String nome, String email, String cep) {
        this.cpfCnpj = cpfCnpj;
        this.nome = nome;
        this.email = email;
        this.cep = cep;
    }
    public FornecedorDTO(Fornecedor fornecedor){
         cpfCnpj = fornecedor.getCnpjcpf();
         nome = fornecedor.getNome();
         email = fornecedor.getEmail();
         cep = fornecedor.getCep();
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }


    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCep() {
        return cep;
    }
}
