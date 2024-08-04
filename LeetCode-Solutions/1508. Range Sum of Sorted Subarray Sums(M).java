import java.util.*;

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int mod = 1000000007;
        
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i + 1});
        }
        
        int result = 0;
        
        for (int i = 1; i <= right; i++) {
            int[] current = pq.poll();
            int sum = current[0];
            int index = current[1];
            
            if (i >= left) {
                result = (result + sum) % mod;
            }
            
            if (index < n) {
                pq.offer(new int[]{sum + nums[index], index + 1});
            }
        }
        
        return result;
    }
}