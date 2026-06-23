class Solution {
    private static final int MOD = 1_000_000_007;
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[][] dp = new long[2][m];

        // Length = 2 initialization
        for (int x = 0; x < m; x++) {
            dp[0][x] = x;              // previous value > current value
            dp[1][x] = m - 1 - x;      // previous value < current value
        }

        for (int len = 3; len <= n; len++) {
            long[] prefixDown = new long[m + 1];
            long[] prefixUp = new long[m + 1];

            for (int i = 0; i < m; i++) {
                prefixDown[i + 1] = (prefixDown[i] + dp[0][i]) % MOD;
                prefixUp[i + 1] = (prefixUp[i] + dp[1][i]) % MOD;
            }

            long[][] ndp = new long[2][m];

            for (int y = 0; y < m; y++) {
                // Need previous value > y
                ndp[1][y] = (prefixDown[m] - prefixDown[y + 1] + MOD) % MOD;

                // Need previous value < y
                ndp[0][y] = prefixUp[y] % MOD;
            }

            dp = ndp;
        }

        long ans = 0;

        for (int x = 0; x < m; x++) {
            ans = (ans + dp[0][x] + dp[1][x]) % MOD;
        }

        return (int) ans;
    }
}