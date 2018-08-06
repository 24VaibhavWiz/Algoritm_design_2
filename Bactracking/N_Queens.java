public class pro1 {
	final int N =4;
	void print_sol(int board[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(" " + board[i][j] + " ");
			}
			System.out.println();
		}
	}
	boolean is_safe(int board[][],int row ,int col) {
		int i,j;
		    for (i = 0;  i< col; i++) 
		    	if(board[row][i]==1) 
				return false;
			for (i=row, j= col;  j>= 0 && i>=0; j--, i--) 
				if(board[i][j]==1) 
					return false;
			for (i=row, j= col;  j>= 0 && i<N; j--, i++) 
				if(board[i][j]==1) 
					return false;
		return true;
	}
	boolean solve_nqtil(int board[][],int col) {
		if(col>=N)
			return true;
		for (int i = 0; i < N; i++) {
			if(is_safe(board, i, col)) {
				board[i][col]=1;
				if (solve_nqtil(board, col +1)==true)
					return true;
				board[i][col]=0;
			}
		}
		return false;
	}
	boolean solve_nq() {
		int board[][] = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		if(solve_nqtil(board, 0)==false)
		{
			System.err.println("Solution dose not exist");
			return false;
		}
			print_sol(board);
			return true;
	}
	public static void main(String[]args) {
		pro1 Queen = new pro1();
		Queen.solve_nq();
	}
}