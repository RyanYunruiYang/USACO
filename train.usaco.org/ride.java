/*
ID: y.ryan.1
LANG: JAVA
TASK: ride
*/

import java.io.*;
import java.util.Scanner;

class ride
{
	public static void main(String[] args) throws IOException {

	    BufferedReader s = new BufferedReader(new FileReader("ride.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

		String s1 = s.readLine();
		String s2 = s.readLine();

		if ((getFourtySeven(s1)-getFourtySeven(s2))%47==0)
		{
			out.println("GO");
			out.close();

		}

		else
		{
			out.println("STAY");
			out.close();
		}	
	}

	public static int getFourtySeven(String input)
	{
		int counter =1;
		for (int i=0;i<input.length() ;i++ ) {
			int x=input.charAt(i)-'A'+1;
			counter *=x;
			
		}
		return counter;
	}
}