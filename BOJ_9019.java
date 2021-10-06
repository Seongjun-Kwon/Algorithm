import java.io.*;
import java.util.*;

public class Main
{
	static StringBuilder sb;
	static int t;
	static boolean[] vis;

	static class Pair
	{
		private int num;
		private String com;

		public Pair(int num, String com)
		{
			this.num = num;
			this.com = com;
		}
	}

	static void BFS(int a, int b)
	{
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(a, ""));
		vis[a] = true;

		while (!q.isEmpty())
		{
			int cur = q.peek().num;
			String com = q.peek().com;
			q.poll();

			for (int i = 0; i < 4; i++)
			{
				int nxtNum;
				String nxtStr;
				int d1 = cur / 1000;
				int d2 = (cur % 1000) / 100;
				int d3 = (cur % 100) / 10;
				int d4 = cur % 10;

				if (i == 0)
				{
					nxtNum = cur * 2;
					
					if (cur * 2 > 9999)
						nxtNum %= 10000;
					
					nxtStr = com + "D";
				}
				else if (i == 1)
				{
					nxtNum = cur - 1;
					
					if (nxtNum == -1)
						nxtNum = 9999;
					
					nxtStr = com + "S";
				}
				else if (i == 2)
				{
					nxtNum = ((d2 * 10 + d3) * 10 + d4) * 10 + d1;
					nxtStr = com + "L";
				}
				else
				{
					nxtNum = ((d4 * 10 + d1) * 10 + d2) * 10 + d3;
					nxtStr = com + "R";
				}

				if (nxtNum == b)
				{
					sb.append(nxtStr + "\n");
					return;
				}

				if (vis[nxtNum])
					continue;
				
				q.add(new Pair(nxtNum, nxtStr));
				vis[nxtNum] = true;
			}
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		sb = new StringBuilder();
		
		t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++)
		{
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			vis = new boolean[10000];
			BFS(from, to);
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
