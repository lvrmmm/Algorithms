package two_dimensional_dynamics;

import java.util.Scanner;

public class BackpackProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int W = scanner.nextInt();

        int[] weight = new int[N + 1];
        int[] value = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }

        int[][] dp = new int[N + 1][W + 1];

        for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= W; w++) {
                dp[i][w] = dp[i - 1][w];

                if (w >= weight[i]) {
                    dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[N][W]);
    }
}
