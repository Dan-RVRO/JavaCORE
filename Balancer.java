import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Balancer {

    public static Boolean balancedChecker(String input){

        // Verificar si la cadena es nula o vacía
        if (input == null || input.isEmpty()){ return null; }

        // regex para conservar solo paréntesis, llaves y corchetes
        String cleanedInput = input.replaceAll("[^(){}\\[\\]]", "");

        // contar numero de apariciones de cada tipo de símbolo
        Long openParentesis  = cleanedInput.chars().filter(ch -> ch == '(').count();
        Long closeParentesis = cleanedInput.chars().filter(ch -> ch == ')').count();
        Long openBrackets    = cleanedInput.chars().filter(ch -> ch == '[').count();
        Long closedBrackets  = cleanedInput.chars().filter(ch -> ch == ']').count();
        Long openBraces      = cleanedInput.chars().filter(ch -> ch == '{').count();
        Long closeBraces     = cleanedInput.chars().filter(ch -> ch == '}').count();

        if (openParentesis.equals(closeParentesis) &&
            openBrackets.equals(closedBrackets) &&
            openBraces.equals(closeBraces)) {
            return true;
        }

        return false;
    }

    public static Boolean balancedCheckerV2(String input){

        // Verificar si la cadena es nula o vacía
        if (input == null || input.isEmpty()){ return null; }

        // regex para conservar solo paréntesis, llaves y corchetes
        String cleanedInput = input.replaceAll("[^(){}\\[\\]]", "");

        // almacenar conteo de apariciones
        Map<Character, Integer> apariciones = new HashMap<>();

        for (char ch : cleanedInput.toCharArray()) {
            apariciones.put(ch, apariciones.getOrDefault(ch, 0) + 1);
        }

        // verificar balanceo
        if (
            apariciones.containsKey('(') && apariciones.containsKey(')') &&
            apariciones.get('(').equals(apariciones.get(')')) &&
            apariciones.containsKey('[') && apariciones.containsKey(']') &&
            apariciones.get('[').equals(apariciones.get(']')) &&
            apariciones.containsKey('{') && apariciones.containsKey('}') &&
            apariciones.get('{').equals(apariciones.get('}'))) {
            return true;
        }


        return false;
    }

    // Método auxiliar para verificar si los paréntesis coinciden
    public static boolean isMatchingPair(char opening, char closing) {
            return (opening == '(' && closing == ')') ||
                   (opening == '[' && closing == ']') ||
                   (opening == '{' && closing == '}');
        }

    public static Boolean balancedCheckerV3(String input){

        // Verificar si la cadena es nula o vacía
        if (input == null || input.isEmpty()){ return null; }

        // regex para conservar solo paréntesis, llaves y corchetes
        String cleanedInput = input.replaceAll("[^(){}\\[\\]]", "");

        // almacenar orden de elementos
        Stack<Character> stack = new Stack<>();

        // verificar balanceo
        for (char ch : cleanedInput.toCharArray()) {
                if (ch == '('||ch =='[' ||ch == '{'){
                    stack.push(ch);
                }
                else if (ch == ')' || ch == ']' || ch == '}'){
                    if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)){
                        return false;
                    }
                }
        }
        return stack.isEmpty();
    }
        
  

    // Método para probar la función
    public static void main(String[] args) {
        String entrada1 = "{[ssd()]}";
        String entrada2 = "{rt6[(sd]ghtyd)}";
        String entrada3 = "{{[890[sde((ad))]67]}23}";
        String entrada4 = "((()43))223[]{322}45";
        String entrada5 = "((()))";
        String entrada6 = "{{asadas";
        String entrada7 = "((([][{}{}[]])))";
        String entrada8 = "((())[[[]]])";
        String entrada9 = "((({}{}{}{})))";



        System.out.println("balancedChecker");
        for (String testString : new String[]{entrada1, entrada2, entrada3, entrada4, entrada5, entrada6, entrada7, entrada8, entrada9}) {
            Boolean resultado = balancedChecker(testString);
            System.out.println("¿Está balanceada la cadena \"" + testString + "\"? : " + resultado);
        }

        System.out.println("balancedCheckerV2");
        for (String testString : new String[]{entrada1, entrada2, entrada3, entrada4, entrada5, entrada6, entrada7, entrada8, entrada9}) {
            Boolean resultado = balancedCheckerV2(testString);
            System.out.println("¿Está balanceada la cadena \"" + testString + "\"? : " + resultado);
        }

        System.out.println("balancedCheckerV3");
        for (String testString : new String[]{entrada1, entrada2, entrada3, entrada4, entrada5, entrada6, entrada7, entrada8, entrada9}) {
            Boolean resultado = balancedCheckerV3(testString);
            System.out.println("¿Está balanceada la cadena \"" + testString + "\"? : " + resultado);
        }
    }

}
