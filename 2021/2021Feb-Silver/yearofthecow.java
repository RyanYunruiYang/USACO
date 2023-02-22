import java.util.*;
public class yearofthecow{

	public static void main(String[] args) {
		int size = 100000;

		boolean[] must_visit = new boolean[size];

		Scanner console = new Scanner(System.in);
		int N = console.nextInt();
		int K = console.nextInt()-1;

		int oldest_year = 0;


		for (int i=0;i<N ;i++ ) {
			int year = console.nextInt();
			int x = year/12-1;
			must_visit[x] = true;
			
			if (x>oldest_year) {
				oldest_year = x;
			}
		}

		int k = 0;
		int cur_false = 0;
		int[] false_runs = new int[size];
		while(k < oldest_year) {
			if (must_visit[k]) {
				false_runs[cur_false]+=1;
				cur_false = 0;
			}

			else {
				cur_false++;
			}			
			k+=1;
		}

		// for (int i=0;i<size ;i++ ) {
		// 	System.out.print(false_runs[i]);
		// }
		//System.out.println(K);
		int skipped = 0;
		for (int i=oldest_year;i>=0 ;i-- ) {
			while(false_runs[i]>0 && K >0) {
				skipped += i;
				false_runs[i]--;
				K--;
			}
		}
		//System.out.println("value: ");
		System.out.println(12*(oldest_year-skipped+1));


		//display();

	}



	// public static void display() {
	// 	for (int i = 0; i < size;i++ ) {
	// 		System.out.print(toInt(must_visit[i])+" ");
	// 	}
	// }

	// public static int toInt(boolean val) {
	// 	if (val) {
	// 		return 1;
	// 	}
	// 	else {
	// 		return 0;
	// 	}
	// }	
}