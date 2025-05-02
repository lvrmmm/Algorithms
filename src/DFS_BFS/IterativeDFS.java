package DFS_BFS;

import java.util.*;

public class IterativeDFS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split(" ");
            int k = Integer.parseInt(parts[0]);
            for (int j = 1; j <= k; j++) {
                int neighbor = Integer.parseInt(parts[j]) - 1;
                graph.get(i).add(neighbor);
            }
        }

        boolean[] visited = new boolean[n];
        List<Integer> traversal = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                visited[current] = true;
                traversal.add(current + 1);
                List<Integer> neighbors = graph.get(current);
                Collections.sort(neighbors, Collections.reverseOrder());
                for (int neighbor : neighbors) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        for (int v : traversal) {
            System.out.print(v + " ");
        }
    }
}
