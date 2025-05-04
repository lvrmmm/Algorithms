package TopologicalSortingAndPathfinding;

import java.util.*;

public class KahnsAlgorithm {
    public static List<Integer> kahnTopologicalSort(int n, List<List<Integer>> adj) {
        int[] inDegree = new int[n + 1];
        for (int u = 1; u <= n; u++) {
            for (int v : adj.get(u)) {
                inDegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            result.add(u);

            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        if (result.size() != n) {
            return null; // Цикл в графе
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            String[] parts = scanner.nextLine().split(" ");
            int k = Integer.parseInt(parts[0]);
            for (int j = 1; j <= k; j++) {
                int v = Integer.parseInt(parts[j]);
                adj.get(i).add(v);
            }
        }
        List<Integer> topologicalSort = kahnTopologicalSort(n, adj);

        if (topologicalSort == null) {
            System.out.println("-1");
        } else {
            for (int i = 0; i < topologicalSort.size(); i++) {
                System.out.print(topologicalSort.get(i));
                if (i < topologicalSort.size() - 1) {
                    System.out.print(" ");
                }
            }
        }
    }
}
