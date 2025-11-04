import java.util.*;
import java.util.stream.*;


/**
 * Key takeaways include:
 * 
 * - Using StringBuilder and .reverse() for string manipulation.
 * - Converting a reversed string into a List<Integer> using Arrays.stream() and map().
 * - Applying conditional logic inside a for loop to transform digits based on index parity.
 * - Declaring and populating ArrayLists with .add().
 * - Leveraging Stream operations like .mapToInt() and .sum() for numeric aggregation.
 * - Using the modulo operator (%) to validate checksum logic.
 *
 * Overall, this exercise improved my fluency with Java collections, control flow, and stream-based data processing.
 */

public class Validate {

    /**
     * Validates a credit card number using the Luhn algorithm.
     *
     * @param n The credit card number as a string.
     * @return true if the number is valid according to Luhn, false otherwise.
     */
    public static boolean validate(String n) {
        
        // Reverse the input string to process digits from right to left
        String reversedNumbers = new StringBuilder(n).reverse().toString();
        
        // Convert each character into an integer and collect into a list
        List<Integer> numbersList = Arrays.stream(reversedNumbers.split(""))
                                          .map(Integer::parseInt)
                                          .collect(Collectors.toList());
        
        // Prepare a list to store transformed digits after applying Luhn rules
        List<Integer> transformedDigits = new ArrayList<>();
        
        // Apply transformation: double every second digit (odd index after reversal)
        for (int i = 0; i < numbersList.size(); i++) {
          
            int digit = numbersList.get(i);
            if (i % 2 == 0) {
                // Even index (originally odd position): keep digit as is
                transformedDigits.add(digit);
            } else {
                // Odd index (originally even position): double the digit
                int doubled = digit * 2;
                // If result is greater than 9, subtract 9
                transformedDigits.add(doubled > 9 ? doubled - 9 : doubled);
            }
        }
        
        // Sum all transformed digits and check if divisible by 10
        boolean isValid = transformedDigits.stream()
                                           .mapToInt(Integer::intValue)
                                           .sum() % 10 == 0;
        
        return isValid;
    }
}