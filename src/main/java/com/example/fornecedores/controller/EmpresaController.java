package com.example.fornecedores.controller;

import com.example.fornecedores.dto.*;
import com.example.fornecedores.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("empresa")
@CrossOrigin()
public class EmpresaController {
    @Autowired
    private EmpresaService service;

    @GetMapping
    public ResponseEntity<Page<EmpresaResponseDTO>> findAll(Pageable pageable){
        Page<EmpresaResponseDTO> empresas = service.findAll(pageable);
        return ResponseEntity.ok(empresas);
    }

    @PostMapping
    public ResponseEntity<EmpresaDTO> insert(@RequestBody EmpresaInsertDTO data){
        try{
            EmpresaDTO fornecedor = service.insert(data);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(data.getCnpj()).toUri();
            return ResponseEntity.created(uri).body(fornecedor);
        }catch (SecurityException e){
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}
