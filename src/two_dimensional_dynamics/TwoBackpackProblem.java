package two_dimensional_dynamics;

import java.util.Scanner;

public class TwoBackpackProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int W1 = scanner.nextInt();
        int W2 = scanner.nextInt();

        int[] weight = new int[N];
        int[] value = new int[N];

        for (int i = 0; i < N; i++) {
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }


        int[][] dp = new int[W1 + 1][W2 + 1];

        for (int idx = 0; idx < N; idx++) {
            int w = weight[idx];
            int v = value[idx];


            for (int i = W1; i >= 0; i--) {
                for (int j = W2; j >= 0; j--) {

                    if (i >= w) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - w][j] + v);
                    }


                    if (j >= w) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - w] + v);
                    }


                }
            }
        }

        System.out.println(dp[W1][W2]);
    }
}
