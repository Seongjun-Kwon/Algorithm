import java.io.*;
import java.util.*;

public class Main
{
	static class Rec
	{
		int x1;
		int y1;
		int x2;
		int y2;

		public Rec(int x1, int y1, int x2, int y2)
		{
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}

	static int n;
	static boolean[] vis;
	static Rec[] arr;
	static int ans;

	static boolean isPossible(int cur, int nxt)
	{
		Rec a = arr[cur];
		Rec b = arr[nxt];
		
		if ((a.x1 > b.x1 && a.x2 < b.x2 && a.y1 > b.y1 && a.y2 < b.y2) || (a.x1 < b.x1 && a.x2 > b.x2 && a.y1 < b.y1 && a.y2 > b.y2) || a.x1 > b.x2 || a.y1 > b.y2 || a.x2 < b.x1 || a.y2 < b.y1)
			return false;
		
		else
			return true;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		vis = new boolean[n + 1];
		arr = new Rec[n + 1];
		ans = 0;
		
		arr[0] = new Rec(0, 0, 0, 0);

		for (int i = 1; i < n + 1; i++)
		{
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			arr[i] = new Rec(x1, y1, x2, y2);
		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < n + 1; i++)
		{
			if (vis[i])
				continue;
			
			vis[i] = true;
			q.add(i);

			while (!q.isEmpty())
			{
				int cur = q.poll();

				for (int j = 0; j < n + 1; j++)
				{
					if (cur == j || !isPossible(cur, j) || vis[j])
						continue;
					
					vis[j] = true;
					q.add(j);
				}
			}

			ans++;
		}

		bw.write(Integer.toString(ans - 1));
		br.close();
		bw.flush();
		bw.close();
	}
}
