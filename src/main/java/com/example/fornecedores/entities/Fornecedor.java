package com.example.fornecedores.entities;

import com.example.fornecedores.dto.FornecedorRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Table(name = "fornecedor")
@Entity(name = "fornecedor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Fornecedor implements Serializable {
    @Id
    private String cnpjcpf;
    @Column
    private String nome;
    @Column
    private String email;
    @Column
    private String cep;
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "empresa_fornecedor",
//            joinColumns = @JoinColumn(name = "fornecedor_fk"),
//            inverseJoinColumns= @JoinColumn( name = "empresa_fk"))
//    private List<Empresa> empresas;
    @OneToMany(mappedBy = "fornecedor")
    private Set<RegistroEmpresa> registros;

    public Fornecedor(FornecedorRequestDTO data) {
        this.cnpjcpf = data.cpfCnpj();
        this.nome = data.nome();
        this.email = data.email();
        this.cep = data.cep();

    }
    public Set<RegistroEmpresa> getRegistros() {
        return registros;
    }

}
