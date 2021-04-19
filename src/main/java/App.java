import sorter.*;
public class App {
    public static void main(String[] args) {
        MergeSort Sorter = new MergeSort();
        int[] arr = {3, 1, 2, 9, 7};
        Sorter.mergeSort(arr,0,arr.length-1);
    }
}