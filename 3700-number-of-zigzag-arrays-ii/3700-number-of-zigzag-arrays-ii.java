class Solution {
    static final long MOD = 1_000_000_007L;
    public int zigZagArrays(int n, int l, int r) {
        int k = r - l + 1;
        int size = 2 * k;

        long[] base = new long[size];

        // Length = 2 states
        for (int j = 0; j < k; j++) {
            base[j] = j;               // Up[j]
            base[k + j] = k - 1 - j;   // Down[j]
        }

        long[][] trans = new long[size][size];

        // Up[j] <- sum of Down[i] where i < j
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < j; i++) {
                trans[j][k + i] = 1;
            }
        }

        // Down[j] <- sum of Up[i] where i > j
        for (int j = 0; j < k; j++) {
            for (int i = j + 1; i < k; i++) {
                trans[k + j][i] = 1;
            }
        }

        long[][] power = matrixPower(trans, n - 2);
        long[] result = multiply(power, base);

        long ans = 0;
        for (long val : result) {
            ans = (ans + val) % MOD;
        }

        return (int) ans;
    }

    private long[] multiply(long[][] mat, long[] vec) {
        int n = mat.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                sum = (sum + mat[i][j] * vec[j]) % MOD;
            }
            res[i] = sum;
        }

        return res;
    }

    private long[][] matrixPower(long[][] mat, long exp) {
        int n = mat.length;

        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, mat);
            }

            mat = multiply(mat, mat);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;

                long cur = A[i][k];

                for (int j = 0; j < n; j++) {
                    if (B[k][j] == 0) continue;

                    res[i][j] = (res[i][j] + cur * B[k][j]) % MOD;
                }
            }
        }

        return res;
    }
}