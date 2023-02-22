import java.io.*;
import java.util.*;

public class odd {
	public static int solve(int odd, int even) {
		if(even>odd) {
			return 2*odd+1;
		}
		if(even==odd) {
			return even+odd;
		}
		//else, odd> even
		int x = odd-even;
		if(x%3==0){
			return 2*even + (2*x)/3;
		}
		if(x%3==1){
			return 2*even + Math.max((2*x-5)/3,0); //for x=1, gives 2*even-1, which is consistent
		}
		if(x%3==2) {
			return 2*even + (2*x-1)/3;
		}
		return -1;
// e= 0. 
//o=0: 0
//o=1: 0
//o=2: 1
//o=3: 2
//o=4: 1
//o=5: 3
//o=6: 4
//o=7: 3
//o=8: 5
	}

	public static void main(String[] args) throws FileNotFoundException, IOException{
		// Scanner console = new Scanner(new File("odd.in"));
		Scanner console = new Scanner(System.in);
		// PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));
		int n = console.nextInt();

		int odd = 0;
		int even = 0;
		for (int i=0;i<n ;i++ ) {
			int x = console.nextInt();
			if (x%2==1) {
				odd++;
			}
			else {
				even++;
			}
		}
		System.out.println(solve(odd, even));
	}

}















