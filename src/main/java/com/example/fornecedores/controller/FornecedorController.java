package com.example.fornecedores.controller;

import com.example.fornecedores.fornecedor.Fornecedor;
import com.example.fornecedores.fornecedor.FornecedorRepository;
import com.example.fornecedores.fornecedor.FornecedorRequestDTO;
import com.example.fornecedores.fornecedor.FornecedorResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("fornecedor")
@CrossOrigin()
public class FornecedorController {
    @Autowired
    private FornecedorRepository repository;

    @PostMapping
    public void saveMotorcycle(@RequestBody FornecedorRequestDTO data) {
        Motorcycle fornecedor = new Fornecedor(data);
        repository.save(fornecedor);
    }

    @GetMapping
    public List<FornecedorResponseDTO> getAll() {
        List<FornecedorResponseDTO> fornecedores = repository.findAll().stream().map(FornecedorResponseDTO::new).toList();
        return fornecedores;
    }
}
