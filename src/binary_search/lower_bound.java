package binary_search;

import java.util.Scanner;

public class lower_bound {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int x = scanner.nextInt();

        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
        }

        int l = 0;
        int r = a.length - 1;
        int desired = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (a[mid] < x) {
                l = mid + 1;
            } else {
                desired = mid;
                r = mid - 1;
            }
        }

        System.out.println(desired);
    }
}
