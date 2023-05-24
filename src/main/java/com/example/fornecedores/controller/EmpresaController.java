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
    public ResponseEntity<Page<EmpresaResponseDTO>> findAll(Pageable pageable) {
        Page<EmpresaResponseDTO> empresas = service.findAll(pageable);
        return ResponseEntity.ok(empresas);
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<Page<EmpresaResponseDTO>> findByCnpj(@PathVariable String cnpj, Pageable pageable) {
        try {
            Page<EmpresaResponseDTO> empresa = service.findByCnpj(pageable, cnpj);
            return ResponseEntity.ok(empresa);
        } catch (SecurityException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<EmpresaDTO> insert(@RequestBody EmpresaInsertDTO data) {
        try {
            EmpresaDTO fornecedor = service.insert(data);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(data.getCnpj()).toUri();
            return ResponseEntity.created(uri).body(fornecedor);
            //return ResponseEntity.status(HttpStatus.CREATED).body(fornecedor);
        } catch (SecurityException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaDTO> atualizar(@PathVariable Long id, @RequestBody EmpresaInsertDTO empresa) {
        try {
            EmpresaDTO empresaAtualizada = service.update(id, empresa);
            return ResponseEntity.ok(empresaAtualizada);
        } catch (SecurityException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.delete(id);
                return ResponseEntity.noContent().build();
        } catch (SecurityException e) {
          //  return ResponseEntity.unprocessableEntity().build();
            return ResponseEntity.notFound().build();
        }

    }

}




