import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;
// import java.io.*;
// import java.util.*;

public class COWoperation {
	public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        // Scanner console = new Scanner(System.in);
		
		String s = console.readLine();
		int[] c = new int[s.length()+1];
		int[] o = new int[s.length()+1];
		int[] w = new int[s.length()+1];
 		int value = 0;
 		// while((value = console.read()) != -1) {
   //          // converts int to character
   //          char c = (char)value;
   //          // prints character
   //          System.out.println(c);
   //      }


		for (int i=0;i<s.length() ;i++ ) {
			// System.out.println(s.charAt(i));
			c[i+1] = c[i];
			o[i+1] = o[i];
			w[i+1] = w[i];
			if(s.charAt(i) == 'C') {
				c[i+1]+=1;
			}
			if(s.charAt(i) == 'O') {
				o[i+1]+=1;
			}
			if(s.charAt(i) == 'W') {
				w[i+1]+=1;
			}		
		}
		// int q = console.nextInt();
        int q = Integer.parseInt(console.readLine());		

		// for (int i=0;i<s.length()+1 ;i++ ) {
		// 	System.out.print(c[i]);
		// }
		// System.out.println();
		// for (int i=0;i<s.length()+1 ;i++ ) {
		// 	System.out.print(o[i]);
		// }
		// System.out.println();
		// for (int i=0;i<s.length()+1 ;i++ ) {
		// 	System.out.print(w[i]);
		// }
		// System.out.println();

		for (int i=0 ;i<q; i++ ) {
            StringTokenizer tokenizer = new StringTokenizer(console.readLine());
            // String line = console.readLine();
            // String[] words = line.split(" ");
			int l =	Integer.parseInt(tokenizer.nextToken());
			int r = Integer.parseInt(tokenizer.nextToken());

			int cmod = (c[r]-c[l-1]) % 2;	
			int omod = (o[r]-o[l-1]) % 2;				
			int wmod = (w[r]-w[l-1]) % 2;	
			// System.out.println("cmod: " + cmod);												
			// System.out.println("omod: " + omod);
			// System.out.println("wmod: " + wmod);

			boolean type1 = ((cmod==1) && (omod==0) && (wmod==0));
			boolean type2 = ((cmod==0) && (omod==1) && (wmod==1));			
			if (type1 || type2) {
				System.out.print('Y');
			}
			else {
				System.out.print('N');
			}

		}
		System.out.println();


		//works if C odd, O,W even or C even, O,W odd
		// //to calculate all Q queries easily, we prefix sum
	}
}