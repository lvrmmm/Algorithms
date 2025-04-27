package sorting;

import java.util.Scanner;

//Сортировка, не требующая дополнительного места. Одна из разновидностей: быстрая сортировка с выбором
//опорного элемента. Для малых массивов используем алгоритм сортировки методом вставки, для остальных - быстрая
//сортировка

public class InPlaceSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int [] a = new int [N];

        for(int i = 0; i<N; i++){
            a[i]=scanner.nextInt();
        }

        quickSort(a, 0, N-1);
        display(a);

    }
    public static void quickSort(int [] a, int low, int high){
        if (low < high){
            if (high - low <=10){
                insertionSort(a, low, high);
            }
            int pivotIndex = medianOfThree(a, low, high);
            swap(a, pivotIndex, high);
            int pivot = partition(a, low, high);

            quickSort(a, low, pivot -1 );
            quickSort(a, pivot + 1, high);
        }
    }
    public static int partition(int [] a, int low, int high){
        int pivot = a[high];  // pivot уже на месте (после medianOfThree)
        int i = low;
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, high);
        return i;
    }
    public static void swap(int [] a, int left, int right){

        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
    private static void insertionSort(int[] a, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= low && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
    private static int medianOfThree(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;

        if (arr[low] > arr[mid])
            swap(arr, low, mid);
        if (arr[low] > arr[high])
            swap(arr, low, high);
        if (arr[mid] > arr[high])
            swap(arr, mid, high);

        return mid;
    }
    public static void display(int [] a){
        for (int j : a) {
            System.out.print(j + " ");
        }
    }
}
