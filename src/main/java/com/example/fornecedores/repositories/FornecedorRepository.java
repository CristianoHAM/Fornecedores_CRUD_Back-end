package com.example.fornecedores.repositories;

import com.example.fornecedores.entities.Fornecedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FornecedorRepository extends JpaRepository<Fornecedor, String> {

    Fornecedor findByCnpjcpf(String cnpjcpf);
    Page<Fornecedor> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
    Page<Fornecedor> findByCnpjcpfContainingIgnoreCase(String cnpjcpf, Pageable pageable);
}
