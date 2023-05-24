package com.example.fornecedores.dto;

import com.example.fornecedores.entities.FornecedorPF;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorPFResponseDTO {
    private Long id;
    private String tipo;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private String nome;
    private String email;
    private String cep;

    public FornecedorPFResponseDTO(FornecedorPF fornecedor){
        id = fornecedor.getId();
        tipo = fornecedor.getTipo();
        cpf = fornecedor.getCpf();
        rg = fornecedor.getRg();
        dataNascimento = fornecedor.getDataNascimento();
        nome = fornecedor.getNome();
        email = fornecedor.getEmail();
        cep = fornecedor.getCep();
    }

}
