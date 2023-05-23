package com.example.fornecedores.entities;

import com.example.fornecedores.dto.EmpresaInsertDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cnpj", unique = true, nullable = false)
    private String cnpj;

    @Column(name = "nome_fantasia", nullable = false)
    private String nomeFantasia;

    @Column(name = "cep", nullable = false)
    private String cep;

    @ManyToMany
    @JoinTable(name = "empresa_fornecedor",
            joinColumns = @JoinColumn(name = "id_empresa"),
            inverseJoinColumns = @JoinColumn(name = "id_fornecedor"))
     Set<Fornecedor> fornecedores = new HashSet<>();

}
/**
public class Empresa  {

    @Id
    private String cnpj;
    @Column
    private String nomeFantasia;
    @Column
    private String cep;
    @ManyToMany
    @JoinTable(name = "empresa_fornecedor",
        joinColumns = @JoinColumn(name = "empresa_fk"),
        inverseJoinColumns= @JoinColumn( name = "fornecedor_fk"))
    Set<Fornecedor> fornecedores = new HashSet<>();

}

**/