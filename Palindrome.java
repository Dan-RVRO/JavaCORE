public class Palindrome {

    /**
     * Verifica si una cadena de texto es un palíndromo.
     * 
     * @param text Cadena de entrada
     * @return true si es un palíndromo, false en caso contrario
     */

    public static boolean isItPalindrome(String text) {

        // Verificar si la cadena es nula o vacía
        if (text == null || text.isEmpty()){return false;}

        // Eliminar espacios y convertir a minúsculas
        String cleanedText = text.replaceAll("[^a-zA-Z]", "");
        cleanedText = cleanedText.toLowerCase();

        // invertir la cadena-
        String reversedCleanedText = new StringBuilder(cleanedText).reverse().toString();

        // Comparar la cadena original con la invertida
        if (cleanedText.equals(reversedCleanedText)){
            return true;
        }

        return false;
    }
    
    // Método para probar la función
    public static void main(String[] args) {        
        String entrada1 = "Anita lava la tina";
        String entrada2 = "Hola Mundo";
        String entrada3 = "A man a plan a canal Panama";
        String entrada4 = "";
        String entrada5 = null;

        for (String testString : new String[]{entrada1, entrada2, entrada3, entrada4, entrada5}) {
            boolean resultado = isItPalindrome(testString);
            System.out.println("¿Es \"" + testString + "\" un palíndromo? : " + resultado);
        }
    }
}
