package com.example.fornecedores.entities;

import com.example.fornecedores.dto.FornecedorInsertDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
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
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "empresa_fornecedor",
//            joinColumns = @JoinColumn(name = "fornecedor_fk"),
//            inverseJoinColumns= @JoinColumn( name = "empresa_fk"))
//    private List<Empresa> empresas;
//    @OneToMany(mappedBy = "fornecedor")
    @ManyToMany(mappedBy = "fornecedores")
    private Set<Empresa> empresas = new HashSet<>();

    public Fornecedor(FornecedorInsertDTO data) {
        this.cnpjcpf = data.cpfCnpj();
        this.nome = data.nome();
        this.email = data.email();
        this.cep = data.cep();
    }


}
