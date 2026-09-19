class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int k = nums.length - 1;

        
        while (j <= k) {
            if (nums[j] == 0) {
                int swapper = nums[i];
                nums[i] = nums[j];
                nums[j] = swapper;
                i++;
                j++;
            } else if (nums[j] == 1) {
                j++;
            } else { 
                int swapper = nums[j];
                nums[j] = nums[k];
                nums[k] = swapper;
                k--;
            }
        }
    }
}