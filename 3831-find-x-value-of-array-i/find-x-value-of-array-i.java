class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] subArr = new long[k];
        long[] res = new long[k];

        for (int ele : nums) {   
            long[] nSubArr = new long[k];
            int rem = ele % k;   

            nSubArr[rem]++;

            for (int i = 0; i < k; i++) {   
                if (subArr[i] > 0) {
                    int nRem = (int)((i * rem) % k);   
                    nSubArr[nRem] += subArr[i];
                }
            }

            for (int i = 0; i < k; i++) {
                res[i] += nSubArr[i];
            }

            subArr = nSubArr;
        }
        return res;
    }
}
