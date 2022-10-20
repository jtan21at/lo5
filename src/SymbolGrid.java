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
        List <Cell> mypath=new ArrayList<Cell>();
        int index=0;
        int mark_path=0;
        char temp=0;

        for (int i=0;i< grid.length;i++) {
//            if (index==4) break;
            for (int j = 0; j < grid[i].length; j++) {

//
//                if (grid[i][j] == sequence[index]) {
//                    index = 0;
//                    Cell mycell = new Cell(i, j);
//                    temp = sequence[index];
//                    sequence[index] = 0;
//                    mypath.add(mycell);
//
//                    findPathsAt(grid, mycell, mypath, sequence, index + 1);
//                    sequence[index] = temp;
//
//                }

//                temp = sequence[mark_path];
                for (int k=0;k< sequence.length;k++)
                     {if (grid[i][j]==sequence[k]){
                         Cell mycell=new Cell(i,j);
                         index=0;
//                         temp=sequence[k];
//                         sequence[k]=0;
//                         mark_path=k;
//
//                         mypath.add(mycell);

                         findPathsAt(grid,mycell,mypath,sequence,index);
//                         sequence[mark_path]=temp;

                     }
//
//               }
//                if (index>3) break;

            }
//            if (index>3) break;
//        }
        }}
        System.out.println("\n--- finished searching");
    }

    // TO DO:
//     Implement recursive method with backtracking
//
//     NOTE: You may change the list of parameters here
    private static void findPathsAt(char[][] grid, Cell cell, List<Cell> path, char[] sequence, int index) {

        int mark = 0;
        char temp = 0; if(path.contains(cell))return;
        for (int k=0;k< sequence.length;k++) {

            if (grid[cell.r][cell.c] == sequence[k]) {

                Cell mycell = new Cell(cell.r, cell.c);
                if (!path.contains(mycell)) path.add(mycell);
                else {
                    return;
                }
                if (index > 3) {
                    System.out.println("find one");
                    for (Cell c:path) System.out.print(c);
                    System.out.println();
                    path.remove(index-1);
                }
                temp = sequence[k];
                mark = k;
                sequence[k] = 0;
                index++;
                //temporary remove the element
//                if(path.contains(mycell))return;

//
//                if (index > 2) {
//                    System.out.println("find one");
//                    for (Cell c : path) System.out.print(c);
//                    System.out.println();
//                    path.remove(index);
//
//                    sequence[mark] = temp;
////
//////            System.exit(index);
//                    return;
//                }


//        if (grid[cell.r][cell.c] == sequence[index]) {
//
//            Cell mycell = new Cell(cell.r, cell.c);
////         temp = sequence[k];
////         mark = k;
////         sequence[k] = 0;
//            path.add(mycell);
//        }else return;

//        System.out.println(index);


//        findPathsAt(char[][] grid, mycell,  path,  sequence,  index+1) ;
//        }
//
//        }
//                if (index > 3) {
//                    System.out.println("find one");
//                    for (Cell c : path) System.out.print(c);
//                    System.out.println();
//
////            System.exit(index);
//                    return;
//                }


                int r = cell.r;
                int c = cell.c;
                int max_c = grid[r].length;
                int max_r = grid.length;
                int p_r = path.get(index-1).r;
                int p_c = path.get(index-1).c;
                if (r - 1 < grid.length && r - 1 >= 0 && c > 0 && c < max_c && (r - 1 != p_r || c != p_c))
                    findPathsAt(grid, new Cell(cell.r - 1, cell.c), path, sequence, index + 1);//1
                if (r + 1 < grid.length && r + 1 >= 0 && c > 0 && c < max_c && (r + 1 != p_r || c != p_c))
                    findPathsAt(grid, new Cell(cell.r + 1, cell.c), path, sequence, index + 1);//2

                if (r >= 0 && r < max_r && c - 1 >= 0 && c - 1 < max_c && (r != p_r || c - 1 != p_c))
                    findPathsAt(grid, new Cell(cell.r, cell.c - 1), path, sequence, index + 1);//3
                if (r >= 0 && r < max_r && c + 1 >= 0 && c + 1 < max_c && (r != p_r || c + 1 != p_c))
                    findPathsAt(grid, new Cell(cell.r, cell.c + 1), path, sequence, index + 1);//4
                if (r + 1 >= 0 && r + 1 < max_r && c + 1 >= 0 && c + 1 < max_c && (r + 1 != p_r || c + 1 != p_c))
                    findPathsAt(grid, new Cell(cell.r + 1, cell.c + 1), path, sequence, index + 1);//5
                if (r - 1 >= 0 && r - 1 < max_r && c - 1 >= 0 && c - 1 < max_c && (r - 1 != p_r || c - 1 != p_c))
                    findPathsAt(grid, new Cell(cell.r - 1, cell.c - 1), path, sequence, index + 1);//6
                if (r - 1 >= 0 && r - 1 < max_r && c + 1 >= 0 && c + 1 < max_c && (r - 1 != p_r || c + 1 != p_c))
                    findPathsAt(grid, new Cell(cell.r - 1, cell.c + 1), path, sequence, index + 1);//7
                if (r + 1 >= 0 && r + 1 < max_r && c - 1 >= 0 && c - 1 < max_c && (r + 1 != p_r || c - 1 != p_c))
                    findPathsAt(grid, new Cell(cell.r + 1, cell.c - 1), path, sequence, index + 1);//8
                path.remove(index-1);


            sequence[mark] = temp; return;
            }}// backtrack
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