import java.util.*;
import java.io.*;
public class barnsubmit {

    public static final int size = 1010;    
    public static int[][]paint = new int[size+1][size+1];
    public static  int[][]dif = new int[size+1][size+1];//dif[i][j] = paint[i][j+1]-paint[i][j]
    
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(new File("paintbarn.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));

        int N = console.nextInt();
        int K = console.nextInt();


        int x1;
        int y1;
        int x2;
        int y2;
        for(int i=0; i<N; i++) {
            x1 = console.nextInt();
            y1 = console.nextInt();
            x2 = console.nextInt();
            y2 = console.nextInt();
            for(int q =y1; q<y2; q++) {
                dif[q][x1]++;
                dif[q][x2]--;
            }

        }

        
        int area = 0;
        for(int i=0;i<size+1;i++) {
            paint[i][0] = 0;
            for(int x=0;x<size;x++){
                paint[i][x+1]=paint[i][x]+dif[i][x];
                if (paint[i][x+1]==K) {
                    area++;
                }
            }
        }
        out.println(area);
        out.close();        

    }
}