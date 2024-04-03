import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubtractionOperation {

    public static void main(String[] args) {
        List<Integer> array1 = new ArrayList<>(List.of(-1, 2, 3));
        List<Integer> array2 = new ArrayList<>(List.of(4, -5, 6));
        List<Integer> result = subtractionOperation(array1, array2);
        System.out.println("Array 1: " + array1);
        System.out.println("Array 2: " + array2);
        System.out.println("Result: " + result);
    }

    public static List<Integer> subtractionOperation(List<Integer> array1, List<Integer> array2) {
        Collections.reverse(array1);
        Collections.reverse(array2);

        for (int j = 0; j < array1.size(); j++) {
            if (array1.get(j) < 0 || array2.get(j) < 0) {
                throw new IllegalArgumentException("Negative numbers as input are invalid");
            }
            if (array1.get(j) > 9 || array2.get(j) > 9) {
                throw new IllegalArgumentException("Numbers greater than 9 as input are invalid");
            }
        }

        while (array1.size() < array2.size()) {
            array1.add(0);
        }
        while (array2.size() < array1.size()) {
            array2.add(0);
        }

        boolean flag = false;

        for (int i = array1.size() - 1; i >= 0; i--) {
            if (array1.get(i) < array2.get(i)) {
                Collections.swap(array1, array2);
                flag = true;
                break;
            } else if (array1.get(i) > array2.get(i)) {
                break;
            }
        }

        for (int i = 0; i < array1.size(); i++) {
            if (array1.get(i) < array2.get(i)) {
                array1.set(i, array1.get(i) + 10);
                array1.set(i + 1, array1.get(i + 1) - 1);
            }
            array1.set(i, array1.get(i) - array2.get(i));
        }

        while (array1.size() > 1 && array1.get(array1.size() - 1) == 0) {
            array1.remove(array1.size() - 1);
        }

        Collections.reverse(array1);
        if (flag) {
            array1.add(0, -1);
        }

        return array1;
    }
}
