class Solution {

    public int climbStairs(int n) {

        // Base cases
        if (n <= 2) {
            return n;
        }

        int first = 1;
        int second = 2;

        // Fibonacci approach
        for (int i = 3; i <= n; i++) {

            int current = first + second;

            first = second;
            second = current;
        }

        return second;
    }
}