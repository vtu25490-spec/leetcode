class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;  // position to place next non-zero
        
        // Move all non-zero elements forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        
        // Fill remaining positions with 0
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}
