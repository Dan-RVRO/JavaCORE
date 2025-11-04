import java.util.stream.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

   /*
    * Streams in Java provide a modern way to process sequences of elements
    * (like collections) in a functional style. They allow for operations such as
    * filtering, mapping, and reducing data with a focus on what to do with the data
    * rather than how to do it.
    */

public class StreamsTut {
    public static void main(String[] args) {


        // Excercise 1:
        String[] inputArray = {"apple", "Banana", "kiwi", "pear", "grape", "Orange", "fig", "plum"};
        System.out.println(filterStrings(inputArray));
        
        
        




        /*
         * When class is no static we need to create instance of class to call method
         * or we can make method static to call directly
         * 
         * StreamsTut tut = new StreamsTut();
         * tut.gettingStarted();
         */

        gettingStarted();
          
    }

    /*
         * Excercise 1:
         * 
         * Given a list of strings, return a list of the strings that: 
         * - are longer than 3 characters
         * - start with a lowercase letter
         * - and are sorted alphabetically
         */

    public static List<String> filterStrings(String[] inputArray) {

        // turn String[] array in to List<String> object
        List<String> inputList = Arrays.stream(inputArray)
                                       .filter(str -> str.length() > 3 && Character.isLowerCase(str.charAt(0)))
                                       .sorted()          
                                       .toList();
        /* 
        for (String str : inputList) {
            System.out.println(str);
        }
        */

        return inputList;
    }

    /*
     * Getting Started with Streams
     *  1. Creating a Stream
     *  2. Using forEach to process elements
     *  3. Common Stream operations
     */

    public static void gettingStarted() {
        System.out.println("Getting Started with Streams");

        // Creating a Stream from a list of integers
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        // Using forEach to print each element in the stream
        integerStream.forEach(num -> System.out.println("Number: " + num));

        // Creating a Stream from an array of strings
        Stream<String> stringStream = Stream.of("Apple", "Banana", "Cherry");

        // Using forEach to print each element in the stream
        stringStream.forEach(fruit -> System.out.println("Fruit: " + fruit));

        // Using stream to create a List<String> 
        Stream<String> colorsStream = Stream.of("Red", "Green", "Blue");
        colorsStream.forEach(color -> System.out.println("Color: " + color));

        // sorting number using stream
        Stream<Integer> unsortedStream = Stream.of(5, 3, 8, 1, 2);
        List<Integer> sortedNumbers = unsortedStream.sorted().toList();
        sortedNumbers.forEach(num -> System.out.println(num));  

    }
}