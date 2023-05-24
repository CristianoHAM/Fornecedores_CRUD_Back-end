package com.example.fornecedores.dto;

import com.example.fornecedores.entities.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorDTO {
    private Long id;
    private String nome;
    private String email;
    private String cep;
    private String tipo;
    private String cnpj;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;

    public FornecedorDTO(Fornecedor fornecedor) {
        id = fornecedor.getId();
        nome = fornecedor.getNome();
        email = fornecedor.getEmail();
        cep = fornecedor.getCep();
        tipo = fornecedor.getTipo();
        cnpj = fornecedor.getCnpj();
        cpf = fornecedor.getCpf();
        rg = fornecedor.getRg();
        dataNascimento = fornecedor.getDataNascimento();
    }
}
