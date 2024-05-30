package com.example.TASK4;

import java.io.IOException;

/**
 * Create an implementation of a Rest API client.
 * Prints out how many records exists for each gender and save this file to s3 bucket
 * API endpoint=> https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda 
 * AWS s3 bucket => interview-digiage
 *
 */
public class TASK4 {
    public static void main(String[] args) {
        HttpClient httpClient = new HttpClient();

        try {
            httpClient.obterDados("https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda");
            httpClient.getDataHM();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}