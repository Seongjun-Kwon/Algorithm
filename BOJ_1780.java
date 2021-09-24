import java.io.*;
import java.util.*;

public class Main
{
	static int[][] arr;
	static int[] cnt;

	static boolean isPossible(int a, int b, int length)
	{
		for (int i = a; i < a + length; i++)
		{
			for (int j = b; j < b + length; j++)
			{
				if (arr[i][j] != arr[a][b])
					return false;
			}
		}

		return true;
	}

	static void DivideConquer(int a, int b, int length)
	{

		if (isPossible(a, b, length))
			cnt[arr[a][b] + 1]++;
		
		else
		{
			int newLength = length / 3;

			for (int i = 0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
					DivideConquer(a + i * newLength, b + j * newLength, newLength);
			}
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		cnt = new int[3];

		for (int i = 0; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		DivideConquer(0, 0, n);
		sb.append(cnt[0] + "\n" + cnt[1] + "\n" + cnt[2]);
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}
}
