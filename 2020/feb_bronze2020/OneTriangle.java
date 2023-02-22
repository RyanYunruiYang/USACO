import java.io.*;
import java.util.*;
import java.lang.*;


//*--------------*
//|
//|
//|
//|
//*

// Reformulation: Find a set of points (A: (B,C)) where B !=C
// maximize d(A,B) * d(A,C) where you also have that
//A is in the same row as B
// and A is in the same column as C
public class OneTriangle{
	public static void main(String[] args) throws FileNotFoundException, IOException{
		Scanner console = new Scanner(new File("triangles.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
		int n = console.nextInt();

		int[] x = new int[n];
		int[] y = new int[n];
		for (int i=0;i<n ;i++ ) {
			x[i] = console.nextInt();
			y[i] = console.nextInt();
		}

		int max = 0;
		for (int i=0;i<n ;i++ ) {
			for (int j=0;j<n ;j++ ) {
				for (int k=0;k<n ;k++ ) {
					if((i!=j)&&(j!=k)&&(k!=j)&&(x[i]==x[j])&&(y[i]==y[k])){
						if(Math.abs((y[i]-y[j])*(x[i]-x[k]))>max){
							max = Math.abs((y[i]-y[j])*(x[i]-x[k]));
						}
					}
				}
			}

		}
		out.println(max);
		out.close();
	}
}
			// int deltaX = 0;
			// int deltaY = 0;
			// for (int j=0;j<n ;j++ ) {
			// 	int dx = Math.abs(x[i]-x[j])
			// 	int dy = Math.abs(y[i]-y[j])
			// 	if((y[i]==y[j]) && dx > deltaX) {
			// 		deltaX = dx;
			// 	}
			// 	if((x[i]==x[j]) && dy > deltaY) {
			// 		deltaY = dy;
			// 	}
			// }
			// if(deltaX*deltaY> max){
			// 	max = deltaX * deltaY;
			// }

		// int c = 10000;
		// int[][] col = new int[2*c+1][2];//0 is min, 1 is max
		// int[][] row = new int[2*c+1][2];//0 is min, 1 is max

		// int[][] points = new int[n][2];
		// for (int i=0;i<n ;i++ ) {
		// 	int a = console.nextInt();
		// 	int b = console.nextInt();
		// 	points[i][0]=a;
		// 	points[i][1]=b;

		// 	if(b<col[a][0]){//col[a][0] is the minimum y coordinate of col
		// 		col[a][0]=b;
		// 	}
		// 	if(b>col[a][1]){
		// 		col[a][1]=b;
		// 	}
		// 	if(a<row[b][0]){//row[b][0] is the min x coordinate of the row
		// 		row[b][0]=a;
		// 	}
		// 	if(a>row[b][1]){
		// 		row[b][1]=a;
		// 	}			
		// }//
		// int max = 0;
		// for (int i=0;i<n;i++ ) {
		// 	int x= points[i][0];
		// 	int y= points[i][1];
		// 	int newarea = Math.max(x-row[y][0],row[y][1]-x)*Math.max(y-col[x][0],col[x][1]-y);

		// 	if(newarea>max){
		// 		max = newarea;
		// 	}
		// }
		// out.println(max);
		// out.close();