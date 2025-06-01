package data_structures;

import java.util.*;

public class MaxInSW {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k)
                deque.pollFirst();

            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i])
                deque.pollLast();

            deque.offerLast(i);

            if (i >= k - 1)
                result.add(arr[deque.peekFirst()]);
        }

        for (int max : result) {
            System.out.print(max + " ");
        }
    }
}
