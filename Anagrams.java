import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.ArrayList;

public class Anagrams {

    // ordena letras de palabras alfabéticamente
    public static String sortLetters(String word) {
        char[] letters = word.toCharArray();
        java.util.Arrays.sort(letters);
        return new String(letters);
    }

    public static List<List<String>> findAnagrams(String[] words) {
            if (words == null || words.length == 0) {
                return Collections.emptyList();
            }

            Map<String, List<String>> anagramMap = new HashMap<>();

            for (String word : words) {
                // llama al método sortLetters
                String sortedKeyWord = sortLetters(word.toLowerCase());

                // crea una lista vacia si no existe la clave sortedWord
                anagramMap.putIfAbsent(sortedKeyWord, new ArrayList<>());

                // agrega la palabra a la lista correspondiente
                anagramMap.get(sortedKeyWord).add(word);
            }

            // convierte mapas de valores a lista de listas
            List<List<String>> anagramGroups = new ArrayList<>(anagramMap.values());

        return anagramGroups;
    }

    // Método para probar la función
    public static void main(String[] args) {
        String[][] pruebas = {
        {"eat", "tea", "tan", "ate", "nat", "bat"},
        {"listen", "silent", "enlist", "google", "gooegl"},
        {"abc", "def", "ghi"},
        {"", " "},
        {"a"},
        {"a", "A"},
        {"Dormitory", "dirty room", "dirtyroom"},
        {"rat", "tar", "art", "tarr"}
    };

    System.out.println("Grupos de anagramas encontrados:");
        for (String[] prueba : pruebas) {
            List<List<String>> resultado = findAnagrams(prueba);
            System.out.println("Entrada: " + java.util.Arrays.toString(prueba));
            System.out.println("Salida: " + resultado);
        }
    }
}
