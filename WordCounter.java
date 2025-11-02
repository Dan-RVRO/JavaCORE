import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    /**
     * Cuenta cuántas veces aparece cada palabra en un texto.
     * @param texto Cadena de entrada
     * @return Mapa con las palabras y su conteo
     */

    public static Map<String, Integer> contarPalabras(String texto) {

        // Dividir el texto en palabras usando espacio como delimitador
        String[] slicedWords = texto.split(" ");

        // Crear un mapa para almacenar el conteo de palabras
        Map<String, Integer> wordCounter = new HashMap<>();

        // Recorrer cada palabra y actualizar su conteo en el mapa
        for (String palabra : slicedWords){
            wordCounter.put(palabra, wordCounter.getOrDefault(palabra, 0) + 1);
        }
  
        return wordCounter;
    }

    // Método para probar la función
    public static void main(String[] args) {
        String entrada = "Hola mundo hola Java mundo Java Java";
        Map<String, Integer> resultado = contarPalabras(entrada);
        System.out.println("Conteo de palabras: " + resultado);
    }  
}
