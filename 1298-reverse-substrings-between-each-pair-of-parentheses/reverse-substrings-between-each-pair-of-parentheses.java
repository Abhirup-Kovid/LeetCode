class Solution {
    public String reverseParentheses(String s) {
        while (s.contains("(")) {

            int start = s.lastIndexOf('(');
 
            int end = s.indexOf(')', start);

            String inner = s.substring(start + 1, end);
       
            String reversed = new StringBuilder(inner).reverse().toString();

            s = s.substring(0, start) + reversed + s.substring(end + 1);
        }
        return s;
    }
}
