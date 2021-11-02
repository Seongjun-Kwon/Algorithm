import java.io.*;
import java.util.*;

public class Main
{
	static int r, c;
	static int ans;
	static char[][] arr;
	static boolean[] vis;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };

	static void DFS(int row, int col, int dis)
	{
		if (dis > ans)
			ans = dis;

		for (int i = 0; i < 4; i++)
		{
			int nxtR = dr[i] + row;
			int nxtC = dc[i] + col;
			
			if (nxtR < 0 || nxtR >= r || nxtC < 0 || nxtC >= c)
				continue;
			if (vis[arr[nxtR][nxtC] - 'A'])
				continue;
			
			vis[arr[nxtR][nxtC] - 'A'] = true;
			DFS(nxtR, nxtC, dis + 1);
			vis[arr[nxtR][nxtC] - 'A'] = false;
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		ans = 0;
		arr = new char[r][c];
		vis = new boolean[26];

		for (int i = 0; i < r; i++)
		{
			String str = br.readLine();
			
			for (int j = 0; j < c; j++)
				arr[i][j] = str.charAt(j);
		}

        vis[arr[0][0] - 'A'] = true;
		DFS(0, 0, 1);
		
		bw.write(Integer.toString(ans));
		br.close();
		bw.flush();
		bw.close();
	}
}
