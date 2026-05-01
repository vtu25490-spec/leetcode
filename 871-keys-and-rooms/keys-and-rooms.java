import java.util.*;

class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n = rooms.size();

        boolean[] visited = new boolean[n];

        // DFS starting from room 0
        dfs(0, rooms, visited);

        // Check if all rooms are visited
        for (boolean room : visited) {

            if (!room) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int room,
                     List<List<Integer>> rooms,
                     boolean[] visited) {

        visited[room] = true;

        // Visit all rooms using keys
        for (int key : rooms.get(room)) {

            if (!visited[key]) {

                dfs(key, rooms, visited);
            }
        }
    }
}