import java.io.*;
import java.util.*;

public class Main
{
	static int n, m;
	static int[][] nxt;
	static int[][] adj;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		adj = new int[n + 1][n + 1];
		nxt = new int[n + 1][n + 1];
		
		for (int a[] : adj)
			Arrays.fill(a, 100 * 100000);

		for (int i = 0; i < m; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a][b] = Math.min(adj[a][b], c);
			nxt[a][b] = b;
		}

		for (int i = 1; i <= n; i++)
			adj[i][i] = 0;

		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				for (int k = 1; k <= n; k++)
				{
					if (adj[j][i] + adj[i][k] < adj[j][k])
					{
						nxt[j][k] = nxt[j][i];
						adj[j][k] = adj[j][i] + adj[i][k];
					}
				}
			}
		}

		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				if (adj[i][j] == 100 * 100000)
					bw.write("0 ");
				else
					bw.write(Integer.toString(adj[i][j]) + " ");
			}

			bw.write("\n");
		}

		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				if (adj[i][j] == 0 || adj[i][j] == 100 * 100000)
				{
					bw.write("0" + "\n");
					continue;
				}

				List<Integer> result = new ArrayList<>();
				int cur = i;

				while (cur != j)
				{
					result.add(cur);
					cur = nxt[cur][j];
				}

				result.add(j);
				
				bw.write(Integer.toString(result.size()) + " ");
				for (int k = 0; k < result.size(); k++)
					bw.write(Integer.toString(result.get(k)) + " ");
				bw.write("\n");
			}
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
