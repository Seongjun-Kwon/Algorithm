import java.io.*;
import java.util.*;

public class Main
{
	static int n;
	static int result;
	static int[][] adj;
	static boolean[] visit;
	static int[] tmp;

	static void DFS(int idx)
	{
		if (idx == n)
		{
			int sum = 0;

			for (int i = 0; i < n - 1; i++)
			{
				if (adj[tmp[i]][tmp[i + 1]] == 0)
					return;
				if(adj[tmp[n - 1]][tmp[0]] == 0)
					return;
				
				sum += adj[tmp[i]][tmp[i + 1]];
			}

			result = Math.min(sum + adj[tmp[n - 1]][tmp[0]], result);
			return;
		}

		for (int i = 0; i < n; i++)
		{
			if (!visit[i])
			{
				visit[i] = true;
				tmp[idx] = i;
				DFS(idx + 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		result = Integer.MAX_VALUE;
		adj = new int[n][n];
		visit = new boolean[n];
		tmp = new int[n];

		for (int i = 0; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				adj[i][j] = Integer.parseInt(st.nextToken());
		}

		DFS(0);
		
		bw.write(Integer.toString(result));
		br.close();
		bw.flush();
		bw.close();
	}
}
