package com.example.fornecedores.dto;

import com.example.fornecedores.entities.Empresa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaResponseDTO {
    private Long id;
    private String cnpj;
    private String nomeFantasia;
    private String cep;

    public EmpresaResponseDTO(Empresa empresa){
        id = empresa.getId();
        cnpj = empresa.getCnpj();
        nomeFantasia = empresa.getNomeFantasia();
        cep = empresa.getCep();
    }
}
