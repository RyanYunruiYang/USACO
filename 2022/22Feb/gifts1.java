import java.util.*;
import java.io.*;
import java.lang.Math;

public class gifts1 {
	public static void main(String[] args) throws FileNotFoundException{
		// Scanner console = new Scanner(new File("1.in"));
		Scanner console = new Scanner(System.in);

		int n = console.nextInt();
		int[][] pref = new int[n][n];

		for (int i=0;i<n ;i++ ) {
			for (int j=0;j<n ;j++ ) {
				pref[i][j] = console.nextInt()-1;
			}
		}


		int[][] graph = new int[n][n];

		int bignumber = 100000;
		for (int i=0;i<n ;i++ ) {
			boolean bool = true;
			for (int j=0;j<n ;j++ ) {
				if(bool) {
					graph[i][pref[i][j]] = 1;					
				}
				else {
					graph[i][pref[i][j]] = bignumber;					
				}
				if (pref[i][j]==i) {
					bool = false;
					graph[i][pref[i][j]] = 0;					
				}
			}

		}
		int[][] costmatrix = new int[n][n];
		for (int i=0;i<n ;i++ ) {
			for (int j=0;j<n ;j++ ) {
				// System.out.print(graph[i][j] + " ");
				costmatrix[i][j] = graph[i][j];
			}
			// System.out.println();
		}

		// int[][] existsPath = new int[n][n];

		for (int k=0;k<n ;k++ ) {
			for (int i=0;i<n ;i++ ) {
				for (int j=0;j<n ;j++ ) {
					if(costmatrix[i][k] + costmatrix[k][j] < costmatrix[i][j]) {
						costmatrix[i][j] = costmatrix[i][k] + costmatrix[k][j];
					}
				}
			}
		}
		
		// System.out.println();
		// for (int i=0;i<n ;i++ ) {
		// 	for (int j=0;j<n ;j++ ) {
		// 		System.out.print(costmatrix[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

		for (int i=0;i<n ;i++ ) {
			for (int j=0;j<n ;j++ ) {
				if(costmatrix[pref[i][j]][i] <bignumber ) {
					System.out.println(pref[i][j]+1);
					break;
				}
			}
		}



		//Observation 1: if everyone prefers i to j, then the person holding j can't get i
		//Unfortunately, the converse is not true b/c of losers

		//Observation 2: Each permutation can be written in cycle notation as a bunch of cycles. But since we
		//only care about one cow at a time, it suffices to find all cycles. 





	}
}