class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        long ans = 0;

        for (int k = 1; k * k <= n; k++) {
            if (n % k != 0) continue;

            if (canSort(nums, sorted, k)) ans += k;

            int other = n / k;
            if (other != k && canSort(nums, sorted, other)) {
                ans += other;
            }
        }

        return (int) ans;
    }

    private boolean canSort(int[] nums, int[] sorted, int k) {
        int n = nums.length;

        for (int start = 0; start < n; start += k) {
            if (!isRotation(nums, sorted, start, k)) {
                return false;
            }
        }

        return true;
    }

    private boolean isRotation(int[] nums, int[] sorted, int start, int len) {
        int[] doubled = new int[2 * len];

        for (int i = 0; i < len; i++) {
            doubled[i] = nums[start + i];
            doubled[i + len] = nums[start + i];
        }

        return kmp(doubled, sorted, start, len);
    }

    private boolean kmp(int[] text, int[] target, int start, int len) {
        int[] pattern = new int[len];

        for (int i = 0; i < len; i++) {
            pattern[i] = target[start + i];
        }

        int[] lps = buildLps(pattern);

        int i = 0, j = 0;

        while (i < text.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;

                if (j == len) return true;
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return false;
    }

    private int[] buildLps(int[] pat) {
        int m = pat.length;
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {
            if (pat[i] == pat[len]) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                i++;
            }
        }

        return lps;
    }
}