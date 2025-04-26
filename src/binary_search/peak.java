package binary_search;

import java.util.Scanner;

public class  peak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(findPeak(n, arr));
    }

    public static int findPeak(int n, int[] arr) {
        int l = 0, r = n - 1;
        while (r > l) {
            int m = l + (r - l) / 2;

            if (arr[m + 1] < arr[m]) {
                if (m == 0 || arr[m - 1] < arr[m]) {
                    return m;
                } else {
                    r = m - 1;
                }
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}
