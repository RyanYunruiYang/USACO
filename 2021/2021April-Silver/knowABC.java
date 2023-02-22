import java.util.*;
public class knowABC {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		int tot = console.nextInt();

		for (int t = 0;t<tot ;t++ ) {
			int N = console.nextInt();

			int[] val = new int[N];

			for (int i =0;i<N ;i++ ) {
				val[i]=console.nextInt();
			}

			int count = 0;
			if (N==7) {
				if (val[0]+val[1]+val[2]==val[6]) {
					count+=1;
				}
				
			}

			System.out.println(count);


		}
	}
}