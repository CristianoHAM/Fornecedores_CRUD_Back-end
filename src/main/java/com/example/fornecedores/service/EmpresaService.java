package com.example.fornecedores.service;

import com.example.fornecedores.dto.*;
import com.example.fornecedores.entities.Empresa;
import com.example.fornecedores.repositories.EmpresaRepository;
import com.example.fornecedores.service.excepiton.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository repository;



    @Transactional(readOnly = true)
    public Page<EmpresaResponseDTO> findAll(Pageable pageable) {
        Page<Empresa> list = repository.findAll(pageable);
        return list.map(EmpresaResponseDTO::new);
    }
    @Transactional(readOnly = true)
    public Page<EmpresaResponseDTO> findByCnpj(Pageable pageable, String cnpj) {
        Page<Empresa> list = repository.findByCnpjContainingIgnoreCase(cnpj, pageable);
        return list.map(EmpresaResponseDTO::new);
    }
    @Transactional(readOnly = true)
    public Page<EmpresaDTO> findJoinAll(Pageable pageable) {
        Page<Empresa> page = repository.findAll(pageable);
        repository.findEmpresaFornecedor(page.stream().collect(Collectors.toList()));
        return page.map(EmpresaDTO::new);
    }



    public EmpresaDTO insert(EmpresaInsertDTO data) {
        Empresa validation = repository.findByCnpj(data.getCnpj());
        if (validation != null) {
            throw new ServiceException("Empresa já cadastrada");
        }
        Empresa empresa = new Empresa();
        empresa.setCnpj(data.getCnpj());
        empresa.setNomeFantasia(data.getNomeFantasia());
        empresa.setCep(data.getCep());
        empresa = repository.save(empresa);
        return new EmpresaDTO(empresa);
    }


    public EmpresaDTO update(Long id, EmpresaInsertDTO empresaAtualizada) {
        Optional<Empresa> empresaExistente = repository.findById(id);
        if (!empresaExistente.isPresent()) {
            throw new ServiceException("Empresa não encontrada.");
        }
        Empresa empresa = empresaExistente.get();
        empresa.setNomeFantasia(empresaAtualizada.getNomeFantasia());
        empresa.setCnpj(empresaAtualizada.getCnpj());
        empresa.setCep(empresaAtualizada.getCep());
        repository.save(empresa);
        return new EmpresaDTO(empresa);

    }


    public boolean delete(Long id) {
        Optional<Empresa> empresaExistente = repository.findById(id);
        if (empresaExistente.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
