package com.example.fornecedores.entities;

import com.example.fornecedores.dto.EmpresaRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Table(name = "empresa")
@Entity(name = "empresa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Empresa  implements Serializable {

    @Id
    private String cnpj;
    @Column
    private String nomefantasia;
    @Column
    private String cep;

//    @ManyToMany(mappedBy = "empresas", cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "empresa")
    private Set<RegistroEmpresa> registros;

    public Empresa(EmpresaRequestDTO data) {
        this.cnpj = data.cnpj();
        this.nomefantasia = data.nomeFantasia();
        this.cep = data.cep();
        this.registros = data.registros();
    }

    public Set<RegistroEmpresa> getRegistros() {
        return registros;
    }

}
