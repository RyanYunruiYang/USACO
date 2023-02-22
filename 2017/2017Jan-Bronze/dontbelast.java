import java.io.*;
import java.util.*;

public class dontbelast {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		Scanner console = new Scanner(new File("notlast.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
		int n = console.nextInt();

		Map<String,Integer> index = new HashMap<String,Integer>();
		Map<Integer,String> name = new HashMap<Integer,String>();
		//index gives the index of the cow
		//name returns the name given index

		int currIndex = 0;
		int[] milk = new int[n];//should be all defaulted to 0s

		for (int i=0;i<n ;i++ ) {//runs over all input values
			String s = console.next();//gets name
			// System.out.println(s);

			if(index.get(s) == null){
				index.put(s,currIndex);//create a new index
				name.put(currIndex,s);
				milk[currIndex] += console.nextInt();//adds the milk value
				currIndex++;//new
			}
			else {
				milk[index.get(s)]+= console.nextInt();
			}
		}
		// System.out.println();
		int min = Integer.MAX_VALUE;
		for (int i=0;i<currIndex ;i++ ) {
			// System.out.println(name.get(i) +": "+ milk[i]);
			if(milk[i]<min) {
				min = milk[i];
			}
		}

		int besty = Integer.MAX_VALUE;
		
		for (int i=0;i<currIndex ;i++ ) {
			if(milk[i]>min && milk[i]<besty) {
				besty = milk[i];
			}
		}//min is smallest value, besty is second smallest value (max_value if it doesn't exist)
		// System.out.print("besty: "+ besty);

		int bindex = -1;
		for (int i=0;i<currIndex ;i++ ) {
			if(milk[i]==besty && bindex==-1) {
				bindex = i;
			}
			else if (milk[i]==besty && bindex >-1) {
				bindex = -2;
			}
		}

		if(besty == Integer.MAX_VALUE) {//here all cows have the min milk rpdocution
			if(currIndex > 1) {
				out.println("Tie");
				System.out.println("Tie");
			}
			else {
				out.println(name.get(0));
				System.out.println(name.get(0));
			}
		}
		else {//some cows cause "second-min" to exist
			if(bindex>-2){
				out.println(name.get(bindex));
				System.out.println(name.get(bindex));
			}
			if(bindex == -2){//-2 is an error "message" from line 57 to pass info
				out.println("Tie");
				System.out.println("Tie");
			}
		}
		out.close();








	}
}

// Name x


// HashMap Example: 
// Map<String, String> map = new HashMap<String, String>();
// map.put("dog", "type of animal");
// System.out.println(map.get("dog"));