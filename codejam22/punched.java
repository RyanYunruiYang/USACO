import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class punched {
	public static void plusminusplus(int x) {
		System.out.print("+");
		for (int i=0;i<x ;i++ ) {
			System.out.print("-+");
		}
		System.out.println();
	}

	public static void bardotbar(int x) {
		System.out.print("|");
		for (int i=0;i<x ;i++ ) {
			System.out.print(".|");
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));		

        int t = Integer.parseInt(console.readLine());
        for (int o=0;o<t ;o++ ) {
            System.out.println("Case #"+(o+1)+": ");
			StringTokenizer tokenizer = new StringTokenizer(console.readLine());
			int r = Integer.parseInt(tokenizer.nextToken());
			int c = Integer.parseInt(tokenizer.nextToken());  

			System.out.print("..");
			plusminusplus(c-1);

			System.out.print("..");
			bardotbar(c-1);

			for (int i=0;i<r-1 ;i++ ) {
				plusminusplus(c);
				bardotbar(c);
			}
			plusminusplus(c);


        }

	}
}