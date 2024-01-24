import java.io.*;
import java.util.*;
import java.lang.*;


//7,8,9

// a<b<c ---> b< x < c.
// a<b<c ---> a < x < b
public class OneSleepyCowHerding{
	public static void main(String[] args) throws FileNotFoundException, IOException{
		Scanner console = new Scanner(new File("herding.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));

		int[] a = new int[3];

		for (int i=0;i<3 ;i++ ) {
			a[i] = console.nextInt();
		}
		Arrays.sort(a);
		System.out.println(a[0]+": " + a[1]+ ": "+ a[2]);
		//if two cows are one or two appart, then we can get it in one move
		// otherwise we can always do it in 2 moves

		// int x = Math.min(a[1]-a[0],a[2]-a[1]);
		
		if(a[2]==a[0]+2){//already all adjacent
			out.println(0);//basically both differences are 1
		}
		else if(a[1]-a[0]==2 || a[2]-a[1]==2){//there's a gap with dif=2 --> gap of 1
			out.println(1);
		} //    5, 100, 102.    or   5 7 1000
		else{
			out.println(2); // a b c --- > a a+2 b --> a a+1 a+2
		}
		out.println(Math.max(a[1]-a[0],a[2]-a[1])-1);
		out.close();
		// 10, 20, 100
		// 20, 21, 100 --> 21, 22,100 --> 22,23,100
		//23,24,100


	}
}