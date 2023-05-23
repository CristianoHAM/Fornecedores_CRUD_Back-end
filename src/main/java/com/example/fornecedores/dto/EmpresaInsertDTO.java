package com.example.fornecedores.dto;

import com.example.fornecedores.entities.Empresa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaInsertDTO {
    private String cnpj;
    private String nomeFantasia;
    private String cep;

    public EmpresaInsertDTO(Empresa empresa){
        cnpj = empresa.getCnpj();
        nomeFantasia = empresa.getNomeFantasia();
        cep = empresa.getCep();
    }

}
