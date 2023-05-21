package com.example.fornecedores.controller;

import com.example.fornecedores.dto.FornecedorRequestDTO;
import com.example.fornecedores.dto.FornecedorResponseDTO;
import com.example.fornecedores.dto.RegistroEmpresaResponseDTO;
import com.example.fornecedores.entities.Empresa;
import com.example.fornecedores.entities.Fornecedor;
import com.example.fornecedores.entities.RegistroEmpresa;
import com.example.fornecedores.repositories.EmpresaRepository;
import com.example.fornecedores.repositories.RegistroEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("registro")
@CrossOrigin()
public class RegistroEmpresaController {
    @Autowired
    private RegistroEmpresaRepository repository;
    @PostMapping
    public void saveMotorcycle(@RequestBody RegistroEmpresaResponseDTO data) {
        RegistroEmpresa registros = new RegistroEmpresa(data);
        repository.save(registros);
    }

    @GetMapping
    private List<RegistroEmpresaResponseDTO> getAll(){
        List<RegistroEmpresaResponseDTO> registros = repository.findAll().stream().map(RegistroEmpresaResponseDTO::new).toList();
        return registros;
    }
}
