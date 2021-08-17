import java.io.*;
import java.util.*;

class pair
{
	int x, y;

	public pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}

public class Main
{
	static int n, cnt;
	static int ans = Integer.MAX_VALUE;
	static int[][] board;
	static boolean[][] vis;
	static int[][] dis;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static void DFS(int x, int y)
	{
		pair p = new pair(x, y);
		board[p.x][p.y] = cnt;
		vis[p.x][p.y] = true;

		for (int i = 0; i < 4; i++)
		{
			int nx = p.x + dx[i];
			int ny = p.y + dy[i];
      
			if (nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;
			if ((board[nx][ny] == 0) || (vis[nx][ny]))
				continue;
			DFS(nx, ny);
		}
	}

	static void BFS(int c)
	{
		Queue<pair> q = new LinkedList<>();
		
		for (int i = 0; i < n; i++)
			Arrays.fill(dis[i], -1);

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (board[i][j] == c)
				{
					q.offer(new pair(i, j));
					dis[i][j] = 0;
				}
			}
		}

		while (!q.isEmpty())
		{
			pair p = q.poll();

			for (int i = 0; i < 4; i++)
			{
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;

				if (board[nx][ny] > 0 && board[nx][ny] != c)
				{
					ans = Math.min(ans, dis[p.x][p.y]);
					return;
				}

				if (board[nx][ny] == 0 && dis[nx][ny] == -1)
				{
					q.offer(new pair(nx, ny));
					dis[nx][ny] = dis[p.x][p.y] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		vis = new boolean[n][n];
		dis = new int[n][n];
		cnt = 2;

		for (int i = 0; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				board[j][i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if ((board[j][i] == 1))
				{
					DFS(j, i);
					cnt++;
				}
			}
		}

		for (int i = 1; i < cnt; i++)
			BFS(i);
		
		if (ans == Integer.MAX_VALUE)
			ans = 0;
		
		bw.write(Integer.toString(ans));
		br.close();
		bw.flush();
		bw.close();
	}
}
