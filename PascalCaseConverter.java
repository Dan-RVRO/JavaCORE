public class PascalCaseConverter {

    public static String toPascalCase(String sentence){
        
        // verify is a valid string
        if (sentence == null || 
            sentence.isEmpty() || 
            sentence == "" ){
            return "String can not be empty or Null";
        }

        // splits the sentence using space as delimiter
        String[] slicedWords = sentence.trim().replaceAll("\\s+"," ").split(" ");

        // StringBuilder to build the final PascalCase string
        StringBuilder pascalCaseString = new StringBuilder();

        // loop through each word
        for (String word : slicedWords){

            // capitilize the first letter
            String capitilizedLetter = word.substring(0,1).toUpperCase();
            // get the rest of the word in lowercase
            String restOfWord = word.substring(1).toLowerCase();
            // merge both parts and append to the final string
            pascalCaseString.append(capitilizedLetter+restOfWord);

        }

        return pascalCaseString.toString();
    }

    // método para probar la función
    public static void main(String[] args){
        String[] pruebas = {
            "hello world",
            "java programming   language",
            "convert this   sentence to pascal case",
            "   leading and trailing spaces   ",
            "    hello     Java   ",
            "",
            null
        };

        for (String prueba : pruebas){
            String resultado = toPascalCase(prueba);
            System.out.println("Entrada: \""+prueba+"\" -> Salida: \""+resultado+"\"");
        }
    }
    
}
