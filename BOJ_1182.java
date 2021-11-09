import java.io.*;
import java.util.*;

public class Main
{
	static int n, s;
	static int cnt, ans;
	static int[] arr;
	static boolean[] vis;

	static void DFS(int idx, int sum)
	{
		if (idx == n)
		{
			if (sum == s)
				cnt++;

			return;
		}

		DFS(idx + 1, sum);
		DFS(idx + 1, sum + arr[idx]);
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		cnt = 0;
		arr = new int[n];
		vis = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		DFS(0, 0);
		
		if (s == 0)
			ans = cnt - 1;
		else
			ans = cnt;
		
		bw.write(Integer.toString(ans));
		br.close();
		bw.flush();
		bw.close();
	}
}
