package binary_search;

import java.util.Scanner;

public class  peak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
        }

        int l = 0;
        int r = N - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            boolean isLeftValid = mid > 0 && a[mid - 1] < a[mid];
            boolean isRightValid = mid < N - 1 && a[mid] > a[mid + 1];

            if (isLeftValid && isRightValid) {
                System.out.println(mid);
                return;
            } else if (isLeftValid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
    }
}
