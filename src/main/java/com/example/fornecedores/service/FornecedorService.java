package com.example.fornecedores.service;

import com.example.fornecedores.dto.FornecedorResponseDTO;
import com.example.fornecedores.entities.Fornecedor;
import com.example.fornecedores.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public List<FornecedorResponseDTO> findAll(){
        List<Fornecedor> fornecedores = repository.findAll();
        return fornecedores.stream().map( x -> new FornecedorResponseDTO(x)).collect(Collectors.toList());
    }

}
