import java.io.*;
import java.util.*;

public class hps {
	public static void main(String[] args) throws FileNotFoundException,IOException {
		Scanner console = new Scanner(new File("hps.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));

		int n = console.nextInt();

		int a = 0;
		int b = 0;
		for(int i=0; i<n; i++) {
			int x = console.nextInt();
			int y = console.nextInt();

			if(y!=x){
				if((y-x==1) || (y-x==-2)) {
					a++;
				}
				else {
					b++;
				}			
			}
		}

		System.out.println(Math.max(a,b));
		out.println(Math.max(a,b));
		out.close();
	}
}