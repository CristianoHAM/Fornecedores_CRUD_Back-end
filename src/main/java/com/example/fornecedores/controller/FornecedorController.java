package com.example.fornecedores.controller;

import com.example.fornecedores.dto.FornecedorDTO;
import com.example.fornecedores.dto.FornecedorInsertDTO;
import com.example.fornecedores.dto.FornecedorResponseDTO;
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
    @GetMapping(value = "/search-nome")
    public ResponseEntity<Page<FornecedorResponseDTO>> searchByNome(
            @RequestParam(defaultValue = "") String nome,
            Pageable pageable) {
        Page<FornecedorResponseDTO> fornecedores = service.searchByNome(nome, pageable);
        return ResponseEntity.ok(fornecedores);
    }
    @GetMapping(value = "/search-cnpjcpf")
    public ResponseEntity<Page<FornecedorResponseDTO>> searchByCnpjcpf(
            @RequestParam(defaultValue = "") String cnpjcpf,
            Pageable pageable) {
        Page<FornecedorResponseDTO> fornecedores = service.searchByCnpjcpf(cnpjcpf, pageable);
        return ResponseEntity.ok(fornecedores);
    }


    @PostMapping
    public ResponseEntity<FornecedorDTO> insert(@RequestBody FornecedorInsertDTO data){
      try{
         FornecedorDTO fornecedor = service.insert(data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(data.getCnpjcpf()).toUri();
        return ResponseEntity.created(uri).body(fornecedor);
      }catch (SecurityException e){
          return ResponseEntity.unprocessableEntity().build();
      }
    }
}
