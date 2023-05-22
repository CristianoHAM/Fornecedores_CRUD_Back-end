package com.example.fornecedores.controller;

import com.example.fornecedores.dto.EmpresaDTO;
import com.example.fornecedores.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("empresa-fornecedor")
@CrossOrigin()
public class EmpresaFornecedorController {
    @Autowired
    private EmpresaService service;

    @GetMapping
    private ResponseEntity<Page<EmpresaDTO>> findJoinAll(Pageable pageable){
        Page<EmpresaDTO> registros = service.findJoinAll(pageable);
        return ResponseEntity.ok(registros);
    }

}
