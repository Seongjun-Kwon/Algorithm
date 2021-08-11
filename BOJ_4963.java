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
	static int w, h, cnt;
	static int[][] board;
	static boolean[][] vis;
	static int[] dx = { 1, 1, 0, -1, -1, -1, 0, 1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String str = br.readLine();

		while (!str.equals("0 0"))
		{
			st = new StringTokenizer(str);
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			cnt = 0;
			board = new int[h][w];
			vis = new boolean[h][w];
			Queue<pair> q = new LinkedList<>();

			for (int i = 0; i < h; i++)
			{
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++)
					board[i][j] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < h; i++)
			{
				for (int j = 0; j < w; j++)
				{
					if ((board[i][j] == 0) || (vis[i][j] == true))
						continue;
					q.offer(new pair(i, j));
					vis[i][j] = true;
					cnt++;

					while (!q.isEmpty())
					{
						pair nxt = q.poll();

						for (int k = 0; k < 8; k++)
						{
							int nx = nxt.y + dx[k];
							int ny = nxt.x + dy[k];
							if (nx < 0 || nx >= w || ny < 0 || ny >= h)
								continue;
							if ((board[ny][nx] == 0) || (vis[ny][nx] == true))
								continue;
							q.offer(new pair(ny, nx));
							vis[ny][nx] = true;
						}
					}
				}
			}

			str = br.readLine();
			sb.append(cnt + "\n");
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
