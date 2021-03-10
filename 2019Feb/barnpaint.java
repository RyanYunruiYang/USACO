import java.util.*;
public class barnpaint {

    public static final int size = 10;    
    public static int[][]paint = new int[size+1][size+1];
    public static  int[][]dif = new int[size+1][size];//dif[i][j] = paint[i][j+1]-paint[i][j]
    
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int N = console.nextInt();
        int K = console.nextInt();


        
        for(int i=0; i<N; i++) {
            int x1 = console.nextInt();
            int y1 = console.nextInt();
            int x2 = console.nextInt();
            int y2 = console.nextInt();
            for(int q =y1; q<y2; q++) {
                dif[q][x1-1]++;
                dif[q][x2-1]--;
            }
            for(int r=0;r<size+1;r++){
                for(int c=0;c<size;c++){
                    System.out.printf("%3d ", dif[r][c]);
                }
                System.out.println();
            }
            System.out.println('\n');            
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

        for(int r=0;r<size+1;r++){
            for(int c=0;c<size;c++){
                System.out.printf("%3d ", paint[r][c]);
            }
            System.out.println();
        }
        System.out.println('\n'); 


        System.out.println(area);
    }
}