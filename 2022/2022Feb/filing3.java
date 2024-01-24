import java.util.*;
import java.io.*;
import java.lang.Math;

public class filing3 {
   	public static int findLastIndex(int arr[], int t)
    {
        if (arr == null) {
            return -1;
        }

        int finalIndex = -1;
        for (int i=0;i<arr.length ;i++ ) {
        	if(arr[i]==t) {
        		finalIndex = i;
        	}
        }

        return finalIndex;
    }	

	public static void main(String[] args) throws FileNotFoundException{
		Scanner console = new Scanner(new File("3.in"));
		// Scanner console = new Scanner(System.in);

		int t= console.nextInt();

		for (int o=0;o<t ;o++ ) {
			System.out.println("-----------");
			int m = console.nextInt();
			int n = console.nextInt();
			int k = console.nextInt();

			LinkedList f = new LinkedList();
			for (int i=0;i<n ;i++ ) {
				f.add(console.nextInt()-1);
				System.out.println(f.get(i));
			}


			int pointerFolder = 0;
			int pointerEmail = 0;

			for(pointerFolder =0; pointerFolder <m; pointerFolder++) {
				System.out.println("pointerFolder: "+ pointerFolder);
				boolean stillLeft=true;
				while(stillLeft){
					stillLeft = false;
					boolean productive = true;	

					while(productive) {
						productive = false;
						for (int i=pointerEmail;i<pointerEmail+k ;k++ ) {
							System.out.println("pointerEmail: " + pointerEmail);

							int x = (int) f.get(i);
							System.out.println(f);
							System.out.println("x: "  + x);

							boolean removed = false;
							if((pointerFolder<=x) && (x< pointerFolder +k) && (!removed)) {
								System.out.println("removed");
								f.remove(x);
								System.out.println("pointerEmail+k: " + (pointerEmail+k));
								System.out.println(f);
								System.out.println("f.size()-1: "+ (f.size()-1));
								if(pointerEmail + k == f.size()) {
									pointerEmail--;
								}

								productive = true;
								removed = true;									

							}
						}
					}

					if(f.indexOf(pointerFolder)>=0){
						System.out.println("f.indexOf(pointerFolder):  "+f.indexOf(pointerFolder));
						stillLeft = true;
						pointerEmail++;
					}									
				}

			}
			// for (int chop = 0;chop <m; chop++ ) {
			// 	pointerEmail = findLastIndex(f, chop)-k+1;
			// 	//all files for [chop,chop + k-1], <=findLastIndex(f, chop), are dead.
			// 	if(findLastIndex(f,chop) == n-1) {

			// 		//time to check if we can clean up everything else
			// 	}
			// 	// else {
			// 	// 	keep going
			// 	// }
			// 	System.out.println(pointerEmail);
			// }


		}
	}
}