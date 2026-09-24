class Solution {
    public static int SumOfDigits(int n){
        int sum=0;

        while(n!=0){
            int ld = n%10;
            sum=sum+ld;
            n=n/10;
        }
        return sum;
    }

    public int smallestIndex(int[] nums) {
        int minIndex=-1;

        for(int i=0; i<nums.length; i++){

            if(SumOfDigits(nums[i]) == i ){
               if(minIndex == -1 || i < minIndex){
                    minIndex = i;
               }
            
        }    
    }
    return minIndex;
}
}
