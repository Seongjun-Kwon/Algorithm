import java.io.*;
import java.util.*;

public class Main
{
	static int v, e, start;
	static List<D>[] adj;
	static int[] dis;
	static boolean[] vis;

	static class D implements Comparable<D>
	{
		int v, w;

		public D(int v, int w)
		{
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(D args)
		{
			return this.w <= args.w ? -1 : 1;
		}
	}

	static void Dijkstra(int x)
	{
		PriorityQueue<D> pq = new PriorityQueue<>();
		dis[x] = 0;
		pq.add(new D(x, dis[x]));

		while (!pq.isEmpty())
		{
			D edge = pq.poll();
			int cur = edge.v;
			int curdis = edge.w;
			vis[cur] = true;
			if (dis[cur] < curdis)
				continue;

			for (int i = 0; i < adj[cur].size(); i++)
			{
				int nxt = adj[cur].get(i).v;
				int nxtdis = adj[cur].get(i).w;

				if (curdis + nxtdis < dis[nxt])
				{
					dis[nxt] = curdis + nxtdis;
					pq.add(new D(nxt, dis[nxt]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		dis = new int[v + 1];
		vis = new boolean[v + 1];
		adj = new ArrayList[v + 1];
		
		for (int i = 1; i <= v; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < e; i++)
		{
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[u].add(new D(v, w));
		}

		Arrays.fill(dis, Integer.MAX_VALUE);
		Dijkstra(start);

		for (int i = 1; i <= v; i++)
		{
			if (dis[i] == Integer.MAX_VALUE)
				bw.write("INF" + "\n");
			else
				bw.write(Integer.toString(dis[i]) + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
