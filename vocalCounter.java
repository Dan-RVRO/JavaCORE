public class vocalCounter {

    /**
     * Cuenta cuántas vocales (mayúsculas o minúsculas) hay en un texto.
     * @param texto Cadena de entrada
     * @return Número total de vocales encontradas
     */
    public static int contadorVocales(String texto) {
        int contador = 0;

        // Convertir el texto a arreglo de caracteres
        char[] letras = texto.toCharArray();

        // Recorrer cada letra
        for (char c : letras) {
            if (c == 'a' || 
                c == 'e' || 
                c == 'i' || 
                c == 'o' || 
                c == 'u' ||
                c == 'A' || 
                c == 'E' || 
                c == 'I' || 
                c == 'O' || 
                c == 'U') {
                contador++;
            }
        }

        return contador;
    }

    // Método para probar la función
    public static void main(String[] args) {
        String entrada = "Daniel David Rivero Diaz";
        int total = contadorVocales(entrada);
        System.out.println( entrada + " : Total de vocales: " + total);
    }
}
