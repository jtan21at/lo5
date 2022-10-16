import java.util.ArrayList;
import java.util.List;
public class SymbolGrid {
    private static char[] SYMBOLS = {'~', '!', '@', '#', '$', '^', '&', '*'};
    // NOTE:
//   Do not change this method signature.
//   This is method calls another recursive method, but it should
//   not call itself.
    public static void findAllPaths(char[][] grid, char[] sequence) {
// TO DO:
//     Add code to traverse the grid and search for paths
//     starting at each cell using the findPathsAt() method.
//
//      Cell
        list <Cell> mypath=new ArrayList<Cell>();
        for (int i=0;i< grid.length;i++){
            for (int j=0;i<grid[i].length;j++){
                int index=0;

                for (int k=0;i< sequence.length;j++)
                     {if (grid[i][j]==sequence[k]){
                         Cell mycell=new Cell(i,j);
                         sequence[k]=0;
                         mypath.add(mycell);
                         findPathsAt(grid,mycel,mypath,index+1);

                     }

                }

            }
        };
        System.out.println("\n--- finished searching");
    }
    // TO DO:
//     Implement recursive method with backtracking
//
//     NOTE: You may change the list of parameters here
    private static void findPathsAt(char[][] grid, Cell cell, List<Cell> path, char[] sequence, int index) {
        if
        for (int k=0;k< sequence.length;k++){
        if (grid[cell.r][cell.c]==sequence[k]{

          Cell mycell=new Cell(i,j);
                         sequence[k]=index+1;
                         mypath.add(mycell);

        findPathsAt(char[][] grid, mycell,  path,  sequence,  index+1) ;
        }

        }
         if (index == path.length) {
            System.out.println(path);
            return;
        }
         int r=i;
         int c=j;
         int max_c=grid[r].length;
         int max_r=grid.length;
        if (r-1< grid.length&&r-1>0&&c>0&&c<max_c)
        findPathsAt(grid, new Cell(cell.r - 1, cell.c), path, sequence, index + 1);
        if (r+1< grid.length&&r-1>0&&c>0&&c<max_c)
        findPathsAt(grid, new Cell(cell.r + 1, cell.c), path, sequence, index + 1);

        if(r>0&&r<max_c&&c-1>0&&c-1<max_c)
        findPathsAt(grid, new Cell(cell.r, cell.c - 1), path, sequence, index + 1);
        if(r>0&&r<max_c&&c+1>0&&c+1<max_c)
        findPathsAt(grid, new Cell(cell.r, cell.c + 1), path, sequence, index + 1);
        if(r+1>0&&r+1<max_c&&c+1>0&&c+1<max_c)
        findPathsAt(grid, new Cell(cell.r+1, cell.c + 1), path, sequence, index + 1);
        if(r-1>0&&r-1<max_c&&c-1>0&&c-1<max_c)
            findPathsAt(grid, new Cell(cell.r-1, cell.c - 1), path, sequence, index + 1);
        if(r-1>0&&r-1<max_c&&c+1>0&&c+1<max_c)
            findPathsAt(grid, new Cell(cell.r-1, cell.c + 1), path, sequence, index + 1);
        if(r+1>0&&r+1<max_c&&c-1>0&&c-1<max_c)
            findPathsAt(grid, new Cell(cell.r+1, cell.c - 1), path, sequence, index + 1);
        path.remove(path.size() - 1); // backtrack


    }
    public static void main(String[] args) {
        char[][] grid = randomSymbolGrid(7);
        displaySymbolGrid(grid);
        System.out.println();
        char[] seq = randomSymbolSequence(4);
        System.out.print("sequence: ");
        System.out.println(seq);
        System.out.println("\npaths:");
        findAllPaths(grid, seq);
    }
    /* Helper methods below -- you shouldn't need to alter them */
    private static char[] randomSymbolSequence(int length) {
        char[] sequence = new char[length];
        for(int i = 0; i < length; i++) {
            sequence[i] = SYMBOLS[(int)(Math.random()*SYMBOLS.length)];
        }
        return sequence;
    }
    private static char[][] randomSymbolGrid(int size) {
        char[][] grid = new char[size][size];
        for(int r = 0; r < size; r++) {
            grid[r] = randomSymbolSequence(size);
        }
        return grid;
    }
    private static void displaySymbolGrid(char[][] grid) {
// Display column indices
        System.out.print("\n    ");
        for(int i = 0; i < grid.length; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
// Display grid
        for(int r = 0; r < grid.length; r++) {
// Display row index
            System.out.print("  " + r + " ");
            for(int c = 0; c < grid[r].length; c++) {
                System.out.print(grid[r][c] + "  ");
            }
            System.out.println();
        }
    }
}
/* Represents a cell on a grid -- just a convenient way of
 * packaging a pair of indices  */
class Cell {
    int r, c;

    Cell(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        Cell cell = (Cell) o;
        return this.r == cell.r && this.c == cell.c;
    }

    @Override
    public String toString() {
        return "(" + r + ", " + c + ")";
    }
}