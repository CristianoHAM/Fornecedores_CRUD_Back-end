package com.example.fornecedores.service;

import com.example.fornecedores.dto.*;
import com.example.fornecedores.entities.Fornecedor;
import com.example.fornecedores.entities.FornecedorPF;
import com.example.fornecedores.entities.FornecedorPJ;
import com.example.fornecedores.repositories.FornecedorPFRepository;
import com.example.fornecedores.repositories.FornecedorPJRepository;
import com.example.fornecedores.repositories.FornecedorRepository;
import com.example.fornecedores.service.excepiton.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;
    @Autowired
    private FornecedorPFRepository repositoryPF;
    @Autowired
    private FornecedorPJRepository repositoryPJ;

    @Transactional(readOnly = true)
    public Page<FornecedorResponseDTO> findAll(Pageable pageable){
        Page<Fornecedor> fornecedores = repository.findFull(pageable);
        return fornecedores.map(FornecedorResponseDTO::new);
    }
    @Transactional(readOnly = true)
    public Page<FornecedorResponseDTO> searchByNome(String name, Pageable pageable){
        Page<Fornecedor> fornecedores = repository.findByNomeContainingIgnoreCase(name, pageable);
        return fornecedores.map(FornecedorResponseDTO::new);
    }
    @Transactional(readOnly = true)
    public Page<FornecedorPJResponseDTO> searchByCnpj(String cnpj, Pageable pageable){
        Page<FornecedorPJ> fornecedores = repositoryPJ.findByCnpjContainingIgnoreCase( cnpj, pageable);
        return fornecedores.map(FornecedorPJResponseDTO::new);
    }
    @Transactional(readOnly = true)
    public Page<FornecedorPFResponseDTO> searchByCpf(String cpf, Pageable pageable) {
        Page<FornecedorPF> fornecedores = repositoryPF.findByCpfContainingIgnoreCase( cpf, pageable);
        return fornecedores.map(FornecedorPFResponseDTO::new);
    }
    public FornecedorPJDTO insertPj(FornecedorPJInsertDTO data) {
        FornecedorPJ ValidationCnpj = repositoryPJ.findByCnpj(data.getCnpj());
        if (ValidationCnpj != null) {
            throw new ServiceException("Fornecedor já cadastrado");
        }
        FornecedorPJ fornecedor =  new FornecedorPJ();
        fornecedor.setNome(data.getNome());
        fornecedor.setCep(data.getCep());
        fornecedor.setEmail(data.getEmail());
        fornecedor.setTipo("J");
        fornecedor.setCnpj(data.getCnpj());
        fornecedor = repositoryPJ.save(fornecedor);
        return new FornecedorPJDTO(fornecedor);
    }

    public FornecedorPFDTO insertPf(FornecedorPFInsertDTO data) {
        Fornecedor ValidationCpf = repositoryPF.findByCpf(data.getCpf());
        if (ValidationCpf != null) {
            throw new ServiceException("Fornecedor já cadastrado");
        }
        FornecedorPF fornecedorPF = new FornecedorPF();
        fornecedorPF.setNome(data.getNome());
        fornecedorPF.setCep(data.getCep());
        fornecedorPF.setEmail(data.getEmail());
        fornecedorPF.setTipo("F");
        fornecedorPF.setCpf(data.getCpf());
        fornecedorPF.setRg(data.getRg());
        fornecedorPF.setDataNascimento(data.getDataNascimento());
        fornecedorPF = repositoryPF.save(fornecedorPF);
        return new FornecedorPFDTO(fornecedorPF);
    }

}
