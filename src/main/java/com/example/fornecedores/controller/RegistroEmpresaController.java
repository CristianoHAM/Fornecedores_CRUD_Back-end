package com.example.fornecedores.controller;

import com.example.fornecedores.dto.EmpresaDTO;
import com.example.fornecedores.dto.RegistroEmpresaResponseDTO;
import com.example.fornecedores.entities.RegistroEmpresa;
import com.example.fornecedores.repositories.RegistroEmpresaRepository;
import com.example.fornecedores.service.RegistroEmpresasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("registro")
@CrossOrigin()
public class RegistroEmpresaController {
    @Autowired
    private RegistroEmpresasService service;

    @GetMapping
    private Page<EmpresaDTO> getAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ){
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<EmpresaDTO> registros = service.findAll(pageRequest);
        return registros;
    }

   // @PostMapping
   // public void saveMotorcycle(@RequestBody RegistroEmpresaResponseDTO data) {
   //     RegistroEmpresa registros = new RegistroEmpresa(data);
   //     repository.save(registros);
   // }
}
