package com.example.fornecedores.entities;

import com.example.fornecedores.dto.FornecedorInsertDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Table(name = "fornecedor")
@Entity(name = "fornecedor")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Fornecedor  {
    @Id
    private String cnpjcpf;
    @Column
    private String nome;
    @Column
    private String email;
    @Column
    private String cep;
    @ManyToMany(mappedBy = "fornecedores")
    private Set<Empresa> empresas = new HashSet<>();

    public Fornecedor(FornecedorInsertDTO data) {
        this.cnpjcpf = data.getCnpjcpf();
        this.nome = data.getNome();
        this.email = data.getEmail();
        this.cep = data.getCep();
    }
    public String getCpfCnpj() {
        return this.cnpjcpf;
    }


}
