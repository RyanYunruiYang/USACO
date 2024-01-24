import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;
// import java.io.*;
// import java.util.*;

public class subseteq {
	public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String s = console.readLine();
        String t = console.readLine();

        boolean[][] ordered = new boolean[18][18];

        for (int a=0;a<18 ;a++ ) {
        	for (int b=0; b<18 ;b++ ) {
	    		char c1 = (char) (97+a);
	    		char c2 = (char) (97+b);

		        char[] ssub = new char[s.length()];
		        int x = 0;
		        for (int i=0;i<s.length() ;i++ ) {
		        	char c = s.charAt(i);
		        	if((c == c1)|| (c==c2)) {
		        		ssub[x] = c;
		        		x++;
		        	}
		        }
		        char[] tsub = new char[t.length()];
		        int y = 0;
		        for (int i=0;i<t.length() ;i++ ) {
		        	char c = t.charAt(i);
		        	if((c == c1)|| (c==c2)) {
		        		tsub[y] = c;
		        		y++;
		        	}
		        }  

		        boolean equal = true;
		        if(x!=y){
		        	equal = false;
		        }
		        else {
			        for (int i=0;i<x; i++ ) {
			        	// System.out.println(i + ": " + ssub[i]);
			        	// System.out.println(i+ ": "+ tsub[i]);
			        	if(ssub[i] != tsub[i]){
			        		equal = false;
			        	}
			        }		        	
		        }

		        ordered[a][b] = equal;
        	}
        }

        // for (int a=0;a<18 ;a++ ) {
        // 	for (int b=0;b<18 ;b++ ) {
        // 		System.out.print(ordered[a][b] + " ");
        // 	}
        // 	System.out.println();
        // }

        int q = Integer.parseInt(console.readLine());		

        for (int o=0;o<q ;o++ ) {
        	String inp = console.readLine();

        	boolean equal = true;
        	for (int i=0;i<inp.length() ;i++ ) {
        		for (int j=0;j<inp.length() ;j++ ) {
        			int c1 = ((int) inp.charAt(i)) - 97;
        			int c2 = ((int) inp.charAt(j)) - 97;

        			equal = equal && ordered[c1][c2];
        		}
        	}
        	if(equal){
	        	System.out.print('Y');
        	}
        	else {
        		System.out.print('N');
        	}
        }
        System.out.println();
    }
}
        // for (int i=0;i<ssub.length ;i++ ) {
        // 	ssub[i] = 'A';
        // 	System.out.print(ssub[i]);
        // }
        // System.out.println();