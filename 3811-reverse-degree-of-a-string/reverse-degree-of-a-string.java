class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++){
            sum += (i + 1)*(123 - s.charAt(i));
        }
        return sum;
    }
}