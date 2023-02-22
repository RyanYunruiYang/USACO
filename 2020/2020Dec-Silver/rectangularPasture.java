import java.util.Scanner;  // Import the Scanner class

public class rectangularPasture
{
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int N = console.nextInt();
		int[][] cows;
		cows = new int[N][2];

		for (int i = 0;i <N ;i++ ) {
			cows[i][0] = console.nextInt();
			cows[i][1] = console.nextInt();
		}

		System.out.println(cows);

	}
}