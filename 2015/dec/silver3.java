import java.io.*;
import java.util.*;
import java.lang.*;
//http://www.usaco.org/index.php?page=viewproblem2&cpid=572
public class silver3 { //breed counting
	public static void main(String[] args) throws FileNotFoundException,IOException {
		// Scanner console = new Scanner(new File("bcount.in"));

		BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int[][] cowprefix = new int[3][n+1];
		for (int i=1;i<n+1 ;i++ ) {
			for (int j=0;j<3 ;j++ ) {
				cowprefix[j][i] = cowprefix[j][i-1];
			}
			int id = Integer.parseInt(br.readLine());
			cowprefix[id-1][i]+=1;
		}

		// for (int j=0;j<3 ;j++ ) {
		// 	for (int i=0;i<n+1 ;i++ ) {
		// 	System.out.print(cowprefix[j][i] + " ");
		// 	}	
		// 	System.out.println();					
		// }

		PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
		for (int i=0;i<q ;i++ ) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			for(int j=0;j<3;j++){
				// System.out.print(cowprefix[j][b] - cowprefix[j][a-1] + " ");
				if(j<2){
					output.write(cowprefix[j][b] - cowprefix[j][a-1] + " ");					
				}
				if(j==2) {
					output.write(cowprefix[j][b] - cowprefix[j][a-1] + "\n");					
				}
			}	
			// if(i<q-1){
			// 	output.write("\n");

			// }
		}
		output.close();

	}
}