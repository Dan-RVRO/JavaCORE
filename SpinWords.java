import java.util.*;

/*
 *   Key Java Syntax Concepts Demonstrated in This Code:
 *
 * - Use of `StringBuilder` for efficient string construction instead of repeated concatenation.
 * - Calling `.length()` on `String` objects to determine word size (not to be confused with array `.length`).
 * - Splitting a sentence into words using `.split(" ")` and converting the result to a fixed-size list with `Arrays.asList()`.
 * - Iterating over a `List<String>` using an enhanced for-loop (`for-each`) for clarity and simplicity.
 * - Applying conditional logic with `if (word.length() >= 5)` to selectively reverse words.
 * - Reversing strings using `new StringBuilder(word).reverse().toString()` — a concise and idiomatic approach.
 * - Trimming the final result with `.trim()` to remove trailing whitespace after building the sentence.
 *
 * These syntax patterns are foundational for mastering string manipulation, control flow, and collection handling in Java.
 */

/**
 * Utility class that provides functionality to reverse words in a sentence
 * based on their length.
 */
public class SpinWords {

    /**
     * Reverses words in the input sentence that have 5 or more characters.
     * Shorter words remain unchanged. Words are separated by spaces.
     *
     * @param sentence the input sentence to process
     * @return a new sentence with qualifying words reversed,
     *         or an error message if input is null or empty
     */
    public String spinWords(String sentence) {

        // Validate input: must not be null or empty
        if (sentence == null || sentence.isEmpty()) {
            return "Can not be null or empty";
        }

        // Split sentence into individual words using space as delimiter
        List<String> words = Arrays.asList(sentence.split(" "));

        // StringBuilder to accumulate the final transformed sentence
        StringBuilder sentenceReversed = new StringBuilder();

        // Iterate through each word in the list
        for (String word : words) {

            // Reverse words with 5 or more characters and do append
            if (word.length() >= 5) {
                String wordReversed = new StringBuilder(word).reverse().toString();
                sentenceReversed.append(wordReversed).append(" ");
            } else {
                // Append shorter words unchanged
                sentenceReversed.append(word).append(" ");
            }
        }

        // Remove trailing space and return the final result
        return sentenceReversed.toString().trim();
    }
}