package com.example.fornecedores.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaInsertDTO {
    private String cnpj;
    private String nomeFantasia;
    private String cep;


}
