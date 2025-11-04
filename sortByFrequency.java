/* 
 * Relevante:
 *
 * - Learning Streams very important
 * - Map methods .put(), getOrDefault(),  
 */

import java.util.*;

public class sortByFrequency {
    public static int[] sortByFrequencyV1(int[] arrayNumbers) {
      
        // Input validation
        if (arrayNumbers == null || arrayNumbers.length == 0) {
            return new int[0]; // return empty array
        }

        // Storage: appearances of each number
        Map<Integer, Integer> appearances = new HashMap<>();

        // Counts and saves the appearances of each digit
        for (int number : arrayNumbers) {
            appearances.put(number, appearances.getOrDefault(number, 0) + 1);
        }
      
        // sort highest frequency to lowest using STREAMS 
      
        /* 
         *  converts arrayNumbers
         *  Streams requires Integer[] instead of int[]
         */ 
                          // Convierte el arreglo int[] en un IntStream (un stream especializado para tipos primitivos).
        Integer[] boxed = Arrays.stream(arrayNumbers)
                                // Convierte cada int en su equivalente objeto Integer.
                                .boxed()
                                 // Convierte el Stream<Integer> en un arreglo de Integer[].
                                .toArray(Integer[]::new);
      
        // sort highest frequency to lowest
        Arrays.sort(boxed, Comparator.comparingInt((Integer n) -> appearances.get(n)).reversed().thenComparingInt(n -> n));
        
        // back to int[]
        return Arrays.stream(boxed).mapToInt(Integer::intValue).toArray();
    }
}