import java.util.*;


public class mazetactoe {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		int N = console.nextInt();

		int[][] board = new int[N][N];

		for (int a=0;a<N ;a++ ) {
			String s = console.nextLine();

			for (int b=0;b<N ;b++ ) {
				board[a][b] = read(s.substring(3*b,3*b+3));
			}	
		}

		for (int a=0;a<N ;a++ ) {

			for (int b=0;b<N ;b++ ) {

			}	
		}	

	}

	public static int read(String input) {
		if (input == "###") {
			return -1;
		}
		else{ 
			if (input == "...") {
				return 0;
			}

			else {
				if (input.substring(0,1).equals('M')) {
					return 100 + Integer.parseInt(input.substring(1,3));
				}
				else {
					return Integer.parseInt(input.substring(1,3));
				}
			}
		}

	}
}