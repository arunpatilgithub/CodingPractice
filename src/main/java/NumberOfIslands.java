public class NumberOfIslands {


    public static void main(String[] args) {

        char input[][] = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(input));
    }

    private static int numIslands(char[][] grid) {

        boolean[][] markerGrid = new boolean[grid.length][grid[0].length];

        int numIslands = 0;

        for (int row=0; row<grid.length; row++) {
            for (int column=0; column<grid[0].length; column++) {

                if (grid[row][column] == '1' && markerGrid[row][column] == false) {
                    numIslands ++;
                    dfs(markerGrid, grid, row, column);
                }
            }
        }

        return numIslands;
    }

    private static void dfs(boolean[][] markerGrid, char[][] grid, int row, int column) {

        if (row < 0 || column < 0 || row > grid.length || column > grid[0].length || markerGrid[row][column] == true || grid[row][column] == '0') {
            return;
        }
        markerGrid[row][column] = true;
        dfs(markerGrid, grid, row - 1 , column);
        dfs(markerGrid, grid, row + 1 , column);
        dfs(markerGrid, grid, row, column + 1);
        dfs(markerGrid, grid, row, column - 1);
    }

}
