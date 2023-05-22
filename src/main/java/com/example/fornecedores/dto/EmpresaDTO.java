package com.example.fornecedores.dto;

import com.example.fornecedores.entities.Empresa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmpresaDTO {
    private String cnpj;
    private String nomeFantasia;
    private String cep;
    private List<FornecedorDTO> fornecedores = new ArrayList<>();

    public EmpresaDTO() {
    }

    public EmpresaDTO(String cnpj, String nomeFantasia, String cep, List<FornecedorDTO> fornecedores){
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.cep = cep;
        this.fornecedores = fornecedores;
    }
    public EmpresaDTO(Empresa empresa){
        cnpj = empresa.getCnpj();
        nomeFantasia = empresa.getNomefantasia();
        cep = empresa.getCep();
        fornecedores = empresa.getFornecedores().stream().map(x -> new  FornecedorDTO(x)).collect(Collectors.toList());
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

    public List<FornecedorDTO> getFornecedores() {
        return fornecedores;
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

    public void setFornecedores(List<FornecedorDTO> fornecedores) {
        this.fornecedores = fornecedores;
    }
}
