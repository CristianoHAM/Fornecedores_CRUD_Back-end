package com.example.fornecedores.entities;

import com.example.fornecedores.dto.RegistroEmpresaResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "empresa_fornecedor")
@Entity(name = "empresa_fornecedor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegistroEmpresa {
    @EmbeddedId
    RegistroEmpresaKey regitroEmpresaKey;

    @ManyToOne
    @MapsId("empresa_fk")
    @JoinColumn(name = "empresa_fk")
    Empresa empresa;

    @ManyToOne
    @MapsId("fornecedor_fk")
    @JoinColumn(name = "fornecedor_fk")
    Fornecedor fornecedor;

    public RegistroEmpresa(RegistroEmpresaResponseDTO data){
        this.empresa = data.empresa();
        this.fornecedor = data.fornecedor();
    }

}

