import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.lang.*;

 
public class p3interval {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        int m = console.nextInt();//number of papers
        int[] a = new int[n];
        int[] b = new int[n];        
        for (int i=0;i<n ;i++ ) {
            a[i] = console.nextInt();
            b[i] = console.nextInt();
        }

        int[] c= new int[2*m+2];
        for (int i=0;i<n ;i++ ) {
            for (int j=0;j<n ;j++ ) {
                if(i==j) {
                    c[2*a[i]] +=1;
                    c[2*b[i]+1] -=1;
                }
                else {
                    c[a[i]+a[j]] +=1;
                    c[b[i]+b[j]+1] -=1;
                }
            }
        }
        int running = 0;
        for (int i=0;i<2*m+1 ;i++ ) {
            running += c[i];
            System.out.println(running);
        }


    }
}