package greedy;

import java.util.*;

public class TaskSchedule {
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x) {
        int px = find(x);
        parent[px] = find(px - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Task[] tasks = new Task[n];
        int maxDay = 0;

        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            int w = scanner.nextInt();
            tasks[i] = new Task(d, w);
            maxDay = Math.max(maxDay, d);
        }

        Arrays.sort(tasks, (a, b) -> Integer.compare(b.reward, a.reward));

        parent = new int[maxDay + 2];
        for (int i = 0; i <= maxDay + 1; i++) {
            parent[i] = i;
        }

        long totalReward = 0;

        for (Task task : tasks) {
            int availableDay = find(task.deadline);
            if (availableDay > 0) {
                totalReward += task.reward;
                union(availableDay);
            }
        }

        System.out.println(totalReward);
    }

    static class Task {
        int deadline;
        int reward;

        Task(int deadline, int reward) {
            this.deadline = deadline;
            this.reward = reward;
        }
    }
}
