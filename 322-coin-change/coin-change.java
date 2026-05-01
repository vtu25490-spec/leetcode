import java.util.Arrays;

class Solution {

    public int coinChange(int[] coins, int amount) {

        // dp[i] = minimum coins needed for amount i
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        // Build DP array
        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (coin <= i) {

                    dp[i] = Math.min(
                            dp[i],
                            1 + dp[i - coin]
                    );
                }
            }
        }

        // If not possible
        return (dp[amount] > amount)
                ? -1
                : dp[amount];
    }
}