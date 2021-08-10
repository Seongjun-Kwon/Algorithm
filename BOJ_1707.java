import java.io.*;
import java.util.*;

public class Main
{
	static int k, v, e;
	static List<Integer>[] adj;
	static boolean[] vis;
	static int[] color;
	static boolean ans;

	static boolean DFS(int x, int col)
	{
		color[x] = col;
		vis[x] = true;

		for (int i = 0; i < adj[x].size(); i++)
		{
			int nxt = adj[x].get(i);

			if (vis[nxt] == true)
			{
				if (color[nxt] == color[x])
				{
					ans = false;
					return ans;
				}
				continue;
			}
			color[nxt] = color[x] * (-1);
			vis[nxt] = true;
			DFS(nxt, color[nxt]);
		}
		return ans;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++)
		{
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			adj = new ArrayList[v + 1];
			vis = new boolean[v + 1];
			color = new int[v + 1];
			
			for (int j = 1; j <= v; j++)
				adj[j] = new ArrayList<>();

			for (int k = 0; k < e; k++)
			{
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				adj[start].add(end);
				adj[end].add(start);
			}

			ans = true;
			
			for (int m = 1; m <= v; m++)
			{
				if (vis[m] == true)
					continue;
				ans = DFS(m, 1);
			}

			if (ans == true)
				sb.append("YES" + "\n");
			else
				sb.append("NO" + "\n");
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
