class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int res[][] = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int sum = 0;

                for(int r=i-k;r<=i+k;r++){
                    for(int c=j-k; c<=j+k;c++){
                        if(r>=0 && c>=0 && r<m && c<n){
                            sum += mat[r][c];
                        }
                    }
                }
                res[i][j] = sum;
            }
        }
        return res;
    }
}