import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/**
Алгоритм быстрой сортировки
 */
public class HW4 {
    static int separation(int[] array, int left, int right) {  
        int pivot = right;
        int counter = left;
        for (int i = left; i < right; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;
        return counter;
    }
    public static void quickSort(int[] array, int left, int right) {  
        if (right <= left) return;
        int pivot = separation(array, left, right);
        quickSort(array, left, pivot-1);
        quickSort(array, pivot+1, right);
    }
    public static int[] createArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(0, 99);
        }
        return array;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a size of an array: ");
        int size = scanner.nextInt();
        scanner.close();
        int[] array = createArray(size);
        System.out.println(String.format("%-10s= %s", "Initial array ", Arrays.toString(array)));
        quickSort(array, 0, array.length - 1 );
        System.out.println(String.format("%-10s= %s", "Sorted array ", Arrays.toString(array)));
    }
}