import java.util.*;
public class comfortablecows {
	
	public static int[][] board = new int[3000][3000];
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
			printBoard();
		}
		
	}
	public static void printBoard(){
		int x = 4;
		for (int i=1000-x;i< 1000+2*x ;i++ ) {
			for (int j = 1000-x;j<1000+2*x ;j++ ) {
				System.out.print(board[i][j] + " ");			
			}
			System.out.println();		
		}		
	}

	public static void update(int x,int y) {
		if (board[x][y] != 0){
			board[x][y]++;
			if (board[x][y] == 3) {
				recursion(x,y);
			}
		}		
	}
	public static boolean recursion(int x,int y) {
		if (board[x][y] != 0) {
			return true;
		}
		else {
			board[x][y] = neighbors(x,y);
			if (board[x][y]==0){
				board[x][y] = 1;
			}
			boardSize +=1;

			if (board[x][y] == 3){
				adjacencyCheck(x,y);
			}

			update(x-1,y);
			update(x+1,y);
			update(x,y-1);
			update(x,y+1);


			return false;			
		}

	}

	public static int neighbors(int x, int y) {
		int val = 0;
		if (board[x-1][y] != 0) {
			val++;
		}
		if (board[x+1][y] != 0) {
			val++;
		}
		if (board[x][y-1] != 0) {
			val++;
		}
		if (board[x][y+1] != 0) {
			val++;
		}
		return val;
	}
	public static boolean adjacencyCheck(int x,int y){
		int adjacent = neighbors(x,y);
		if (adjacent == 3) {
			//boardSize += 1;
			if (board[x-1][y] == 0){
				recursion(x-1,y);
			}
			if (board[x+1][y] ==0){
				recursion(x+1,y);				
			}
			if (board[x][y-1] ==0){
				recursion(x,y-1);				
			}
			if (board[x][y+1] ==0){
				recursion(x,y+1);				
			}
			return true;
		}
		else {
			return false;
		}
	}
}