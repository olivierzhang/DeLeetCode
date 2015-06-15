public class N64_MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = { { 1, 2 }, { 1, 1 } };
        minPath(grid);
    }

    private static int minPath(int[][] grid) {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (x == 0 && y == 0) {
                    continue;
                }
                int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
                if (x != 0) {
                    a = grid[x - 1][y];
                }
                if (y != 0) {
                    b = grid[x][y - 1];
                }
                grid[x][y] += Math.min(a, b);
            }
        }
        return grid[grid.length][grid[0].length];
    }
}
