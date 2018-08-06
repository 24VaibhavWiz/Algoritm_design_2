public class pro3
{

    private static final int SIZE = 9;
    private static int[][] matrix = {
        {6,5,0,8,7,3,0,9,0},
        {0,0,3,2,5,0,0,0,8},
        {9,8,0,1,0,4,3,5,7},
        {1,0,5,0,0,0,0,0,0},
        {4,0,0,0,0,0,0,0,2},
        {0,0,0,0,0,0,5,0,3},
        {5,7,8,3,0,1,0,2,6},
        {2,0,0,0,4,8,9,0,0},
        {0,9,0,6,2,5,0,8,1}
    };

    private static void printSudoku()
    {
        for(int i=0;i<SIZE;i++)
        {
            for(int j=0;j<SIZE;j++)
            {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
    private static int[] numberUnassigned(int row, int col)
    {
        int numunassign = 0;
        for(int i=0;i<SIZE;i++)
        {
            for(int j=0;j<SIZE;j++)
            {
                if(matrix[i][j] == 0)
                {
                    row = i;
                    col = j;
                    numunassign = 1;
                    int[] a = {numunassign, row, col};
                    return a;
                }
            }
        }
        int[] a = {numunassign, -1, -1};
        return a;
    }
    private static boolean isSafe(int n, int r, int c)
    {
        for(int i=0;i<SIZE;i++)
        {
            if(matrix[r][i] == n)
                return false;
        }
        for(int i=0;i<SIZE;i++)
        {
            if(matrix[i][c] == n)
                return false;
        }
        int row_start = (r/3)*3;
        int col_start = (c/3)*3;
        for(int i=row_start;i<row_start+3;i++)
        {
            for(int j=col_start;j<col_start+3;j++)
            {
                if(matrix[i][j]==n)
                    return false;
            }
        }
        return true;
    }
    private static boolean solveSudoku()
    {
        int row=0;
        int col=0;
        int[] a = numberUnassigned(row, col);
        if(a[0] == 0)
            return true;
        row = a[1];
        col = a[2];
        for(int i=1;i<=SIZE;i++)
        {
            if(isSafe(i, row, col))
            {
                matrix[row][col] = i;
                if(solveSudoku())
                    return true;
                matrix[row][col]=0;
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        if (solveSudoku())
            printSudoku();
        else
            System.out.println("No solution");
    }
}