package one_dimensional_dynamics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Partitions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        System.out.println(countPartitions(N));
    }

    public static int countPartitions(int N) {
        int[][] dp = new int[N+1][N+1];

        dp[0][0] = 1;

        for (int num = 1; num <= N; num++) {
            for (int sum = 0; sum <= N; sum++) {
                if (num > sum) {
                    dp[num][sum] = dp[num-1][sum];
                } else {
                    dp[num][sum] = dp[num-1][sum] + dp[num][sum - num];
                }
            }
        }

        return dp[N][N];
    }
}
