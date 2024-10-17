package com.challengealura.conexiones;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionApi {
    String apiKey;
    String direccion;

    public ConexionApi() {
        this.apiKey = "b2a8f68fdcdb8b9ec9d24bac";
        this.direccion = "https://v6.exchangerate-api.com/v6/" + this.apiKey + "/latest/";
    }

    public void doGet(String codigoMoneda) throws IOException, InterruptedException {
        String direccionAux = this.direccion + codigoMoneda;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccionAux))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        //CONTINUAR DESDE ACÁ.
        //VER COMO ALMACENAR LOS DATOS RELEVANTES EN LA APLICACIÓN.
        System.out.println(response.body());
    }
}
