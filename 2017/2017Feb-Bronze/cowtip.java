import java.io.*;
import java.util.*;

public class cowtip {
	public static void main(String[] args) throws FileNotFoundException,IOException{
		Scanner console = new Scanner(new File("cowtip.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));

		int n = console.nextInt();
		int[][] cows = new int[n][n];
		for (int i=0;i<n ; i++ ) {
			String s = console.next();
			for (int j=0;j<n ;j++ ) {
				cows[i][j] = (int) s.charAt(j)-'0' ;
			}
		}
		int count = 0;
		for (int i=n-1;i>=0 ;i-- ) {
			for (int j=n-1;j>=0 ;j-- ) {
				count += cows[i][j];

				if(cows[i][j]==1) {
					for (int a=0;a<=i ;a++ ) {
						for (int b=0;b<=j ;b++ ) {
							cows[a][b]=1-cows[a][b];
						}
					}
				}
			}
		}

		System.out.println(count);
		out.println(count);
		out.close();
	}
}

		// for (int i=0;i<n ;i++ ) {
		// 	for(int j=0; j<n; j++){
		// 		System.out.print(cows[i][j]);
		// 	}
		// 	System.out.println();
		// }


		// for (int d=0;d<=2*n-2 ;d++ ) {
		// 	for (int i=Math.max(0,d-n+1);i<=Math.min(d,n-1) ;i++ ) {//implied j=d-i
		// 		if (cows[i][d-i]==1) {
		// 			System.out.println(i + " "+ (d-i));
		// 		}
		// 	}
		// }