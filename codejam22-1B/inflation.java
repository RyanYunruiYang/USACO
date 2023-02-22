import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.lang.*;

public class inflation {
	public static void main(String[] args) throws IOException {
	    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));		
		int t = Integer.parseInt(console.readLine());

		for (int o=0;o<t ;o++ ) {
			StringTokenizer tokenizer = new StringTokenizer(console.readLine());
			int n = Integer.parseInt(tokenizer.nextToken());
			int p = Integer.parseInt(tokenizer.nextToken());

			long[] min = new long[n];
			long[] max = new long[n];
			for (int i=0;i<n ;i++ ) {
				min[i] = 1000000000+1;
			}
			for (int i=0;i<n ;i++ ) {
				tokenizer = new StringTokenizer(console.readLine());

				for (int j=0; j<p; j++ ) {
					long x = Long.parseLong(tokenizer.nextToken());
					if(x<min[i]){
						min[i] = x;
					}
					if(x>max[i]){
						max[i] = x;
					}
				}
			}
			// for (int i=0;i<n ;i++ ) {
			// 	System.out.println("min: " + min[i] + "max: " + max[i]);
			// }

			long[][] dp = new long[n][2];
			dp[0][0] = max[0]+ (max[0]-min[0]);
			dp[0][1] = max[0];

			// System.out.println("dp[0][0]: "+ dp[0][0] + ", dp[0][1]:"+ dp[0][1]);
			for (int i=1;i<n ;i++ ) {
				dp[i][0] = Math.min(Math.abs(max[i]-min[i-1])+dp[i-1][0],Math.abs(max[i]-max[i-1])+dp[i-1][1])+max[i]-min[i];
				dp[i][1] = Math.min(Math.abs(min[i]-min[i-1])+dp[i-1][0],Math.abs(min[i]-max[i-1])+dp[i-1][1])+max[i]-min[i];

				// System.out.println("dp[i][0]: "+ dp[i][0] + ", dp[i][1]:"+ dp[i][1]);
			}
			System.out.println("Case #" + (o+1)+": " + Math.min(dp[n-1][0], dp[n-1][1]));			
		}

	}
}