import java.util.*;

class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        // Min Heap -> stores {sum, index in nums1, index in nums2}
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Add first element pairs
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (k > 0 && !pq.isEmpty()) {

            int[] current = pq.poll();

            int i = current[1];
            int j = current[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            // Move to next element in nums2
            if (j + 1 < nums2.length) {
                pq.offer(new int[]{
                        nums1[i] + nums2[j + 1],
                        i,
                        j + 1
                });
            }

            k--;
        }

        return result;
    }
}