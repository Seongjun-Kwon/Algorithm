import java.io.*;
import java.util.*;

public class Main
{
	static int n;
	static int result;
	static int[] arr = new int[n];
	static int[] tmp = new int[n];
	static boolean[] visit = new boolean[n];

	static int getResult()
	{
		int sum = 0;
		
		for (int i = 0; i < n - 1; i++)
			sum += Math.abs(tmp[i] - tmp[i + 1]);
		
		return sum;
	}

	static void DFS(int idx)
	{
		if (idx == n)
		{
			result = Math.max(getResult(), result);
			return;
		}

		for (int i = 0; i < n; i++)
		{
			if (!visit[i])
			{
				tmp[idx] = arr[i];
				visit[i] = true;
				DFS(idx + 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		tmp = new int[n];
		visit = new boolean[n];
		result = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		DFS(0);
		
		bw.write(Integer.toString(result));
		br.close();
		bw.flush();
		bw.close();
	}
}
