import java.io.*;
import java.util.*;

public class Main
{
	static int t;
	static boolean[] isPrime;
	static int[] dis;
	static StringBuilder sb;

	static void BFS(int beforeNum, int afterNum)
	{
		Queue<Integer> q = new LinkedList<>();
		
		dis = new int[10000];
		q.offer(beforeNum);
		dis[beforeNum] = 1;

		while (!q.isEmpty())
		{
			int cur = q.poll();

			for (int i = 0; i < 4; i++)
			{
				for (int j = 0; j < 10; j++)
				{
					char[] arr = ("" + cur).toCharArray();
					arr[i] = (char) (48 + j);
					String nxtStr = String.valueOf(arr);
					int nxt = Integer.parseInt(nxtStr);

					if (nxt == afterNum)
					{
						sb.append(dis[cur] + "\n");
						return;
					}

					if (nxt < 1000 || !isPrime[nxt] || dis[nxt] != 0)
						continue;
					
					q.offer(nxt);
					dis[nxt] = dis[cur] + 1;
				}
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
		isPrime = new boolean[10000];
		
		for (int i = 0; i < 10000; i++)
			isPrime[i] = true;

		for (int i = 2; i < Math.sqrt(10000); i++)
		{
			if (isPrime[i])
			{
				for (int j = 2; i * j < 10000; j++)
					isPrime[i * j] = false;
			}
		}

		for (int i = 0; i < t; i++)
		{
			st = new StringTokenizer(br.readLine());
			int before = Integer.parseInt(st.nextToken());
			int after = Integer.parseInt(st.nextToken());

			if (before == after)
			{
				sb.append(0 + "\n");
				continue;
			}

			BFS(before, after);
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
