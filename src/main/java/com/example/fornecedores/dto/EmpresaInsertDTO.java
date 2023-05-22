package com.example.fornecedores.dto;

import com.example.fornecedores.entities.Empresa;


public class EmpresaInsertDTO {
    private String cnpj;
    private String nomeFantasia;
    private String cep;

    public EmpresaInsertDTO() {
    }

    public EmpresaInsertDTO(String cnpj, String nomeFantasia, String cep){
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.cep = cep;

    }
    public EmpresaInsertDTO(Empresa empresa){
        cnpj = empresa.getCnpj();
        nomeFantasia = empresa.getNomeFantasia();
        cep = empresa.getCep();
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getCep() {
        return cep;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
