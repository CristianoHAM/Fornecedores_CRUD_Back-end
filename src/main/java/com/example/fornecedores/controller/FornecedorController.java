package com.example.fornecedores.controller;

import com.example.fornecedores.dto.*;
import com.example.fornecedores.entities.Fornecedor;
import com.example.fornecedores.entities.FornecedorPJ;
import com.example.fornecedores.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("fornecedor")
@CrossOrigin()
public class FornecedorController {
    @Autowired
    private FornecedorService service;

    @GetMapping
    public ResponseEntity<Page<FornecedorResponseDTO>> findAll(Pageable pageable){
        Page<FornecedorResponseDTO> fornecedores = service.findAll(pageable);
        return ResponseEntity.ok(fornecedores);
    }
    @GetMapping(value = "/nome")
    public ResponseEntity<Page<FornecedorResponseDTO>> searchByNome(
            @RequestParam(defaultValue = "") String nome,
            Pageable pageable) {
        Page<FornecedorResponseDTO> fornecedores = service.searchByNome(nome, pageable);
        return ResponseEntity.ok(fornecedores);
    }
    @GetMapping(value = "/cnpj")
    public ResponseEntity<Page<FornecedorPJResponseDTO>> searchByCnpj(
            @RequestParam(defaultValue = "") String cnpj,
            Pageable pageable) {
        Page<FornecedorPJResponseDTO> fornecedores = service.searchByCnpj(cnpj, pageable);
        return ResponseEntity.ok(fornecedores);
    }
    @GetMapping(value = "/cpf")
    public ResponseEntity<Page<FornecedorPFResponseDTO>> searchByCpf(
            @RequestParam(defaultValue = "") String cpf,
            Pageable pageable) {
        Page<FornecedorPFResponseDTO> fornecedores = service.searchByCpf(cpf, pageable);
        return ResponseEntity.ok(fornecedores);
    }


    @PostMapping(value = "/pj")
    public ResponseEntity<FornecedorPJDTO> insertPj(@RequestBody FornecedorPJInsertDTO data){
      try{
          FornecedorPJDTO fornecedor = service.insertPj(data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(data.getCnpj()).toUri();
        return ResponseEntity.created(uri).body(fornecedor);
      }catch (SecurityException e){
          return ResponseEntity.unprocessableEntity().build();
      }
    }

    @PostMapping(value = "/pf")
    public ResponseEntity<FornecedorPFDTO> insertPf(@RequestBody FornecedorPFInsertDTO data){
        try{
            FornecedorPFDTO fornecedor = service.insertPf(data);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(data.getCpf()).toUri();
            return ResponseEntity.created(uri).body(fornecedor);
        }catch (SecurityException e){
            return ResponseEntity.unprocessableEntity().build();
        }
    }

}
