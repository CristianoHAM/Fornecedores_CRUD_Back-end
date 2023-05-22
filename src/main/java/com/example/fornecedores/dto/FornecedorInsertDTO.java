package com.example.fornecedores.dto;

public class FornecedorInsertDTO {
    private String cnpjcpf;
    private String nome;
    private String email;
    private String cep;

    public FornecedorInsertDTO() {
    }

    public FornecedorInsertDTO(String cnpjcpf, String nome, String email, String cep) {
        this.cnpjcpf = cnpjcpf;
        this.nome = nome;
        this.email = email;
        this.cep = cep;
    }

    public String getCnpjcpf() {
        return cnpjcpf;
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

    public void setCnpjcpf(String cnpjcpf) {
        this.cnpjcpf = cnpjcpf;
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
}
