import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.Arrays;

public class dicestraight {
	public static void main(String[] args) throws IOException{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(console.readLine());

		for (int o=0;o<t ;o++ ) {
			int n = Integer.parseInt(console.readLine());

			StringTokenizer tokenizer = new StringTokenizer(console.readLine());

			int[] s= new int[n];
			for (int i=0;i<n ;i++ ) {
				s[i] = Integer.parseInt(tokenizer.nextToken());
			}



        	Arrays.sort(s);

        	int pointer = 0;
        	int atvalue = 1;

        	while(pointer<n) {
        		if(s[pointer]>=atvalue){
        			pointer++;
        			atvalue++;
        		}
        		else{
        			pointer++;
        		}
        	}


			System.out.println("Case #"+(o+1)+": "+(atvalue-1));
		}
	}
}