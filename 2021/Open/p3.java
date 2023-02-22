import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.lang.*;

 
public class p3 {
    public static int hindex(int[] c) {//assume c is sorted already
        if(c[0]==0){
            return 0;
        }
        int max=-1;
        for (int i=1;i<c.length ;i++ ) {
            if(c[i-1] >=i) {
                max=i;
            }
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder out = new StringBuilder();
        // int n = Integer.parseInt(in.readLine());
        Scanner console = new Scanner(System.in);

        int n = console.nextInt();
        int k = console.nextInt();//number of papers
        int l = console.nextInt();//number of citation per paper
        int[] a = new int[n];
        for (int i=0;i<n ;i++ ) {
            a[i] = console.nextInt();//1 0 1 0
        }
        Arrays.sort(a);   
        int[] c = new int[n];        
        for (int i=0;i<n ;i++ ) {
            c[i] = a[n-1-i];
        }
        
        int max=-1;

        int left = hindex(c);
        int right = Math.min(hindex(c)+k,n);
        // System.out.println(left + ", "+ right);

        while(left<right) {

            int h = (left+right+1)/2;

            // System.out.println("h: "+h);
            long sum = 0;
            for (int i=0;i<h ;i++ ) {
                sum += Math.max(0,h-c[i]);
            }
            // System.out.println("sum: " + sum);

            if((sum<= (long) l* (long) k)&& (c[h-1]+k >= h)) {
                left=h;//h works

            }
            else {
                right = h-1;
            }
            // System.out.println(left + ", "+ right);

        }
        System.out.println(left);

        //c++? :vomit:


        //n papers
        //k papers
        //l citations per paper

        //solution: binary sort h?

        //upper bound this with like H(c)+K
        //check h: (1) \sum_{i=1}^h max(0,h-c_i) <= L*K. (2) min(c_i) + K >=h.



    }
}