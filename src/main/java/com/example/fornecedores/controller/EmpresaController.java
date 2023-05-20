package com.example.fornecedores.controller;

import com.example.fornecedores.empresa.Empresa;
import com.example.fornecedores.empresa.EmpresaRepository;
import com.example.fornecedores.empresa.EmpresaRequestDTO;
import com.example.fornecedores.empresa.EmpresaResponseDTO;
import com.example.fornecedores.fornecedor.Fornecedor;
import com.example.fornecedores.fornecedor.FornecedorRepository;
import com.example.fornecedores.fornecedor.FornecedorRequestDTO;
import com.example.fornecedores.fornecedor.FornecedorResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("empresa")
@CrossOrigin()
public class EmpresaController {
    @Autowired
    private EmpresaRepository repository;

    @PostMapping
    public void saveMotorcycle(@RequestBody EmpresaRequestDTO data) {
        Motorcycle empresa = new Empresa(data);
        repository.save(empresa);
    }

    @GetMapping
    public List<EmpresaResponseDTO> getAll() {
        List<EmpresaResponseDTO> empresa = repository.findAll().stream().map(EmpresaResponseDTO::new).toList();
        return empresa;
    }
}
