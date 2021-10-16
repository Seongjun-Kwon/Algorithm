import java.io.*;
import java.util.*;

public class Main
{
	static int n, m, k, ans;
	static String word;
	static char[][] arr;
	static int[][][] DP;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	static int DFS(int r, int c, int idx) // (r,c)에서 출발하고 (r,c)에 있는 문자를 word의 idx 인덱스로 탐색했을 시의 경우의 수
	{
		if (idx == word.length() - 1)
		{
			DP[r][c][idx] = 1;
			return DP[r][c][idx];
		}

		if (DP[r][c][idx] != -1)
			return DP[r][c][idx];
		
		DP[r][c][idx] = 0;

		for (int i = 0; i < 4; i++)
		{
			for (int j = 1; j < k + 1; j++)
			{
				int nx = r + dx[i] * j;
				int ny = c + dy[i] * j;
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				
				if (arr[nx][ny] != word.charAt(idx + 1))
					continue;
				
				DP[r][c][idx] += DFS(nx, ny, idx + 1);
			}
		}

		return DP[r][c][idx];
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		ans = 0;
		arr = new char[n][m];

		for (int i = 0; i < n; i++)
		{
			String str = br.readLine();
			
			for (int j = 0; j < m; j++)
				arr[i][j] = str.charAt(j);
		}

		word = br.readLine();
		DP = new int[n][m][word.length()];

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				for (int k = 0; k < word.length(); k++)
					DP[i][j][k] = -1;
			}
		}

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				if (arr[i][j] == word.charAt(0))
					ans += DFS(i, j, 0);
			}
		}

		bw.write(Integer.toString(ans));
		br.close();
		bw.flush();
		bw.close();
	}
}
