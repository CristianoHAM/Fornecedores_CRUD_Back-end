package com.example.fornecedores.service;

import com.example.fornecedores.dto.EmpresaDTO;
import com.example.fornecedores.dto.EmpresaRequestDTO;
import com.example.fornecedores.dto.EmpresaResponseDTO;
import com.example.fornecedores.entities.Empresa;
import com.example.fornecedores.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public List<EmpresaResponseDTO> findAll(){
        List<Empresa> list = empresaRepository.findAll();
        return  list.stream().map( x -> new EmpresaResponseDTO(x)).collect(Collectors.toList());
    }
}
