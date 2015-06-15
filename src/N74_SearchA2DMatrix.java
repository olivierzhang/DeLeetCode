public class N74_SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0]) return false;
        for(int i = 1; i< matrix.length; i++) {
            if(matrix[i][0] > target) {
                for(int j = matrix[0].length -1 ; j>=0; j--) {
                    if (target== matrix[i-1][j]) {
                        return true;
                    }
                }
            }
        }
        for(int j = matrix[0].length -1 ; j>=0; j--) {
            if (target== matrix[matrix.length - 1][j]) {
                return true;
            }
        }
        return false;
    }
}
