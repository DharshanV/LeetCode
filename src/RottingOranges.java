import java.util.*;

class Pair {
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class RottingOranges {
    public static LinkedList<Pair> getValues(int[][] grid, int[] freshCount) {
        LinkedList<Pair> list = new LinkedList<>();
        int size = grid.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 1) {
                    freshCount[0]++;
                } else if (grid[i][j] == 2) {
                    list.add(new Pair(i, j));
                }
            }
        }
        return list;
    }

    public static boolean inRange(int x, int y, int[][] grid) {
        if ((x < 0) || (x >= grid.length))
            return false;
        if ((y < 0) || (y >= grid.length))
            return false;
        return true;
    }

    public static void makeRotten(Pair rottenPos, int[][] grid) {
        int x = rottenPos.x;
        int y = rottenPos.y;

        if (inRange(x - 1, y, grid)) {
            if (grid[x - 1][y] != 0) grid[x - 1][y] = 2;
        }
        if (inRange(x + 1, y, grid)) {
            if (grid[x + 1][y] != 0) grid[x + 1][y] = 2;
        }
        if (inRange(x, y - 1, grid)) {
            if (grid[x][y - 1] != 0) grid[x][y - 1] = 2;
        }
        if (inRange(x, y + 1, grid)) {
            if (grid[x][y + 1] != 0) grid[x][y + 1] = 2;
        }
    }

    public static int orangesRotting(int[][] grid) {
        int[] freshCount = new int[1];
        LinkedList<Pair> rottens = getValues(grid, freshCount);
        if (freshCount[0] == 0) return 0;
        for (Pair pair : rottens) {
            makeRotten(pair, grid);
        }
        return 1 + orangesRotting(grid);
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid));
    }
}
