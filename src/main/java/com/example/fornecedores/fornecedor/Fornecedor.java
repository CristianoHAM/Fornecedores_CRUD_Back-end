package com.example.fornecedores.fornecedor;

import com.example.fornecedores.empresa.EmpresaRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "fornecedor")
@Entity(name = "fornecedor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Fornecedor {
    @Id
    private String cpfCnpj;
    private String nome;
    private String email;
    private String cep;

    public Fornecedor(FornecedorRequestDTO data) {
        this.cpfCnpj = data.cpfCnpj();
        this.nome = data.nome();
        this.email = data.email();
        this.cep = data.cep();
    }
}
