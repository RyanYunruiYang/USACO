import java.util.*;

public class restaurantcustomer {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		int n = console.nextInt();
		// int[] aList = new int[n];
		// Integer[] bList = new Integer[n];

		// for (int i=0;i<n ;i++ ) {
		// 	aList[i] = console.nextInt();
		// 	bList[i] = console.nextInt();			
		// }	

		// Arrays.sort(aList);
		// Arrays.sort(bList, Collections.reverseOrder());


		// int k = 0;
		// while(aList[k] < bList[k]) {
		// 	k+=1;
		// }


		// System.out.println(k);	
		Transfer[] transferList = new Transfer[2*n];

		for (int i=0;i <n ;i++ ) {
			transferList[i] = new Transfer(console.nextInt(),1);
			transferList[n+i] = new Transfer(console.nextInt(),-1);
		}

		Arrays.sort(transferList);

		int customers = 0;
		int max = 0;
		int arrivals = 0;
		for (Transfer t : transferList) {
			//System.out.println(t);
			int x = t.change;
			customers += x;

			if (x == 1) {
				arrivals +=1;
			}


			if (customers > max){
				max = customers;
			}
			
			if (arrivals == n) {
				break;
			}			
		}


		System.out.println(max);


	
	}
}

class Transfer implements Comparable<Transfer>{
	public int time, change;


	public Transfer(int time, int change) {
		this.time = time;
		this.change = change;
	}

	public String toString() {
		return ("time: " + time + "change:" + change);
	}
	public int compareTo(Transfer t) {
		return time-t.time;
	}
}