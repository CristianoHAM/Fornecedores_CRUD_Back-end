package com.example.fornecedores.service;

import com.example.fornecedores.dto.EmpresaDTO;
import com.example.fornecedores.dto.EmpresaInsertDTO;
import com.example.fornecedores.dto.EmpresaResponseDTO;
import com.example.fornecedores.entities.Empresa;
import com.example.fornecedores.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository repository;

   // @Transactional(readOnly = true)
   // public List<EmpresaResponseDTO> findAll(){
    //    List<Empresa> list = repository.findAll();
    //    return  list.stream().map( x -> new EmpresaResponseDTO(x)).collect(Collectors.toList());
    //}

    @Transactional(readOnly = true)
    public Page<EmpresaDTO> findAll(PageRequest pageRequest){
        Page<Empresa> page = repository.findAll(pageRequest);
        repository.findEmpresaFornecedor(page.stream().collect(Collectors.toList()));
        return page.map(x -> new EmpresaDTO(x));
    }

    public EmpresaDTO insert(EmpresaInsertDTO data) {
        Empresa empresa = new Empresa();
        empresa =  repository.save(empresa);
        return new EmpresaDTO(empresa);
    }
}
