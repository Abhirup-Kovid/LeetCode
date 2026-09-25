import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> result = dfs(expression);
        List<String> sorted = new ArrayList<>(result);
        Collections.sort(sorted);
        return sorted;
    }

    private Set<String> dfs(String expr) {
        List<Set<String>> unionParts = new ArrayList<>();
        Set<String> cur = new HashSet<>();
        int i = 0;

        while (i < expr.length()) {
            char c = expr.charAt(i);
            if (c == '{') {
                int j = i + 1, bal = 1;
                while (bal > 0) {
                    if (expr.charAt(j) == '{') bal++;
                    else if (expr.charAt(j) == '}') bal--;
                    j++;
                }
                Set<String> sub = dfs(expr.substring(i + 1, j - 1));
                cur = combine(cur, sub);
                i = j;
            } else if (Character.isLetter(c)) {
                cur = combine(cur, Collections.singleton(String.valueOf(c)));
                i++;
            } else if (c == ',') {
                unionParts.add(cur);
                cur = new HashSet<>();
                i++;
            } else {
                i++;
            }
        }

        unionParts.add(cur);
        Set<String> res = new HashSet<>();
        for (Set<String> s : unionParts) res.addAll(s);
        return res;
    }

    private Set<String> combine(Set<String> set1, Set<String> set2) {
        if (set1.isEmpty()) return new HashSet<>(set2);
        if (set2.isEmpty()) return new HashSet<>(set1);
        Set<String> res = new HashSet<>();
        for (String a : set1) {
            for (String b : set2) {
                res.add(a + b);
            }
        }
        return res;
    }
}
