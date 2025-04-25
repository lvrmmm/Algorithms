package binary_search;

import java.util.Scanner;

public class nearest_element {
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
        int div = 0;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (a[mid] == x) {
                desired = mid;
                break; // Найден точный элемент
            } else if (a[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (desired == -1) {
            // Проверяем границы
            if (r >= 0 && l < N) {
                // Сравниваем A[r] и A[l]
                if (Math.abs(a[r] - x) <= Math.abs(a[l] - x)) {
                    desired = r;
                } else {
                    desired = l;
                }
            } else if (r >= 0) {
                desired = r; // Только A[r] доступен
            } else if (l < N) {
                desired = l; // Только A[l] доступен
            }
        }

        System.out.println(desired);

    }
}
