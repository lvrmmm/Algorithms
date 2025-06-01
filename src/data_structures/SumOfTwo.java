package data_structures;
import java.util.*;

public class SumOfTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(k - num)) {
                System.out.println("YES");
                return;
            }
            seen.add(num);
        }

        System.out.println("NO");
    }
}
