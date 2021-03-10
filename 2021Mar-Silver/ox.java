import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class ox {
	public static void main(String[] args) throws Exception {
	    Scanner in = new Scanner(System.in);
	    int N = in.nextInt();
	    int K = in.nextInt();
	    int total = 0;
	    int [] years = new int [N];
	    int [] cycles = new int [N];
	    for(int i = 0; i < N; i++) {
	    	years[i] = in.nextInt();
	    	cycles[i] = years[i] / 12 + 1;
	    }
	    Arrays.sort(cycles);
	    int [] diff = new int [N];
	    diff[0] = cycles[0];
	    for(int i = 1; i < cycles.length; i++) {
	    	diff[i] = cycles[i] - cycles[i-1];
	    }
	    Arrays.sort(diff);
	    for(int i = 1; i < diff.length-K+1; i++) {
	    	total += diff[i];
	    }
    	total += K-1;
    	System.out.println(12*total);
	}
}
