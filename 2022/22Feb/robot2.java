import java.util.*;
import java.io.*;
import java.lang.Math;

public class robot2 {
	public static void main(String[] args) throws FileNotFoundException{
		// Scanner console = new Scanner(new File("2.in"));
		Scanner console = new Scanner(System.in);

		int n = console.nextInt();
		int xg = console.nextInt();
		int yg = console.nextInt();

		int[] x = new int[n];
		int[] y = new int[n];
		for (int i=0;i<n ;i++ ) {
			x[i] = console.nextInt();
			y[i] = console.nextInt();
		}

		int[] num_work = new int[n+1];
	


		for (int i=0;i<(1<<n); i++ ) {
			int sumx = 0;
			int sumy = 0;

			// System.out.print("{ ");
			
			if(n<=25) { 
				int k=0;
				for (int j=0;j<n ;j++ ) {
					if((i & (1<<j))>0) {
						// System.out.print(x[j] + " ");
						sumx += x[j];
						sumy += y[j];
						k++;
					}
				}

				// System.out.println(k);
				if(sumx == xg && sumy == yg) {
					num_work[k]++;
				}
			
				// System.out.println("}");
			}
		}
		for (int i=1;i<=n ;i++ ) {
			System.out.println(num_work[i]);
		}

		// int size = 1000000000;
		// int[] tmp = new int[40*size];



	}
}