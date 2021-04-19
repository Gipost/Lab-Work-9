import java.util.Random;
import org.junit.Test;
import sorter.*;

import static org.junit.Assert.*;


public class Tester {
    int [] sort(int[] array, int left, int right){
        sorter.mergeSort(array,0,array.length-1);
        return array;
    }
    MergeSort sorter = new MergeSort();
    @Test
    public void simpleTest() {
        int[] arr = {3, 1, 2};
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, sort(arr,0,arr.length-1));
    }
    @Test
    public void reverseTest() {
        int[] arr = new int[100];
        int[] expected = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = 99 - i;
            expected[i] = i;
        }
        assertArrayEquals(expected, sort(arr,0,arr.length-1));
    }
    private void simpleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int x = arr[i];
            while (j > 0 && arr[j - 1] > x) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = x;
        }
    }
    @Test
    public void randomTest() {
        int[] arr = new int[100];
        int[] expected = new int[100];
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            arr[i] = rand.nextInt(1001);
            expected[i] = arr[i];
        }
        simpleSort(expected);
        assertArrayEquals(expected, sort(arr,0,arr.length-1));
    }
    private int[] generate(int N) {
        int[] arr = new int[N];
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            arr[i] = rand.nextInt(1000);
        }
        return arr;
    }
    private void check(int [] arr) {
        for (int i=0;i<arr.length-1;i++) {
            assertTrue(arr[i] <= arr[i+1]);
        }
    }
    @Test
    public void stressTestOne() {
        int[] arr = generate(1000);
        check(sort(arr,0,arr.length-1));
    }

    @Test
    public void stressTestTwo() {
        int[] arr = generate(100000);
        check(sort(arr,0,arr.length-1));
    }
    @Test
    public void stressTestThree() {
        int[] arr = generate(1000000);
        check(sort(arr,0,arr.length-1));
    }
}