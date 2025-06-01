package greedy;

import java.util.*;
import java.io.*;

public class BuyingThings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);

        String[] pricesStr = reader.readLine().split(" ");
        int[] prices = new int[N];
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(pricesStr[i]);
        }

        Arrays.sort(prices);

        int count = 0;
        long total = 0;

        for (int price : prices) {
            if (total + price <= K) {
                total += price;
                count++;
            } else {
                break;
            }
        }

        System.out.println(count);
    }
}
