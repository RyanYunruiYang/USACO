import java.util.*;
import java.io.*;
public class SJ3_Mootube {
	
	static int n,q;
	static ArrayList<Edge>[] adj;

	static class Edge {
		int to;
		int weight;

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner r = new Scanner(new File("mootube.in"));
		// Scanner r = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));

		// PrintWriter pw = new PrintWriter(new File("moutube.out"));		
		n = r.nextInt();
		q = r.nextInt();

		adj = new ArrayList[n];

		boolean[] visited = new boolean[n];

		for (int i=0;i< n ;i++ ) {
			adj[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < n-1; i++) { //reading in the n-1 edges
			int a = r.nextInt()-1;
			int b = r.nextInt()-1;
			int w = r.nextInt();


			adj[a].add(new Edge(b,w));
			adj[b].add(new Edge(a,w));
		}

		for (int numq = 0;numq <q ;numq++ ) {
			boolean[] seen = new boolean[n];
			int reached = 0;
			int limit = r.nextInt();
			int start = r.nextInt()-1;
			seen[start] = true;

			int reachable = 0;
			LinkedList<Integer> queue = new LinkedList<Integer>();

			queue.add(start);

			while (!queue.isEmpty()) {
				int curLoc = queue.removeFirst();

				for (Edge out: adj[curLoc]) {
					if (!seen[out.to] && out.weight >=limit) {
						seen[out.to] = true;
						queue.add(out.to);
						reached++;
					}
				}
			}
			pw.println(reached);
		}
		pw.close();
		// System.out.println(n + " " + m);
	}
}