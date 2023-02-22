import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.lang.*;

public class pancake {
	public static void main(String[] args) throws IOException {
	    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));		
		int t = Integer.parseInt(console.readLine());

		for (int o=0;o<t ;o++ ) {
			// System.out.print("Case #" + (o+1) + ": ");
			int n = Integer.parseInt(console.readLine());

			int[] d = new int[n];
			StringTokenizer tokenizer = new StringTokenizer(console.readLine());
			for (int i=0;i<n ;i++ ) {
				d[i] = Integer.parseInt(tokenizer.nextToken());
			}

			int l = 0;
			int r = n-1;
			int maxdelic = -1;
			int customers = 0;
			
			while(r>=l){
				if(d[l]>d[r]){
					if(d[r] >= maxdelic ){
						customers++;
						maxdelic = d[r];
					}
					r--;
				}
				else {//d[l]<=d[r]
					if(d[l] >= maxdelic){
						customers ++;
						maxdelic = d[l];
					}
					l++;
				}

			}
			System.out.println("Case #" + (o+1) + ": "+customers);
		}

		// System.out.println();

	}
}