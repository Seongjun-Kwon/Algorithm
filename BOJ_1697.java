import java.io.*;
import java.util.*;

public class Main
{
	static int n, k;
	static int[] dis;
	static StringBuilder sb;

	static void BFS(int x)
	{
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		dis[x] = 1;

		while (!q.isEmpty())
		{
			int cur = q.poll();

			for (int i = 0; i < 3; i++)
			{
				int nxt;
				
				if (i == 0)
					nxt = cur - 1;
				else if (i == 1)
					nxt = cur + 1;
				else
					nxt = 2 * cur;

				if (nxt == k)
				{
					sb.append(dis[cur]);
					return;
				}

				if (nxt < 0 || nxt > 100000 || dis[nxt] != 0)
					continue;
				
				q.add(nxt);
				dis[nxt] = dis[cur] + 1;
			}
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dis = new int[100001];

		if (n == k)
		{
			bw.write("0");
			br.close();
			bw.flush();
			bw.close();
            return;
		}

		BFS(n);
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
