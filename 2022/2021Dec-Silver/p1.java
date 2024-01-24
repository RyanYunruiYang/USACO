import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.lang.*;
public class p1 {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        int k = console.nextInt();
        int m = console.nextInt();
        int n = console.nextInt();  
        int[] p = new int[k];
        long[] t = new long[k];
        for (int i=0;i<k ;i++ ) {
            p[i] = console.nextInt();
            t[i] = console.nextLong();
        }
        int[] f = new int[m];
        for (int i=0;i<m ;i++ ) {
            f[i] = console.nextInt();
        }
        long[] value = new long[2*m+2];
        int[] l = new int[m+1];
        int cursor = 0;
        l[0] = 0;
        for (int i=1;i<=m ;i++ ) {
            while(cursor<k && p[cursor] < f[i-1]){
                cursor+=1;
            }//now p[cursor] > f[i-1]
            l[i] = cursor;
            // System.out.println("l["+i + "]: "+ l[i]);
        }
        for (int i=0;i<m+1 ;i++ ) {
            System.out.println("i: " + i + " l[i]: " + l[i]);
        }
        //l[0] and l[m] are special.
        for (int i=0;i<l[1] ;i++ ) {
            value[0]+= t[i];
        }
        for (int i=1;i<m ;i++ ) {//for each interval, we need to assign 2i and 2i+1
            long single = 0;//consider cows from l[i] to l[i+1]-1.
            long two = 0;
            if(l[i]<l[i+1]) {
                int left = l[i];
                int right = l[i];
                long sum = t[left];
                single = sum;
                boolean changed = true;
                while(changed) {
                    changed = false;
                    System.out.println("i: "+ i + " left: "+ left + " right: " + right);
                    // System.out.println("sum: " + sum);     
                    // System.out.println(p[right+1]);         
                    // System.out.println(p[left]+ (f[i]-f[i-1])/2);
                    while ((right+1<k) && (p[right+1]<= p[left]+(f[i]-f[i-1]-1)/2)&& (p[right+1]<=f[i])){
                        changed = true;
                        right++;
                        sum += t[right];
                        if(sum>single){
                            single = sum;
                        }
                        System.out.println("entered, "+ "i: "+ i + " left: "+ left + " right: " + right);
                    }//p[right] <= p[left] + (b-a-1)/2, right is also maximal.

                    if((left+1<k)&&(p[left+1]<f[i])){
                        sum-= t[left];                        
                        left++;
                        changed = true;
                    }
                    if(left>right){
                        right++;
                        sum+= t[right];
                        changed = true;
                    }                  
                }
            }
            for (int j=l[i];j<l[i+1] ;j++ ) {
                two+= t[j];
            }

            value[2*i] = single;
            value[2*i+1] = two-single;
        }
        for(int i=l[m]; i<k; i++) {
            value[2*m]+= t[i];
        }
        for (int i=0;i<2*m+2 ;i++ ) {
            System.out.println("value["+i+"]: " + value[i]);
        }
        Arrays.sort(value);
     
        long taste = 0;
        for (int i=2*m+2-n;i<2*m+2 ;i++ ) {
            taste += value[i];
        }
        System.out.println(taste);

    }
}