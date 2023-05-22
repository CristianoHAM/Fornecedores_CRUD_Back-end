package com.example.fornecedores.repositories;

import com.example.fornecedores.entities.Fornecedor;
import com.example.fornecedores.entities.RegistroEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroEmpresaRepository extends JpaRepository<RegistroEmpresa, String> {
}
