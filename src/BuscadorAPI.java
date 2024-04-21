import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscadorAPI {

    public Pelicula buscaEpisodio(int buscaEpisodio) {

        URI direccion = URI.create("https://swapi.dev/api/films/" + buscaEpisodio);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();


        try {
            HttpResponse<String> responce = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(responce.body(), Pelicula.class);
        } catch (Exception e) {
            throw new RuntimeException(" No encontre esa pelicula");
        }

    }
}
