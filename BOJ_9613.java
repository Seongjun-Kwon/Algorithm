import java.io.*;
import java.util.*;

public class Main
{
	public static long gcd(int x, int y)
	{
		if (y == 0)
			return x;
		else
			return gcd(y, x % y);
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(st.nextToken());

		for (int i = 0; i < t; i++)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			long sum = 0;

			for (int j = 0; j < n; j++)
			{
				arr[j] = Integer.parseInt(st.nextToken());
			}

			for (int a = 0; a < n; a++)
			{
				for (int b = a + 1; b < n; b++)
					sum += gcd(arr[a], arr[b]);
			}

			sb.append(sum + "\n");
		}

		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}
}
