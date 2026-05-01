class Solution {

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        boolean[] visited = new boolean[n];

        int provinces = 0;

        // Check every city
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                // New province found
                dfs(isConnected, visited, i);

                provinces++;
            }
        }

        return provinces;
    }

    private void dfs(int[][] graph, boolean[] visited, int city) {

        visited[city] = true;

        for (int j = 0; j < graph.length; j++) {

            // Connected and not visited
            if (graph[city][j] == 1 && !visited[j]) {

                dfs(graph, visited, j);
            }
        }
    }
}