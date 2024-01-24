import java.io.*;
import java.util.*;

public class TwoBreedFlip {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		Scanner console = new Scanner(new File("breedflip.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));
		int n = console.nextInt();

		String a = console.next();
		String b = console.next();

		System.out.println(a);
		System.out.println(b);

		int[] flips = new int[n+1];
		flips[0]=0;
		int count = 0;
		for (int i=0;i<n ;i++ ) {
			if (a.charAt(i)!=b.charAt(i)) {
				flips[i+1]=1;
			}
			//if equal, they were defaulted to 0 in line 16
			// System.out.println(flips[i]);
			if(flips[i]==0 && flips[i+1]==1){
				count++;
			}
		}
		System.out.println(count);
		out.println(count);
		out.close();



	}
}