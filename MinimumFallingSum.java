//TC: O(n^2)
//SC: O(1)
//Implemented using paint house pattern to find the least falling path sum and modified the existing matrix.

class DeleteAndEarn {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }

        int n = matrix.length;
        for(int i = n-2; i>=0; i--) {
            for(int j = 0; j< n; j++) {
                if(j == 0) {
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j+1]);

                } else if(j == n-1) {
                    matrix[i][j] += Math.min(matrix[i+1][j-1], matrix[i+1][j]);

                } else {
                    matrix[i][j] += Math.min(matrix[i+1][j-1], Math.min(matrix[i+1][j] , matrix[i+1][j+ 1]));

                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j=0; j < n; j++) {
            min = Math.min(min, matrix[0][j]);
        }
        return min;


    }
}