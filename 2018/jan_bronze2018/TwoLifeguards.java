import java.io.*;
import java.util.*;
import java.lang.*;


public class TwoLifeguards{
	public static void main(String[] args) throws FileNotFoundException, IOException{
		Scanner console = new Scanner(new File("lifeguards.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		int n = console.nextInt();
		int time = 1000;

		int[] left = new int[n];
		int[] right = new int[n];
		for (int i=0;i<n ;i++ ) {
			left[i] = console.nextInt();
			right[i] = console.nextInt();
		}

		int maxcoverage=0;
		for (int i=0;i<n ;i++ ) {//if cow i gets fired?
			int coverage =0;
			for (int t=0;t< time ;t++ ) {
				//t represents the interval [t,t+1]
				boolean covered = false;
				for (int j=0;j<n; j++) {
					if((j!= i)&&(left[j]<=t && t+1<=right[j])){
						covered = true;
					}
				}
				if(covered){
					coverage++;
					// System.out.println("t: "+ t);
				}
			}
			if(coverage> maxcoverage){
				maxcoverage = coverage;
			}
			// System.out.println(coverage);
		}

		System.out.println(maxcoverage);
		out.println(maxcoverage);
		out.close();
	}
}
