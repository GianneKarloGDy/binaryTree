import java.util.Arrays;

public class BinaryTree {
    public static void main(String[] args) {
        int[] numbers = { 1, 3, 5, 22, 0, 7, 9, 11, 13, 15, 17, 19, 21 };

        asOrder(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        
        int target = 100;
        
        int position = binarySearch(numbers, target);
        if (position != -1) {
            System.out.println(" Target Found " + target + " At Line => " + (position + 1));
        } else {
            System.out.println(" Target " + target + " Not found");
        }
    }

    private static int binarySearch(int[] numbers, int numberToFind) {
        return RbinarySearch(numbers, numberToFind, 0, numbers.length - 1);
    }

    private static int RbinarySearch(int[] numbers, int numberToFind, int low, int high) {
        if (low > high) {
            return -1;
        }

        int middlePosition = (low + high) / 2;
        int middleNumber = numbers[middlePosition];

        if (numberToFind == middleNumber) {
            return middlePosition;
        } else if (numberToFind < middleNumber) {
            return RbinarySearch(numbers, numberToFind, low, middlePosition - 1);
        } else {
            return RbinarySearch(numbers, numberToFind, middlePosition + 1, high);
        }
    }

    private static void asOrder(int[] numbers) {
        int n = numbers.length;
        // Sorting the array
        for (int i = 0; i < n - 1; i++) {
            int smallestIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (numbers[j] < numbers[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            // Swap numbers[i] and numbers[smallestIndex]
            int temp = numbers[smallestIndex];
            numbers[smallestIndex] = numbers[i];
            numbers[i] = temp;
        }
    }
}