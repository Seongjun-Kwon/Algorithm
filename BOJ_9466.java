import java.io.*;
import java.util.*;

public class Main
{
	static int t, n, cnt;
	static int[] choose;
	static boolean[] visit;
	static boolean[] team;

	static void DFS(int x)
	{
		visit[x] = true;
		int nxt = choose[x];
		
		if (visit[nxt] == false)
			DFS(nxt);

		if (team[nxt] == false)
		{
			for (int i = nxt; i != x; i = choose[i])
				cnt++;
			cnt++;
		}

		team[x] = true;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++)
		{
			n = Integer.parseInt(br.readLine());
			cnt = 0;
			visit = new boolean[n + 1];
			team = new boolean[n + 1];
			choose = new int[n + 1];
			st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= n; j++)
				choose[j] = Integer.parseInt(st.nextToken());

			for (int k = 1; k <= n; k++)
			{
				if (visit[k] == false)
					DFS(k);
			}

			sb.append((n - cnt) + "\n");
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
