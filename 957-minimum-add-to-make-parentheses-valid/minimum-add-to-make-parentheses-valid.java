class Solution {
    public int minAddToMakeValid(String s) {
        int countO=0;
        int countC=0;
        for(char ch : s.toCharArray()){
            if(ch=='('){
                countO++;
            }
            else{
                if(countO>0){
                    countO--;
                }
                else{
                    countC++;
                }   
            }
        }
        return countO+countC;
    }
}