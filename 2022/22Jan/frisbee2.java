import java.util.*;
import java.io.*;
import java.lang.Math;

public class frisbee2 {
	public static void main(String[] args) throws FileNotFoundException{
		// Scanner console = new Scanner(new File("2.in"));
		Scanner console = new Scanner(System.in);

		int n = console.nextInt();
		int[] a = new int[n];

		for ( int i=0; i<n; i++) {
			a[i]= console.nextInt();
			// System.out.print(a[i]);
		}
		// System.out.println();
		int total=0;
		for (int i=0;i<n ;i++ ) {
			int max = -1;
			for (int j=i+1;j<n ;j++ ) {
				if(Math.min(a[i],a[j])> max){
					total+=(j-i+1);
				}

				if(a[j]>max) {
					max = a[j];
				}
			}
		}
		System.out.println(total);

	}
}