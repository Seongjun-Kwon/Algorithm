import java.io.*;
import java.util.*;

public class Main
{
	static int f, s, g, u, d;
	static int[] button;
	static int tmp;
	static int[] dis;

	static void BFS(int start)
	{
		Queue<Integer> q = new LinkedList<>();
		dis[start] = 0;
		q.add(start);

		while (!q.isEmpty())
		{
			int cur = q.poll();

			if (cur == g)
			{
				tmp = dis[cur];
				break;
			}

			for (int i = 0; i < 2; i++)
			{
				int nxt = cur + button[i];
				
				if (nxt < 1 || nxt > f)
					continue;
				
				if (dis[nxt] >= 0)
					continue;
				
				dis[nxt] = dis[cur] + 1;
				q.add(nxt);
			}
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		button = new int[] { u, -d };
		tmp = -1;
		dis = new int[f + 1];
		
		Arrays.fill(dis, -1);
		BFS(s);

		if (tmp == -1)
		{
			bw.write("use the stairs");
			br.close();
			bw.flush();
			bw.close();
			return;
		}

		bw.write(Integer.toString(tmp));
		br.close();
		bw.flush();
		bw.close();
	}
}
