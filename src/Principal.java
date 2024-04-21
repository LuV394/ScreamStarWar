import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner captura = new Scanner(System.in);
        BuscadorAPI buscador = new BuscadorAPI();
        System.out.println("Escriba el numero del episodio de Star Wars: ");

        try {
            var numeroDePelicula = Integer.valueOf(captura.nextLine());
            Pelicula pelicula = buscador.buscaEpisodio(numeroDePelicula);
            System.out.println(pelicula);
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(pelicula);
        }catch (NumberFormatException e){
        System.out.println("Numero no encontrado");
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finaliza la aplicacion");
        }
    }
}
