class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if((m + n - 1) % 2 == 1){
            return false;
        }
        Map<String, Boolean> memo =new HashMap<>(); 
        return dfs(0, 0, 0, grid, memo);
    }

    private boolean dfs(int i, int j, int balance, char[][] grid, Map<String, Boolean> memo){
        int m = grid.length;
        int n = grid[0].length;

        if(i >= m || j>= n){
            return false;
        }
        if(grid[i][j] == '('){
            balance++;
        }
        else{
            balance--;
        }

        if(balance < 0){
            return false;
        }
        if(i == m-1 && j == n-1){
            return balance==0;
        }
        String key = i + "," + j + "," + balance;
        if (memo.containsKey(key)) return memo.get(key);

        // Move down or right
        boolean result = dfs(i + 1, j, balance, grid, memo) || dfs(i, j + 1, balance, grid, memo);

        memo.put(key, result);
        return result;
    }
}