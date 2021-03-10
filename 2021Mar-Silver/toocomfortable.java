import java.util.*;
public class toocomfortable {
	
	public static boolean[][] board = new boolean[3000][3000];
	public static int[][]neighbors = new int[3000][3000];
	public static int boardSize;

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int N = console.nextInt();

		boardSize = 0;

		for (int i =1;i<N+1 ;i++ ) {
			int newX = console.nextInt()+1000;
			int newY = console.nextInt()+1000;

			// if (board[newX][newY] == false){
			// 	board[newX][newY] = true;
			// 	boardSize+=1;
			// }

			recursion(newX,newY);


			System.out.println(boardSize - i);
			//printBoard();
		}
		
	}
	public static void printBoard(){
		int x = 4;
		for (int i=1000-x;i< 1000+2*x ;i++ ) {
			for (int j = 1000-x;j<1000+2*x ;j++ ) {
				System.out.print(toInt(board[i][j]) + " ");			
			}
			System.out.println();		
		}		
	}

	public static boolean recursion(int x,int y) {
		if (board[x][y]) {
			return true;
		}
		else {
			board[x][y] = true;
			boardSize +=1;
			neighbors[x-1][y]++;
			neighbors[x+1][y]++;
			neighbors[x][y-1]++;
			neighbors[x][y+1]++;

			adjacencyCheck(x,y);
			adjacencyCheck(x-1,y);
			adjacencyCheck(x+1,y);
			adjacencyCheck(x,y-1);
			adjacencyCheck(x,y+1);

			return false;			
		}

	}
	public static int toInt(boolean val) {
		if (val) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public static boolean adjacencyCheck(int x,int y){
		if (board[x][y]) {
			// int adjacent = toInt(board[x-1][y])+toInt(board[x+1][y])+toInt(board[x][y-1])+toInt(board[x][y+1]);
			if (neighbors[x][y] == 3) {

				if (!board[x-1][y]){
					recursion(x-1,y);
				}

				if (!board[x+1][y]){
					recursion(x+1,y);				
				}

				if (!board[x][y-1]){
					recursion(x,y-1);				
				}

				if (!board[x][y+1]){
					recursion(x,y+1);				
				}

				return true;
			}
			else {
				return false;
			}
		}
		else {
			return true;
		}
	}
}