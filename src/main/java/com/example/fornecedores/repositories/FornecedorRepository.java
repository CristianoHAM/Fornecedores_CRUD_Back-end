package com.example.fornecedores.repositories;

import com.example.fornecedores.entities.Fornecedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    @Query(value = "select * from fornecedor", nativeQuery = true)
    Page<Fornecedor> findFull(Pageable pageable);
    Page<Fornecedor> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

}
