package com.example.fornecedores.controller;

import com.example.fornecedores.dto.FornecedorDTO;
import com.example.fornecedores.dto.FornecedorInsertDTO;
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
    private FornecedorService service;


    @GetMapping
    public List<FornecedorResponseDTO> getAll() {
        List<FornecedorResponseDTO> fornecedores = service.findAll();
        return fornecedores;
    }

    @PostMapping
    public  void insert(@RequestBody FornecedorInsertDTO data){
        FornecedorDTO fornecedor = service.insert(data);
    }
}
