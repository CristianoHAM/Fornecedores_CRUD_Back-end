package com.example.fornecedores.service;

import com.example.fornecedores.dto.FornecedorDTO;
import com.example.fornecedores.dto.FornecedorInsertDTO;
import com.example.fornecedores.dto.FornecedorResponseDTO;
import com.example.fornecedores.entities.Fornecedor;
import com.example.fornecedores.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    @Transactional(readOnly = true)
    public List<FornecedorResponseDTO> findAll(){
        List<Fornecedor> fornecedores = repository.findAll();
        //fornecedores.
        return fornecedores.stream().map( x -> new FornecedorResponseDTO(x)).collect(Collectors.toList());
    }

    public FornecedorDTO insert(FornecedorInsertDTO data){
        Fornecedor fornecedor = new Fornecedor();
        fornecedor = repository.save(fornecedor);
        return new FornecedorDTO(fornecedor);

    }

}
