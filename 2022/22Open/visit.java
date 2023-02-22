import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.*;
// import java.io.*;
// import java.util.*;

public class visit {
	public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
 		int n = Integer.parseInt(console.readLine());

 		int[] indeg = new int[n]; //intializing arrays
 		boolean[] deleted = new boolean[n];
 		int[] next = new int[n];
 		long[] v = new long[n];
 		// System.out.println(deleted[0]); returns false

 		long totalreward = 0;
 		for (int i=0;i<n ;i++ ) { //reads in information
			StringTokenizer tokenizer = new StringTokenizer(console.readLine());
			next[i] = Integer.parseInt(tokenizer.nextToken()) - 1;
			indeg[next[i]]++;
			v[i] = Long.parseLong(tokenizer.nextToken());
			totalreward += v[i];
 		}

 		Queue<Integer> lonely = new LinkedList<>(); //vertices with indeg = 0
 		for (int i=0;i<n ;i++ ) {
 			if (indeg[i] == 0) {
 				lonely.add(i);
 			}
 		}
 		// System.out.println(lonely);

 		while(lonely.size() > 0) { //gets rid of free/lonely people.
 			// System.out.println(lonely); 
	 		// for (int i=0;i<n ;i++ ) {
	 		// 	System.out.print(indeg[i] + " ");
	 		// }
	 		// System.out.println(); 	
 			int x = lonely.remove();

 			// totalreward += v[x];
 			deleted[x] = true;
 			indeg[next[x]]--;

 			if((!deleted[next[x]]) && (indeg[next[x]]==0)) {
 				lonely.add(next[x]);
 			}
 		}

 		// for (int i=0;i<n ;i++ ) {
 		// 	System.out.print(deleted[i]);
 		// }
 		// System.out.println();
 		// System.out.println("totalreward: " + totalreward);

 		//now everything's in a set of disjoint cycles.

 		for (int i=0;i<n ;i++ ) {
 			if(deleted[i] == false) { //fuck boolean zen
 				// System.out.println("i: " + i);
 				int x = i;
 				long min = Long.MAX_VALUE;
 				while (next[x] != i) {
 					// System.out.println("x: " + x);
 					if(v[x] < min){
 						min = v[x];
 					}
 					deleted[x] = true;
 					x= next[x];
 					deleted[x] = true;
 				}//exit with next[x] = i.

 				if(v[x] < min){
 					min = v[x];
 				}
 				totalreward -= min; 				
 			}
 		}
 		System.out.println(totalreward);




    }
}