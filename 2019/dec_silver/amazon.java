import java.util.*;
import java.io.*;

public class azamon {

	public static void execute(int[] jeff) {
		for(int i = 0; i < jeff.length; i++){
			char c=(char)(jeff[i]+55);  

			System.out.print(c + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		int t = console.nextInt();


		for (int i = 0; i < t ;i++ ) {
			String s = console.next();
			int x=s.length();
			int[] jeff = new int[x];
			int[] sorted = new int[x];

			for (int j = 0;j < x ;j++ ) {
				jeff[j] = Character.getNumericValue(s.charAt(j));
				sorted[j] = Character.getNumericValue(s.charAt(j));
				// System.out.println(jeff[j]);
			}

			System.out.println();



			String c = console.next();
			int y=c.length();
			int[] comp = new int[y];


			for (int j = 0;j <y ;j++ ) {
				comp[j] = Character.getNumericValue(c.charAt(j));
			}

			Arrays.sort(sorted);

			int k=0;
			boolean lol;
			while (jeff[k]==sorted[k]) {
				k++;
			}
			int t = jeff[k];
			jeff[k] = sorted[k];

			boolean unswapped = true;
			for (int i=x-1;i>=0 ;i-- ) {
				if((jeff[i]=sorted[k])&& unswapped ) {
					jeff[i] = t;
					unswapped = false;
				}
			}

			execute(jeff)
			





		}
		//we have to get s' < c

	}
}