import java.util.*;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];
        
        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(squares);

        long score = 0;
        int left = 0, right = n - 1;
        int idx = 0;

        while (left <= right) {
            if (idx % 2 == 0) {
                score += squares[right--];
            } else {
                score -= squares[left++]; 
            }
            idx++;
        }
        return score;
    }
}
