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
public class EmpresaDTO {
    private Long id;
    private String cnpj;
    private String nomeFantasia;
    private String cep;
    private List<FornecedorDTO> fornecedores = new ArrayList<>();

    public EmpresaDTO(Empresa empresa){
        id = empresa.getId();
        cnpj = empresa.getCnpj();
        nomeFantasia = empresa.getNomeFantasia();
        cep = empresa.getCep();
       // fornecedores = empresa.getFornecedores().stream().map(FornecedorDTO::new).collect(Collectors.toList());
    }

}
