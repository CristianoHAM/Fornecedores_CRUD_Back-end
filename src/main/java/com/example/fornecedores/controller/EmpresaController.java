package com.example.fornecedores.controller;

import com.example.fornecedores.dto.EmpresaDTO;
import com.example.fornecedores.dto.EmpresaInsertDTO;
import com.example.fornecedores.dto.EmpresaResponseDTO;
import com.example.fornecedores.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("empresa")
@CrossOrigin()
public class EmpresaController {
    @Autowired
    private EmpresaService service;

   // @GetMapping
   // public List<EmpresaResponseDTO> findAll() {
   //     List<EmpresaResponseDTO> empresas = service.findAll();
   //     return empresas;
    //}
    @GetMapping
    private Page<EmpresaDTO> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ){
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<EmpresaDTO> registros = service.findAll(pageRequest);
        return registros;
    }

    @PostMapping
    public void  insert(@RequestBody EmpresaInsertDTO data) {
        EmpresaDTO empresa = service.insert(data);
    }

}
