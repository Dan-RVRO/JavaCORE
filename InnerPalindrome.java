import java.util.ArrayList;

public class InnerPalindrome {


    // método para encontrar el palíndromo interno más largo
    private static int expandirDesdeCentro(String texto, int izquierda, int derecha) {
        while (izquierda >= 0 && 
            derecha < texto.length() && 
            texto.charAt(izquierda) == texto.charAt(derecha)) {
            izquierda--;
            derecha++;
        }
    return derecha - izquierda - 1; // Longitud del palíndromo
    }

    public static String palindromoMasLargo(String texto) {
    if (texto == null || texto.length() == 0) return "";

    int inicio = 0;
    int fin = 0;

    for (int i = 0; i < texto.length(); i++) {
        int len1 = expandirDesdeCentro(texto, i, i);     // centro impar
        int len2 = expandirDesdeCentro(texto, i, i + 1); // centro par
        int len = Math.max(len1, len2);

        if (len > (fin - inicio)) {
            inicio = i - (len - 1) / 2;
            fin = i + len / 2;
        }
    }

    return texto.substring(inicio, fin + 1);
    }

    // método para probar la función
    public static void main(String[] args) {
        String[] pruebas = {
            "babad",
            "cbbd",
            "a",
            "ac",
            "",
            "racecar",
            "noon",
            "forgeeksskeegfor",
            "abccba",
            "abcdxyzzyxcba"
        };

        System.out.println("Palíndromos más largos encontrados:");
        for (String prueba : pruebas) {
            String resultado = palindromoMasLargo(prueba);
            System.out.println("Entrada: \"" + prueba + "\" -> Salida: \"" + resultado + "\"");
        }
    }
}
