package com.example.fornecedores.service;

import com.example.fornecedores.dto.FornecedorDTO;
import com.example.fornecedores.dto.FornecedorInsertDTO;
import com.example.fornecedores.dto.FornecedorResponseDTO;
import com.example.fornecedores.entities.Fornecedor;
import com.example.fornecedores.repositories.FornecedorRepository;
import com.example.fornecedores.service.excepiton.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    @Transactional(readOnly = true)
    public Page<FornecedorResponseDTO> findAll(Pageable pageable){
        Page<Fornecedor> fornecedores = repository.findAll(pageable);
        return fornecedores.map(FornecedorResponseDTO::new);
    }
    @Transactional(readOnly = true)
    public Page<FornecedorResponseDTO> searchByNome(String name, Pageable pageable){
        Page<Fornecedor> fornecedores = repository.findByNomeContainingIgnoreCase(name, pageable);
        return fornecedores.map(FornecedorResponseDTO::new);
    }
    @Transactional(readOnly = true)
    public Page<FornecedorResponseDTO> searchByCnpjcpf(String cnpjcpf, Pageable pageable){
        Page<Fornecedor> fornecedores = repository.findByCnpjcpfContainingIgnoreCase( cnpjcpf, pageable);
        return fornecedores.map(FornecedorResponseDTO::new);
    }

    public FornecedorDTO insert(FornecedorInsertDTO data){
        Fornecedor fornecedorValidation = repository.findByCnpjcpf(data.getCnpjcpf());
        if( fornecedorValidation != null){
            throw  new ServiceException("Fornecedor já cadastrado");
        }
        Fornecedor fornecedor = new Fornecedor(data);
        fornecedor = repository.save(fornecedor);
        return new FornecedorDTO(fornecedor);
    }

}
