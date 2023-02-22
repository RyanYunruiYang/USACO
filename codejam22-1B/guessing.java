import java.util.Scanner;
import java.util.Random;

public class guessing {
	public static int sum(int[] array) {
	    int sum = 0;
	    for (int value : array) {
	        sum += value;
	    }
	    return sum;
	}

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    Random rand = new Random();


    for (int o = 0; 0<T; o++) {
    	int x = 4;
    	while(x>0) {
	    	if(x==4) {
	    		System.out.println("10000000");
	    	}
	    	else {
	    		int[] value = new int[8];
	    		while(sum(value)<x){
	    			int n = rand.nextInt(8);
	    			if(value[n]==0){
	    				value[n]=1;
	    			}
	    		}
	    		for (int i=0;i<8 ;i++ ) {
	    			System.out.print(value[i]);
	    		}
	    		System.out.println();
	    	}
	    	x = input.nextInt();
	    }
    }
  }
}
