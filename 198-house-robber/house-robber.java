class Solution {

    public int rob(int[] nums) {

        int prev1 = 0; // Maximum till previous house
        int prev2 = 0; // Maximum till house before previous

        for (int money : nums) {

            // Choose max:
            // rob current house OR skip it
            int current = Math.max(prev1, prev2 + money);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
