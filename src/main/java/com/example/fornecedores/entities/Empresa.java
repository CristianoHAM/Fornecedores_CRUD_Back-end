package com.example.fornecedores.entities;

import com.example.fornecedores.dto.EmpresaInsertDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "empresa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empresa  {

    @Id
    private String cnpj;
    @Column
    private String nomefantasia;
    @Column
    private String cep;
//   @OneToMany(mappedBy = "empresa")
//   @ManyToMany(mappedBy = "empresas", cascade = CascadeType.ALL)
    @ManyToMany
    @JoinTable(name = "empresa_fornecedor",
        joinColumns = @JoinColumn(name = "empresa_fk"),
        inverseJoinColumns= @JoinColumn( name = "fornecedor_fk"))
    Set<Fornecedor> fornecedores = new HashSet<>();




}
