package com.example.fornecedores.repositories;

import com.example.fornecedores.entities.FornecedorPJ;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorPJRepository extends JpaRepository<FornecedorPJ, Long> {

    FornecedorPJ findByCnpj(String cnpj);
    Page<FornecedorPJ> findByCnpjContainingIgnoreCase(String cnpj, Pageable pageable);

}
