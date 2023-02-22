import java.io.*;
import java.util.*;
import java.lang.*;

public class milkvisits {
	public static void buildFrom(int a, int cameFrom, int original) {
		// System.out.println("a: "+ a + ", adj[a]: " +adj[a] +", original: "+ original);
		for (int i=0;i< adj[a].size() ;i++ ) {
			int x = adj[a].get(i);
			if(x != cameFrom) {
				if(isHolstein[x]) {
					holstein[x][original] = 1;
				}
				else {
					holstein[x][original] = holstein[a][original];//0: no, 1: yes
				}
				// System.out.println("x: " + x);
				// printHolstein();

				buildFrom(x, a, original);	
			}

		}//buildGuernsey
	}
	public static void buildGuernsey(int a, int cameFrom, int original) {
		for (int i=0;i< adj[a].size() ;i++ ) {
			int x = adj[a].get(i);
			if(x != cameFrom) {
				if(!isHolstein[x]) {
					guernsey[x][original] = 1;
				}
				else {
					guernsey[x][original] = guernsey[a][original];//0: no, 1: yes
				}
				buildGuernsey(x, a, original);	
			}
		}
	}	
	public static void printHolstein() {
		for (int i=0;i<n ;i++ ) {
			for (int j=0;j<n ;j++ ) {
				if(holstein[i][j]==-1){
					System.out.print(" "+ holstein[i][j]);
				}
				else {
					System.out.print("  "+holstein[i][j]);
				}
			}
			System.out.println();
		}		
	}
	public static void printGuernsey() {
		for (int i=0;i<n ;i++ ) {
			for (int j=0;j<n ;j++ ) {
				if(guernsey[i][j]==-1){
					System.out.print(" "+ guernsey[i][j]);
				}
				else {
					System.out.print("  "+guernsey[i][j]);
				}
			}
			System.out.println();
		}		
	}	
	static ArrayList<Integer>[] adj; // adjacency list	
	static boolean[] isHolstein;
	static int[][] holstein ;
	static int[][] guernsey ;
	static int n;
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner console = new Scanner(new File("milkvisits.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));

		n = console.nextInt();
		int m = console.nextInt();

		String s = console.next();

		isHolstein = new boolean[n];
		holstein = new int[n][n];
		guernsey = new int[n][n];		

		for (int i=0;i<n ;i++ ) {
			// System.out.println(s.charAt(i));
			isHolstein[i]=false;
			if(s.charAt(i)=='H'){
				isHolstein[i] = true;
			}
			// System.out.print(isHolstein[i]);
		}
		adj = new ArrayList[n]; // adjacency list
		for(int i = 0; i < n; i++){
			adj[i] = new ArrayList<Integer>(); // initializes the ArrayLists
		}

		for (int i=0;i<n-1 ;i++ ) {
			int a = console.nextInt()-1;//0-indexing everything
			int b = console.nextInt()-1;
			adj[a].add(b);
			adj[b].add(a);
		}
		for (int i=0;i<n ;i++ ) {
			for (int j=0;j<n ;j++ ) {
				holstein[i][j]=-1;
				guernsey[i][j]=-1;
			}
		}
		for (int i=0;i<n ;i++ ) {
			if(isHolstein[i]) {
				holstein[i][i] = 1;
				guernsey[i][i]=0;
			}
			else {
				guernsey[i][i] = 1;
				holstein[i][i] = 0;
			}
		} //holstein[i][j] tells you whether the path from i to j contains a holstein cow
		//-1 is no data yet, 0 is no, and 1 is yes.

		for (int i=0;i<n ;i++ ) {
			buildFrom(i, i, i);
			buildGuernsey(i,i,i);
			// printHolstein();
		}

		for (int i=0;i<m ;i++ ) {
			int a = console.nextInt();
			int b = console.nextInt();
			String type = console.next();
			if (type.equals("G")) {
				System.out.print(guernsey[a-1][b-1]);
				out.print(guernsey[a-1][b-1]);
			}
			else {
				System.out.print(holstein[a-1][b-1]);
				out.print(holstein[a-1][b-1]);				
			}
		}
		System.out.println();
		out.close();

		// System.out.println();

		// printHolstein();
		// System.out.println();
		// printGuernsey();




	}
}

























