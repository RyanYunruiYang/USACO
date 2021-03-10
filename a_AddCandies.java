import java.util.Scanner;
public class a_AddCandies

{
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int t = console.nextInt();

		int n;
		for (int i = 0; i < t ;i++ ) {
			n= console.nextInt();
			System.out.println("" + n);

			for (int j = 0;j < n-1 ;j++ ) {
				System.out.print(""+(j+1) + " ");
			}
			System.out.print(""+(n));
			System.out.println();

		}
	}
}
