//http://www.usaco.org/index.php?page=viewproblem2&cpid=595
// USACO 2016 January Contest, Silver
// Problem 2. Subsequences Summing to Sevens

import java.io.*;
import java.util.*;
import java.lang.*;

public class silver2 {
	public static void main(String[] args) throws FileNotFoundException,IOException {
		Scanner console = new Scanner(new File("div7.in"));

		int n = console.nextInt();

		int[] firstapp = new int[7];
		int[] lastapp = new int[7];
		for (int i=0;i<7 ;i++ ) {
			firstapp[i]=n+1;
			lastapp[i]=-1;
		}

		int sum = 0;
		firstapp[0] = 0;
		for (int i=0;i<n ;i++ ) {
			int next = console.nextInt();
			sum = (sum + next) % 7;

			if(i< firstapp[sum]) {
				firstapp[sum] = i+1;
			}
			if(firstapp[sum]!=-1) {
				lastapp[sum] = i+1;
			}

			System.out.println("i: " + i + " sum: " + sum);
		}
		int max = -1;
		for (int i=0;i<7 ;i++ ) {
			if(firstapp[i]!=n+1 && lastapp[i]!=-1) {
				System.out.println(lastapp[i]-firstapp[i]);
				if(lastapp[i]-firstapp[i] > max){
					max = lastapp[i] - firstapp[i];
				}
			}
			// System.out.println(lastapp[i]);
		}
		System.out.println(max);
		PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
		output.write(""+ max);
		output.close();

	}
}