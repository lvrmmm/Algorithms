package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class DisjointSegments {
    static class Segment {
        int left, right;

        Segment(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];

        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            segments[i] = new Segment(l, r);
        }

        Arrays.sort(segments, Comparator.comparingInt(seg -> seg.right));

        int count = 0;
        int lastEnd = Integer.MIN_VALUE;

        for (Segment seg : segments) {
            if (seg.left >= lastEnd) {
                count++;
                lastEnd = seg.right;
            }
        }

        System.out.println(count);
    }
}
