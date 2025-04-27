package sorting;

import java.util.Scanner;

public class HeapSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
        }
        heapSort(a);
        display(a);

    }
    public static void heapSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);

            heapify(a, i, 0);
        }
    }

    private static void heapify(int[] a, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < heapSize && a[leftChild] > a[largest]) {
            largest = leftChild;
        }

        if (rightChild < heapSize && a[rightChild] > a[largest]) {
            largest = rightChild;
        }

        if (largest != rootIndex) {
            swap(a, rootIndex, largest);

            heapify(a, heapSize, largest);
        }
    }
    public static void swap(int [] a, int left, int right){

        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
    public static void display(int [] a){
        for (int j : a) {
            System.out.print(j + " ");
        }
    }
}
