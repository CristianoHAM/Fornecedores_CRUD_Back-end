package com.example.fornecedores.service;

import com.example.fornecedores.dto.EmpresaDTO;
import com.example.fornecedores.dto.RegistroEmpresaResponseDTO;
import com.example.fornecedores.entities.Empresa;
import com.example.fornecedores.entities.RegistroEmpresa;
import com.example.fornecedores.repositories.EmpresaRepository;
import com.example.fornecedores.repositories.RegistroEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistroEmpresasService {

    @Autowired
    private EmpresaRepository repository;

    @Transactional(readOnly = true)
    public Page<EmpresaDTO> findAll(PageRequest pageRequest){
        Page<Empresa> page = repository.findAll(pageRequest);
        repository.findEmpresaFornecedor(page.stream().collect(Collectors.toList()));
        return page.map(x -> new EmpresaDTO(x));
    }
}
