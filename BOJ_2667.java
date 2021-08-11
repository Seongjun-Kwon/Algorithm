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
	static int n, cnt, area;
	static int[][] board;
	static boolean[][] vis;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static List<Integer> areaNum;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		vis = new boolean[n][n];
		areaNum = new ArrayList<>();
		Queue<pair> q = new LinkedList<>();

		for (int i = 0; i < n; i++)
		{
			String[] st = br.readLine().split("");
			for (int j = 0; j < n; j++)
				board[i][j] = Integer.parseInt(st[j]);
		}

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if ((board[i][j] == 0) || vis[i][j])
					continue;
				q.offer(new pair(i, j));
				vis[i][j] = true;
				cnt++;
				area = 0;

				while (!q.isEmpty())
				{
					pair p = q.poll();
					area++;

					for (int k = 0; k < 4; k++)
					{
						int nx = p.x + dx[k];
						int ny = p.y + dy[k];
						if (nx < 0 || nx >= n || ny < 0 || ny >= n)
							continue;
						if (board[nx][ny] == 0 || vis[nx][ny])
							continue;
						q.offer(new pair(nx, ny));
						vis[nx][ny] = true;
					}
				}
				areaNum.add(area);
			}
		}

		Collections.sort(areaNum);
		sb.append(cnt + "\n");
		for (int i = 0; i < areaNum.size(); i++)
			sb.append(areaNum.get(i) + "\n");
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
