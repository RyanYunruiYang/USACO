import java.io.*;
import java.util.*;


public class wdtcctr2 {
	public static void main(String[] args) throws FileNotFoundException,IOException {
		Scanner console = new Scanner(new File("circlecross.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));
		
		String input = console.next();//sample: ABCCABDDEEFFGGHHIIJJKKLLMMNNOOPPQQRRSSTTUUVVWWXXYYZZ
		int n =26;
		int[] first = new int[n];
		int[] second = new int[n];

		for (int i=0;i<52 ;i++ ) {
			int x=input.charAt(i)-'A';//A: x=0. 
			if(first[x]==0){
				first[x] = i+1;
			}
			else {//then we must have first[x]>0
				second[x] = i+1;
			}
		}

		int count = 0;
		for (int i=0;i<26 ;i++ ) {
			for (int j=0;j<26 ;j++ ) {// IJIJ
				if (((first[i]<first[j])&&(first[j]<second[i])&&(second[i]<second[j]))){
					count++;
				}
			}
		}//count is counting the number of pairs (A,B) such that ABAB appears

		//(A,B) is a crossing pair if either ABAB or BABA
		System.out.println(count);
		out.println(count);
		out.close();


	}
}