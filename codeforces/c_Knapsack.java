import java.util.Scanner;
import java.lang.*;
import java.util.Scanner;
import java.io.*; 
import java.util.List; 
import java.util.ArrayList;

public class c_Knapsack


{
	public static void main(String[] args) {
		Scanner console = new Scanner("3 1 3 3 6 2 19 8 19 69 9 4 7 12 1 1 1 17 1 1 1");
		int t = console.nextInt();

		int n;
		int w;
		for (int r = 0; r < t ;r++ ) {
			debug("test case: "+r);
			n = console.nextInt();
			w = console.nextInt();
			debug(n+", "+w);

			int k = 0;
			while (Math.pow(2,k) < w)
			{
				k++;
			}

			ArrayList<Integer> boxes[]=new ArrayList[k];


			for (int i =0; i <k ;i++ ) {
		       	boxes[i] = new ArrayList<Integer>(); 
			}

        	double th = Math.log(2);
        	for (int i =0; i<n ;i++ ) {
        		int x = console.nextInt();        		
        		if (x < w) { 
        			int y = (int) (Math.log(w*1.0/x) / th);    		     
        			boxes[y].add(i);//y=floor(log_2(W/x))
        			debug("x: " +x + " _ into box" + y);
        		}
        		if (x == w) {
        			boxes[0].add(i);
        		}

        	}

        	for (int i =0; i <k ;i++ ) {
		       	System.out.println(boxes[i]); 
			}

			double cf = 0; //continued fraction
			boolean success = true;
			int endingIndex = 0;
			int x = 0;
			for (int i =0;i < k ;i++ ) {
				debug("cf: "+cf);
				if (1-cf <= (boxes[i].size()*1.0/Math.pow(2,i))) {
					debug(""+ (cf + boxes[i].size()*1.0/Math.pow(2,i)));
					double f = (1.0-cf)*Math.pow(2,i);
					debug("f: "+f);
					x = (int) (Math.round(f));
					debug("x:"+x);
					endingIndex = i;
					break;
				}
				debug("shit should be happening. i: " + i +"_ " + boxes[i].size()*1.0/Math.pow(2,i) );	
				n += boxes[i].size();
				//debug("boxes[i].size(): "+boxes[i].size());
				cf += boxes[i].size()*1.0/Math.pow(2,i);
				
				if (i == k-1) {
					debug("fail");
					success = false;	
				}
			}

			if (!success) {
				System.out.println(-1);
			}
			else {
				for (int i =0; i <endingIndex ;i++ ) {
		       		for (int j =0;j < boxes[i].size() ;i++ ) {
		       			System.out.print(boxes[i].get(j));
		       		}
				}
				for (int j =0;j < x ;j++ ) {
					System.out.print(boxes[endingIndex].get(j));
				}
				System.out.println();
			}

		}
	}

	public static void debug(String s)
	{
		System.out.println("debug: "+s);
	}


}
