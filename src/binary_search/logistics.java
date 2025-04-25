package binary_search;

import java.util.Scanner;

public class logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение входных данных
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] weights = new int[N];

        for (int i = 0; i < N; i++) {
            weights[i] = scanner.nextInt();
        }

        System.out.println(minMaxCapacity(weights, K));
    }

    private static boolean canDistribute(int[] weights, int maxCapacity, int K) {
        int currentWeight = 0;
        int trucksUsed = 1;

        for (int weight : weights) {
            if (currentWeight + weight > maxCapacity) {
                trucksUsed++;
                currentWeight = weight;
                if (trucksUsed > K) {
                    return false;
                }
            } else {
                currentWeight += weight;
            }
        }

        return true;
    }
    private static int minMaxCapacity(int[] weights, int K) {
        int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        while (low < high) {
            int mid = (low + high) / 2;
            if (canDistribute(weights, mid, K)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
