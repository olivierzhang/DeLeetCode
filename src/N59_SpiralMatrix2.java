public class N59_SpiralMatrix2 {

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int dir = 1, count = 0, maxCount = n - 1, x = 0, y = 0;
        for (int i = 1; i <= n * n; i++) {
            res[x][y] = i;
            count++;
            if (dir == 1) y++;
            else if (dir == 2) x++;
            else if (dir == 3) y--;
            else if (dir == 4) x--;

            if (count == maxCount) {
                if (dir == 4) {
                    maxCount -= 2;
                    dir = 1;
                    x++;
                    y++;
                } else {
                    dir += 1;
                }
                count = 0;
            }
        }
        return res;
    }
}
