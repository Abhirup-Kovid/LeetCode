class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int result[] = new int [seq.length()];
        int maxDepth=0;
        int depth=0;

        for(int i = 0 ; i<result.length;i++){
            if(seq.charAt(i)=='('){
                depth++;
                maxDepth=Math.max(depth,maxDepth);
            }
            if(depth%2==0){
                result[i]=0;
            }
            else{
                result[i]=1;
            }
            if(seq.charAt(i)==')'){
                depth--;
            }
        }
        return result;
    }
}