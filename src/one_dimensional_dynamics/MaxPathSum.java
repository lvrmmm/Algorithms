package one_dimensional_dynamics;

import java.util.*;
import java.io.*;

public class MaxPathSum {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        if (n == 1) {
            System.out.println(a[0]);
            return;
        }

        int[] dp = new int[n];
        dp[0] = a[0];
        dp[1] = a[0] + a[1];

        for (int i = 2; i < n; i++) {
            dp[i] = a[i] + Math.max(dp[i - 1], dp[i - 2]);
        }

        System.out.println(dp[n - 1]);
    }
}