package com.example.TASK4;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Objects;


public class HttpClient extends ConverteDados {
    private String data;
    private Pessoa[] pessoas;

    public void obterDados(String endereco) throws IOException {
        HttpGet httpGet = new HttpGet(endereco);
        try (CloseableHttpClient httpClient = HttpClients.createDefault(); CloseableHttpResponse response = httpClient.execute(httpGet)) {
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(final HttpResponse httpResponse) throws IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }
            };
            this.data = httpClient.execute(httpGet, responseHandler);
            converteParaPessoa();
        }
    }

    private void converteParaPessoa() {
        pessoas = converte(this.data, Pessoa[].class);
    }

    public void getDataHM() {
        int HMM = 0;

        for (Pessoa pessoa : pessoas) {
            if (Objects.equals(pessoa.getGenero(), "M")) {
                HMM++;
            }
        }
        System.out.println("Homens:     " + HMM);
        System.out.println("Mulheres:   " + (pessoas.length - HMM));
    }


}
