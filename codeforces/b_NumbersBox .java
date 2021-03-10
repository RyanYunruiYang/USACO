import java.util.Scanner;
public class b_NumbersBox

{
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int t = console.nextInt();

		int n;
		int m;
		for (int i = 0; i < t ;i++ ) {
			n= console.nextInt();
			m = console.nextInt();


			for (int j = 0;j < n-1 ;j++ ) {
				System.out.print(""+(j+1) + " ");
			}
			System.out.print(""+(n));
			System.out.println();

		}
	}
}
