package com.challengealura.conexiones;

import com.challengealura.modelos.Moneda;
import com.challengealura.modelos.MonedaExchangeRate;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionApi {
    String apiKey;
    String direccion;
    Gson gson;

    public ConexionApi() {
        this.apiKey = "b2a8f68fdcdb8b9ec9d24bac";
        this.direccion = "https://v6.exchangerate-api.com/v6/" + this.apiKey + "/latest/";
        this.gson = new GsonBuilder().create();
    }

    public Moneda doGet(String codigoMoneda) throws IOException, InterruptedException {
        String direccionAux = this.direccion + codigoMoneda;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccionAux))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        MonedaExchangeRate monedaER = this.gson.fromJson(json, MonedaExchangeRate.class);
        return new Moneda(monedaER);
    }
}
