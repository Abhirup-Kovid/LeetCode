class Solution {
    public int sumOfSquares(int[] nums) {
            int sum=0;
            int length=nums.length;
        for(int i = 1; i<=length ; i++){
            if(length%i==0){
                int sqr= nums[i-1]*nums[i-1];
                sum += sqr;

            }
        }
        return sum;
    }
}