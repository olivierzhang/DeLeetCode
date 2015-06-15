import java.util.ArrayList;
import java.util.List;

public class N73_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for(int i =0; i< matrix.length; i++) {
            for(int j =0; j< matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int x : row) {
            for(int j = 0; j< matrix[0].length; j++) {
                matrix[x][j] = 0;
            }
        }
        for(int y : col) {
            for(int i = 0; i< matrix.length; i++) {
                matrix[i][y] = 0;
            }
        }
    }
}
