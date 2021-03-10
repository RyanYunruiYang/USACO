/*
ID: y.ryan.1
LANG: JAVA
TASK: pump
*/
import java.util.Arrays; 
import java.util.LinkedList;
import java.io.*;
import java.util.Scanner;
import java.util.Collections;
import java.lang.Math;

class pump
{
	static int N;
	static int M;
	static int[] a;
	static int[] b;
	static int[] c;
	static int[] f;
	static boolean debug = true;
	

	public static void main(String[] args) throws IOException {

	    BufferedReader s = new BufferedReader(new FileReader("pump.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pump.out")));

	    Scanner console = new Scanner(new File("pump.in"));
		
		N = console.nextInt();
		M = console.nextInt();
		a = new int[M];
		b = new int[M];
		c = new int[M];
		f = new int[M];



		for (int i = 0;i < M ;i++ ) {
			a[i] = console.nextInt();
			b[i] = console.nextInt();
			c[i] = console.nextInt();
			f[i] = console.nextInt();
		}
		int[] f_ord = f;
        Arrays.sort(f_ord); 

		double fcr = 0;//flow/cost ratio
		double new_fcr;
		for (int i = M-1; i >= 0; i--) {
			new_fcr = f_ord[i]*1.0/bfsMinCost(f_ord[i]);
			debug("f_ord[i]: "+f_ord[i] + "  cost: " + bfsMinCost(f_ord[i]));
			debug("new_fcr: "+new_fcr);
			if (new_fcr > fcr) {
				fcr = new_fcr;	
			}
		}
		System.out.println(fcr);



		// for (int var : a)
		// {
		// 	out.println(var);
		// }
		// out.close();
	
	}

	public static int bfsMinCost(int flowMax)
	{
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(1);
		debug("hi");

		int recursionLimit = 0;
		while (q.size() != 0 && recursionLimit < Math.pow(N,N))
		{
			debug("fresh start" + q);
			int v = q.removeFirst();
			debug("v: "+v);
			if (v == N)
				return v;

			for (int i = 0 ;i < M ;i++ ) {
				debug("i: "+i);

				if (a[i] == v) {
					debug("found left");
					if (!q.contains(b[i]) && f[i] <= flowMax)
					{

						q.add(b[i]); //label w as discovered
						debug("moved to: "+b[i]);
	//							debug(""+ i);							

					}
				}

				if (b[i] == v) {
					debug("found right");
					if (!q.contains(a[i]) && f[i] <= flowMax)
					{
						q.add(a[i]); //label w as discovered
//						debug(""+ i);
					}
				}

			}
			debug("final q: " + q);
			recursionLimit++;
		}
		return -1;


	}

	public static void debug(String s)
	{
		if (debug) {
			System.out.println("debug: " + s);
		}		
	}


}