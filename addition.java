import java.util.Arrays;

public class AdditionOperation {

    public static void main(String[] args) {
        int[] array1 = {-1, 2, 3};
        int[] array2 = {4, -5, 6};
        int[] result = additionOperation(array1, array2);
        System.out.println("Array 1: " + Arrays.toString(array1));
        System.out.println("Array 2: " + Arrays.toString(array2));
        System.out.println("Result: " + Arrays.toString(result));
    }

    public static int[] additionOperation(int[] array1, int[] array2) {
        int[] num1 = reverseArray(array1);
        int[] num2 = reverseArray(array2);

        for (int j = 0; j < num1.length; j++) {
            if (num1[j] < 0 || num2[j] < 0) {
                throw new IllegalArgumentException("Negative numbers as input are invalid");
            }
            if (num1[j] > 9 || num2[j] > 9) {
                throw new IllegalArgumentException("Numbers greater than 9 as input are invalid");
            }
        }

        while (num1.length < num2.length) {
            num1 = prependZero(num1);
        }
        while (num2.length < num1.length) {
            num2 = prependZero(num2);
        }

        int[] result = new int[num1.length];
        int carry = 0;

        for (int i = 0; i < num1.length; i++) {
            int sum = num1[i] + num2[i] + carry;
            carry = sum / 10;
            result[i] = sum % 10;
        }

        if (carry > 0) {
            result = prependCarry(result, carry);
        }

        return result;
    }

    public static int[] reverseArray(int[] array) {
        int[] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }
        return reversedArray;
    }

    public static int[] prependZero(int[] array) {
        int[] newArray = new int[array.length + 1];
        newArray[0] = 0;
        System.arraycopy(array, 0, newArray, 1, array.length);
        return newArray;
    }

    public static int[] prependCarry(int[] array, int carry) {
        int[] newArray = new int[array.length + 1];
        newArray[0] = carry;
        System.arraycopy(array, 0, newArray, 1, array.length);
        return newArray;
    }
}
