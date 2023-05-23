package com.example.fornecedores.service;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class CepService {
    public void getCep(){
        HttpClient httpClient = HttpClientBuilder.create().build();
        String cep = "12345678"; // CEP a ser validado

        String apiUrl = "http://cep.la/api/" + cep;

        HttpGet request = new HttpGet(apiUrl);

        try {
            HttpResponse response = httpClient.execute(request);

            // Verificar o status da resposta
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // Extrair o conteúdo da resposta
                String responseBody = EntityUtils.toString(response.getEntity());

                // Processar a resposta
                // Exemplo: verificar se o CEP é válido
                if (responseBody.contains("cep_consulta")) {
                    System.out.println("CEP válido");
                } else {
                    System.out.println("CEP inválido");
                }
            } else {
                System.out.println("Erro ao fazer a requisição: " + statusCode);
            }
        } catch (IOException e) {
            System.out.println("Exceção durante a requisição: " + e.getMessage());
        }
    }

}
