import java.lang.*;
import java.util.Scanner;
import java.io.*; 
import java.util.List; 
import java.util.ArrayList; 
public class b_NumbersBox

{
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int t = console.nextInt();
		//System.out.println("t: "+t);

		int n;
		int m;
		for (int i = 0; i < t ;i++ ) {
			//System.out.println("iteration: " + i);
			n= console.nextInt();
			m = console.nextInt();
			//System.out.printf("m,n): %d, %d \n",m,n);



		    int num_negatives = 0;
		    boolean has_zero = false;
        	List<Integer> values = new ArrayList<Integer>(); 

        	int smallest = 1000;
			for (int k =0;k < n ;k++ ) {
				for (int j = 0; j< m ;j++ ) {
					//System.out.printf("k,j): %d, %d \n",k,j);
					int add_entry = console.nextInt();
					if (Math.abs(add_entry) < smallest) {
						smallest = Math.abs(add_entry);
					}

					if (add_entry < 0) {
						num_negatives++;
					}
					else if (add_entry ==0) {
						has_zero = true;
					}

					values.add(add_entry);							
				}	
			}

        	List<Integer> values2 = new ArrayList<Integer>(); 

			for (int k =0;k < values.size() ;k++ ) {
				values2.add(Math.abs(values.get(k)));
			}
        	//System.out.println(values2);

			int totalSum = 0;
			for (int k =0;k < values2.size() ;k++ ) {
				totalSum += values2.get(k);
			}

			if (has_zero || (num_negatives % 2 ==0)) {
				//System.out.println("entered all positives");
				System.out.println(totalSum);
			}
			else {				
				System.out.println(totalSum - 2*smallest);
			}


		}
	}
}
