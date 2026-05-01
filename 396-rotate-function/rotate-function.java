class Solution {

    public int maxRotateFunction(int[] nums) {

        int n = nums.length;

        int sum = 0;
        int f = 0;

        // Calculate total sum and F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i];
        }

        int max = f;

        // Calculate F(k) using formula
        // F(k) = F(k-1) + sum - n * nums[n-k]
        for (int k = 1; k < n; k++) {

            f = f + sum - n * nums[n - k];

            max = Math.max(max, f);
        }

        return max;
    }
}