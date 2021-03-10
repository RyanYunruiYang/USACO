/*
ID: y.ryan.1
LANG: JAVA
TASK: ride
*/

import java.io.*;
import java.util.Scanner;

class ride1
{
	public static void main(String[] args) {

		Scanner s = null;
        // File IO with exception handling
        try {
            s = new Scanner(new File("ride.in"));
        } catch (FileNotFoundException e) {
            System.out.println("Could not open " + "ride.in");
            System.exit(1);
        }

		String s1 = s.nextLine();
		String s2 = s.nextLine();

		
		FileWriter writer=null;
        try {
            writer = new FileWriter(new File("ride.out"));
        } catch (IOException e) {
            System.out.println("Could not open " + "ride.in");
            System.exit(1);
        }		





		if ((getFourtySeven(s1)-getFourtySeven(s2))%47==0)
		{
			writer.write("GO");
			writer.close();

		}

		else
		{
			writer.write("STAY");
			writer.close();			
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