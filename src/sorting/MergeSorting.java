package sorting;

import java.util.Scanner;

public class MergeSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int [] a = new int [N];

        for(int i = 0; i<N; i++){
            a[i]=scanner.nextInt();
        }

        int [] buffer = new int [N];
        mergeSort(a, buffer, 0, N-1);
        display(a);
    }
    private static void mergeSort(int[] arr, int[] buffer, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, buffer, left, mid);
            mergeSort(arr, buffer, mid + 1, right);
            merge(arr, buffer, left, mid, right);
        }
    }

    private static void merge(int[] arr, int[] buffer, int left, int mid, int right) {

        System.arraycopy(arr, left, buffer, left, right - left + 1);

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (buffer[i] <= buffer[j]) {
                arr[k++] = buffer[i++];
            } else {
                arr[k++] = buffer[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = buffer[i++];
        }
    }
    public static void display(int [] a){
        for (int j : a) {
            System.out.print(j + " ");
        }
    }

}
