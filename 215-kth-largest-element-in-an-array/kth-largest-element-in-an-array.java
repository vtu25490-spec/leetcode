import java.util.PriorityQueue;

class Solution {

    public int findKthLargest(int[] nums, int k) {

        // Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {

            pq.offer(num);

            // Keep only k largest elements
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Top element is kth largest
        return pq.peek();
    }
}