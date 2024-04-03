import java.util.Arrays;

public class MultiplicationOperation {

    public static void main(String[] args) {
        int[] array1 = {-1, 2, 3};
        int[] array2 = {4, -5, 6};
        int[] result = multiplicationOperation(array1, array2);
        System.out.println("Array 1: " + Arrays.toString(array1));
        System.out.println("Array 2: " + Arrays.toString(array2));
        System.out.println("Result: " + Arrays.toString(result));
    }

    public static int[] multiplicationOperation(int[] array1, int[] array2) {
        int[] num1 = reverseArray(array1);
        int[] num2 = reverseArray(array2);
        int[] result = new int[num1.length + num2.length];

        if (array1.length == 0 || array2.length == 0) {
            throw new IllegalArgumentException("Empty arrays are not allowed");
        }

        for (int j = 0; j < num1.length; j++) {
            if (num1[j] < 0 || num2[j] < 0) {
                throw new IllegalArgumentException("Negative numbers as input are invalid");
            }
            if (num1[j] > 9 || num2[j] > 9) {
                throw new IllegalArgumentException("Numbers greater than 9 as input are invalid");
            }
        }

        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {
                int product = num1[i] * num2[j] + result[i + j];
                result[i + j] = product % 10;
                result[i + j + 1] += product / 10;
            }
        }

        while (result.length > 1 && result[result.length - 1] == 0) {
            result = Arrays.copyOf(result, result.length - 1);
        }

        return reverseArray(result);
    }

    public static int[] reverseArray(int[] array) {
        int[] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }
        return reversedArray;
    }
}
