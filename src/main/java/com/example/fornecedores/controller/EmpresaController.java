package com.example.fornecedores.controller;

import com.example.fornecedores.entities.Empresa;
import com.example.fornecedores.repositories.EmpresaRepository;
import com.example.fornecedores.dto.EmpresaRequestDTO;
import com.example.fornecedores.dto.EmpresaResponseDTO;
import com.example.fornecedores.service.EmpresaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("empresa")
@CrossOrigin()
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    //@PostMapping
    //public void saveMotorcycle(@RequestBody EmpresaRequestDTO data) {
    //    Empresa empresa = new Empresa(data);
    //    repository.save(empresa);
    //}

    @GetMapping
    public ResponseEntity<List<EmpresaResponseDTO>> findAll() {
        List<EmpresaResponseDTO> empresas = empresaService.findAll();
        return ResponseEntity.ok(empresas);
    }
}
