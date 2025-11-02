import java.util.Arrays;

public class SecondLargest {
    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }
        
        int largest = Arrays.stream(arr).max().getAsInt();
        return largest;
    }
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        int secondLargest = findSecondLargest(numbers);
        System.out.println("The second largest number is: " + secondLargest);
    }
}
