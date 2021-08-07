import java.io.*;
import java.util.*;

public class Main
{
	static int v;
	static int e;
	static int start;
	static List<Integer>[] adj;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		adj = new ArrayList[v + 1];
		
		boolean[] BFSvis = new boolean[v + 1];
		boolean[] DFSvis = new boolean[v + 1];
		Queue<Integer> BFSq = new LinkedList<>();
		Stack<Integer> DFSsta = new Stack<>();
		
		for (int i = 1; i <= v; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < e; i++)
		{
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj[from].add(to);
			adj[to].add(from);
		}

		for (int i = 1; i <= v; i++)
			Collections.sort(adj[i]);
		
		DFSsta.add(start);
		while (!DFSsta.isEmpty())
		{
			int cur = DFSsta.pop();
			if (DFSvis[cur])
				continue;
			DFSvis[cur] = true;
			bw.write(Integer.toString(cur) + " ");

			for (int i = 0; i < adj[cur].size(); i++)
			{
				int nxt = adj[cur].get(adj[cur].size() - 1 - i);
				if (DFSvis[nxt])
					continue;
				DFSsta.add(nxt);
			}
		}

		bw.write("\n");
		
		BFSq.add(start);
		BFSvis[start] = true;
		while (!BFSq.isEmpty())
		{
			int cur = BFSq.poll();
			bw.write(Integer.toString(cur) + " ");

			for (int i = 0; i < adj[cur].size(); i++)
			{
				int nxt = adj[cur].get(i);
				if (BFSvis[nxt])
					continue;
				BFSq.add(nxt);
				BFSvis[nxt] = true;
			}
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
