package com.example.fornecedores.controller;

import com.example.fornecedores.entities.Fornecedor;
import com.example.fornecedores.repositories.FornecedorRepository;
import com.example.fornecedores.dto.FornecedorRequestDTO;
import com.example.fornecedores.dto.FornecedorResponseDTO;
import com.example.fornecedores.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("fornecedor")
@CrossOrigin()
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    //@PostMapping
    //public void saveMotorcycle(@RequestBody FornecedorRequestDTO data) {
    //Fornecedor fornecedor = new Fornecedor(data);
     //   repository.save(fornecedor);
    //}

    @GetMapping
    public List<FornecedorResponseDTO> getAll() {
        List<FornecedorResponseDTO> fornecedores = fornecedorService.findAll();
        return fornecedores;
    }
}
