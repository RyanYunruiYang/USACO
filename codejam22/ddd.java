import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class ddd {
	public static void main(String[] args) throws IOException {
	    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));		
		int t = Integer.parseInt(console.readLine());

		int num_color = 4;
		int num_d = 3;

		for (int o=0;o<t ;o++ ) {
			int[] mins = new int[num_color];
			for (int i=0;i<num_color ;i++ ) {
				mins[i] = 1000000;
				if(mins[i]!=1000000){
					System.out.println("dumbass");
				}
			}

			for (int i=0;i<num_d ;i++ ) {
				StringTokenizer tokenizer = new StringTokenizer(console.readLine());
				for (int j=0;j<num_color ;j++ ) {
					int level = Integer.parseInt(tokenizer.nextToken());
					if(level< mins[j]) {
						mins[j] = level;
					}
				}
			}
			int sum = mins[0]+mins[1]+mins[2]+mins[3];

			if (sum < Math.pow(10,6)){
				System.out.println("Case #"+o+": IMPOSSIBLE");
			}
			else {
				System.out.print("Case #"+o+": ");
				int needed = 1000000;
				
				for (int i=0;i<num_color ;i++ ) {
					if(needed >=0){
						System.out.print(Math.min(needed, mins[i]) +" ");
						needed -= Math.min(needed, mins[i]);
					}
					else { //techncially not needed but deleting this would be more work.
						System.out.print(0 + " ");
					}
				}
				System.out.println();
			}

		}


	}
}