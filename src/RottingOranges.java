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

    public static void north(Pair rottenPos, int[][] grid) {
        if (grid[rottenPos.x][rottenPos.y - 1] != 0) {
            grid[rottenPos.x][rottenPos.y - 1] = 2;
        }
    }

    public static void south(Pair rottenPos, int[][] grid) {
        if (grid[rottenPos.x][rottenPos.y + 1] != 0) {
            grid[rottenPos.x][rottenPos.y + 1] = 2;
        }
    }

    public static void west(Pair rottenPos, int[][] grid) {
        if (grid[rottenPos.x - 1][rottenPos.y] != 0) {
            grid[rottenPos.x - 1][rottenPos.y] = 2;
        }
    }

    public static void east(Pair rottenPos, int[][] grid) {
        if (grid[rottenPos.x + 1][rottenPos.y] != 0) {
            grid[rottenPos.x + 1][rottenPos.y] = 2;
        }
    }

    public static void makeRotten(Pair rottenPos, int[][] grid) {
        int size = grid.length;
        int x = rottenPos.x;
        int y = rottenPos.y;

        if (x - 1 < 0 && y - 1 < 0) {           //top left
            east(rottenPos, grid);
            south(rottenPos, grid);
        } else if (x + 1 >= size && y - 1 < 0) {    //top right
            west(rottenPos, grid);
            south(rottenPos, grid);
        } else if (x - 1 < 0 && y + 1 >= size) {    //bottom left
            north(rottenPos, grid);
            east(rottenPos, grid);
        } else if (x + 1 >= size && y + 1 >= size) { //bottom left
            north(rottenPos, grid);
            west(rottenPos, grid);
        } else {
            north(rottenPos, grid);
            south(rottenPos, grid);
            west(rottenPos, grid);
            east(rottenPos, grid);
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
