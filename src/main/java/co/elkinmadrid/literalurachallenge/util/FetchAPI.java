package co.elkinmadrid.literalurachallenge.util;

import co.elkinmadrid.literalurachallenge.model.ResponseApi;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FetchAPI {


    private final ObjectMapper mapper = new ObjectMapper();

    public ResponseApi requestAPI(String url) {
        System.out.println("URL : " + url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        ResponseApi responseAPI;
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            responseAPI = mapper.readValue(response.body(), ResponseApi.class);
            System.out.println("Respuesta de la API: " + responseAPI);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return responseAPI;
    }
}
