import java.util.*;

class Solution {

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        // Assign unique group ids to ungrouped items
        for (int i = 0; i < n; i++) {

            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        // Item graph
        List<List<Integer>> itemGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }

        int[] itemIndegree = new int[n];

        // Group graph
        List<List<Integer>> groupGraph = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            groupGraph.add(new ArrayList<>());
        }

        int[] groupIndegree = new int[m];

        // Build graphs
        for (int curr = 0; curr < n; curr++) {

            for (int prev : beforeItems.get(curr)) {

                // Item graph
                itemGraph.get(prev).add(curr);
                itemIndegree[curr]++;

                // Group graph
                if (group[curr] != group[prev]) {

                    groupGraph.get(group[prev]).add(group[curr]);

                    groupIndegree[group[curr]]++;
                }
            }
        }

        // Topological sort items
        List<Integer> itemOrder =
                topoSort(itemGraph, itemIndegree, n);

        if (itemOrder.size() == 0) {
            return new int[0];
        }

        // Topological sort groups
        List<Integer> groupOrder =
                topoSort(groupGraph, groupIndegree, m);

        if (groupOrder.size() == 0) {
            return new int[0];
        }

        // Store items by group
        Map<Integer, List<Integer>> groupToItems =
                new HashMap<>();

        for (int item : itemOrder) {

            groupToItems
                    .computeIfAbsent(group[item],
                            k -> new ArrayList<>())
                    .add(item);
        }

        // Build final answer
        List<Integer> result = new ArrayList<>();

        for (int grp : groupOrder) {

            List<Integer> items =
                    groupToItems.getOrDefault(grp,
                            new ArrayList<>());

            result.addAll(items);
        }

        // Convert to array
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    // Topological Sort
    private List<Integer> topoSort(List<List<Integer>> graph,
                                   int[] indegree,
                                   int size) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < size; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {

            int node = queue.poll();

            order.add(node);

            for (int neighbor : graph.get(node)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Cycle check
        if (order.size() == size) {
            return order;
        }

        return new ArrayList<>();
    }
}