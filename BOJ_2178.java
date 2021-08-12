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
	static int n, m;
	static int[][] board;
	static int[][] dis;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n + 1][m + 1];
		dis = new int[n + 1][m + 1];
		Queue<pair> q = new LinkedList<>();

		for (int i = 1; i <= n; i++)
		{
			String[] str = br.readLine().split("");

			for (int j = 1; j <= m; j++)
			{
				board[i][j] = Integer.parseInt(str[j - 1]);
				dis[i][j] = -1;
			}
		}

		q.offer(new pair(1, 1));
		dis[1][1] = 0;

		while (!q.isEmpty())
		{
			pair nxt = q.poll();
			
			if (nxt.x == n && nxt.y == m)
				break;

			for (int i = 0; i < 4; i++)
			{
				int nx = nxt.x + dx[i];
				int ny = nxt.y + dy[i];
				if (nx < 1 || nx > n || ny < 1 || ny > m)
					continue;
				if ((board[nx][ny]) == 0 || (dis[nx][ny] >= 0))
					continue;
				q.offer(new pair(nx, ny));
				dis[nx][ny] = dis[nxt.x][nxt.y] + 1;
			}
		}

		bw.write(Integer.toString(dis[n][m] + 1));
		br.close();
		bw.flush();
		bw.close();
	}
}
