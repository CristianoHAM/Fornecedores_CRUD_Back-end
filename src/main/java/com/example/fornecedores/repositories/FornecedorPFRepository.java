package com.example.fornecedores.repositories;

import com.example.fornecedores.entities.FornecedorPF;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorPFRepository extends JpaRepository<FornecedorPF, Long> {

    FornecedorPF findByCpf(String cpf);
    Page<FornecedorPF> findByCpfContainingIgnoreCase(String cpf, Pageable pageable);

}
