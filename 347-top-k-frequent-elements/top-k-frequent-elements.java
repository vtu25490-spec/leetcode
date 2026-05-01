import java.util.*;

class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        // Store frequency of elements
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Min Heap based on frequency
        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (int key : map.keySet()) {

            pq.offer(key);

            // Keep only k frequent elements
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Store result
        int[] result = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }

        return result;
    }
}