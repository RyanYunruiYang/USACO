import java.util.*;
import java.io.*;

class Cow implements Comparable<Cow>{
	public int w, x, d, leaveTime;

	public Cow (int w, int x, int d) {
		this.w = w;
		this.x = x;
		this.d = d;
	}

	public String toString() {
		return "w: " + w + " x: " + x + " d: " + d + " leaveTime: " + leaveTime;
	}

	@Override
	public int compareTo(Cow c1) {
		return this.leaveTime-c1.leaveTime;
	}

	public static Comparator<Cow> CowComparator = new Comparator<Cow>() {
		public int compare(Cow c1, Cow c2) {
			return c1.x - c2.x;
		}
	};


}

public class meetings {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		Scanner console = new Scanner(new File("meetings.in"));
		PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));

		int n = console.nextInt();
		int length = console.nextInt();

		Cow[] herd = new Cow[n];
		int tot_weight = 0;

		for (int i=0; i < n; i++) {
			int w = console.nextInt();
			tot_weight +=w;
			Cow cow = new Cow(w,console.nextInt(),console.nextInt());
			herd[i] = cow;
		}
		//we've assume the cows are ordered according to x intiially
		Arrays.sort(herd, Cow.CowComparator);

		int left = 0;
		int right = n-1;

		ArrayList<Integer> rep = new ArrayList<Integer>();
		ArrayList<Integer> dem = new ArrayList<Integer>();


		for (int i = 0;i < n ;i++ ) {

			if(herd[i].d == -1) {
				herd[left].leaveTime = herd[i].x;
				dem.add(herd[i].x);
				left++;
			}

			if(herd[n-1-i].d == 1) {
				herd[right].leaveTime = length - herd[n-1-i].x;
				rep.add(herd[n-1-i].x);
				right--;				
			}
		}

		Arrays.sort(herd);

		int T = 0;
		int weight = 0;
		int k = 0;
		while (2*weight < tot_weight) {
			weight += herd[k].w;
			T = herd[k].leaveTime;
			k++;
		}


		boolean debugging = false;
		if (debugging){
			for (int i=0; i<n ;i++ ) {
				System.out.println(herd[i]);
			}
			System.out.println("\n T: " + T + "   tot_weight: "+ tot_weight);

			for (int a = 0; a<rep.size() ;a++ ) {
				System.out.println(rep.get(a));
			}	
			System.out.println("switching to dems");
			for (int b =0; b<dem.size() ;b++ ) {
				System.out.println(dem.get(b));
			}			

		}

		int collisions = 0;
		// for (int a = 0; a<rep.size() ;a++ ) {
		// 	for (int b =0; b<dem.size() ;b++ ) {
		// 		if ((rep.get(a)+2*T >= dem.get(b)) && (rep.get(a)<dem.get(b)) ) {
		// 			collisions++;
		// 		}
		// 	}
		// }

		ArrayList<Integer> righter = new ArrayList<Integer>();
		Arrays.sort(herd, Cow.CowComparator);

		for (int i=0; i<n; i++) {
			if (herd[i].d == -1) {
				while ((righter.size()>0) && (righter.get(0)+2*T < herd[i].x)) {
					righter.remove(0);
				}
				collisions += righter.size();
			} 
			else {
				righter.add(herd[i].x);
			}
		}


		printer.println(collisions);
		printer.close();
		//580
		
	}
}