import java.util.*;

class Solution {

    public int[] shortestAlternatingPaths(int n,
                                          int[][] redEdges,
                                          int[][] blueEdges) {

        // Graph for red and blue edges
        List<Integer>[] redGraph = new ArrayList[n];
        List<Integer>[] blueGraph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            redGraph[i] = new ArrayList<>();
            blueGraph[i] = new ArrayList<>();
        }

        // Build red graph
        for (int[] edge : redEdges) {
            redGraph[edge[0]].add(edge[1]);
        }

        // Build blue graph
        for (int[] edge : blueEdges) {
            blueGraph[edge[0]].add(edge[1]);
        }

        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        // visited[node][color]
        // color 0 = red, 1 = blue
        boolean[][] visited = new boolean[n][2];

        Queue<int[]> queue = new LinkedList<>();

        // Start from node 0 with both colors
        queue.offer(new int[]{0, 0}); // previous red
        queue.offer(new int[]{0, 1}); // previous blue

        visited[0][0] = true;
        visited[0][1] = true;

        int distance = 0;

        // BFS
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int node = current[0];
                int color = current[1];

                // First shortest distance
                if (answer[node] == -1) {
                    answer[node] = distance;
                }

                // If previous edge was red,
                // next must be blue
                if (color == 0) {

                    for (int next : blueGraph[node]) {

                        if (!visited[next][1]) {

                            visited[next][1] = true;

                            queue.offer(new int[]{next, 1});
                        }
                    }
                }

                // If previous edge was blue,
                // next must be red
                else {

                    for (int next : redGraph[node]) {

                        if (!visited[next][0]) {

                            visited[next][0] = true;

                            queue.offer(new int[]{next, 0});
                        }
                    }
                }
            }

            distance++;
        }

        return answer;
    }
}