import java.io.*;
import java.util.*;

public class Main
{
	static int n, v;
	static List<ArrayList<Integer>> adj;
	static boolean[] vis;

	static public void BFS(int x)
	{
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		vis[x] = true;

		while (!q.isEmpty())
		{
			int cur = q.poll();

			for (int i = 0; i < adj.get(cur).size(); i++)
			{
				int nxt = adj.get(cur).get(i);
				if (vis[nxt] == true)
					continue;
				q.offer(nxt);
				vis[nxt] = true;
			}
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++)
		{
			int cnt = 0;
			v = Integer.parseInt(br.readLine());
			vis = new boolean[v + 1];
			adj = new ArrayList<>();
			
			for (int j = 0; j <= v; j++)
				adj.add(new ArrayList<>());
			
			st = new StringTokenizer(br.readLine());
			
			for (int k = 1; k <= v; k++)
				adj.get(k).add(Integer.parseInt(st.nextToken()));

			for (int m = 1; m <= v; m++)
			{
				if (vis[m] == true)
					continue;
				BFS(m);
				cnt++;
			}
			sb.append(cnt + "\n");
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
