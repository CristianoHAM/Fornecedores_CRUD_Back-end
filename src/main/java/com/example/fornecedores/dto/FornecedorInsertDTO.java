package com.example.fornecedores.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorInsertDTO {
    private String nome;
    private String email;
    private String cep;
    private String tipo;
    private String cnpj;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;

}
