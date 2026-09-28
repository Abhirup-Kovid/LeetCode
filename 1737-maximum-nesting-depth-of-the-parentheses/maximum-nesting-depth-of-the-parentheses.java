class Solution {
    public int maxDepth(String s) {
        int maxDepth=0;
        int depth=0;

        for(int i = 0 ; i<s.length();i++){
            if(s.charAt(i)=='('){
                depth++;
                maxDepth=Math.max(depth,maxDepth);
            }
            if(s.charAt(i)==')'){
                depth--;
            }
        }
        return maxDepth;
    }
}