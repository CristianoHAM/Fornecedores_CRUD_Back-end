package com.example.fornecedores.repositories;

import com.example.fornecedores.entities.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa, String> {

    @Query("SELECT obj FROM Empresa obj JOIN FETCH obj.fornecedores WHERE obj IN :empresas")
    List<Empresa> findEmpresaFornecedor(List<Empresa> empresas);

}
