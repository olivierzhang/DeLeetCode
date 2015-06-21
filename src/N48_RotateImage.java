/**
 *
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 *
 * Follow up:
 * Could you do this in-place?
 */

public class N48_RotateImage {

    public void rotate(int[][] matrix) {
        for (int x = 0; x < matrix.length / 2; x++) {
            for (int y = 0; y < matrix.length; y++) {
                int tmp = matrix[x][y];
                matrix[x][y] = matrix[matrix.length - 1 - x][y];
                matrix[matrix.length - 1 - x][y] = tmp;
            }
        }
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < x; y++) {
                int tmp = matrix[x][y];
                matrix[x][y] = matrix[y][x];
                matrix[y][x] = tmp;
            }
        }
    }
}
