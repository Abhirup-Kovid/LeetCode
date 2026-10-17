class Solution {

    static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sumOfDigits(nums[i]); // digit sum
            arr[i][1] = nums[i];             // value
            arr[i][2] = i;                   // original index
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {

            if (visited[i] || arr[i][2] == i)
                continue;

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j][2];
                cycleSize++;
            }

            swaps += cycleSize - 1;
        }

        return swaps;
    }
}