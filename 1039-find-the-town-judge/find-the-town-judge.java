class Solution {

    public int findJudge(int n, int[][] trust) {

        // indegree[i] = number of people trusting i
        // outdegree[i] = number of people i trusts
        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];

        // Process trust relationships
        for (int[] t : trust) {

            int a = t[0];
            int b = t[1];

            outdegree[a]++;
            indegree[b]++;
        }

        // Find judge
        for (int i = 1; i <= n; i++) {

            // Judge trusts nobody and everyone trusts judge
            if (indegree[i] == n - 1 && outdegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}
