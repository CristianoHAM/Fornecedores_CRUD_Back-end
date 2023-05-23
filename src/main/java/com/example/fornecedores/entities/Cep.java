package com.example.fornecedores.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Cep {
    private String cep;
    private String uf;
    private String cidade;
    private String bairro;
    private String logradouro;
}
/**
Represente as seguintes entidades de um back-end CRUD usando java spring:

    Entidades bases:
        - Empresas{
            .CNPJ
            .Nome Fantasia
            .CEP
        }
        -Fornecedores{
            -FornecedoresPJ{
                .CNPJ
                .Nome
                .E-mail
                .CEP
            }
            -FornecedoresPJ{
                .CPF
                .RG
                .data_nascimento
                .Nome
                .E-mail
                .CEP
            }
        }

        Requisitos:
        Use conceitos de herança para qubrar fornecedores em pj e pf.
        Caso o fornecedor seja pessoa física, também é necessário cadastrar o RG e a data de nascimento.
        O CNPJ e CPF deve ser um valor único.
        Uma empresa pode ter mais de um fornecedor.
        Um fornecedor pode trabalhar para mais de uma empresa.
        Pode adicionar novas colunas, classes, heranças, entidades de relacionamentos e demais recursos que julgar necessário.

        Também crie o sql  da criação das tebelas para esse sitema usando uma banco postegresql

        CRUD de todas as entidades (Front-end e Back-end)
        Caso a empresa seja do Paraná, não permitir cadastrar um fornecedor pessoa física
        menor de idade
        A listagem de fornecedores deverá conter filtros por Nome e CPF/CNPJ
        Validar CEP na API http://cep.la/api
**/
//"cep":"30850080","uf":"MG","cidade":"Belo Horizonte","bairro":"Dom Bosco","logradouro":"Rua Boachá"