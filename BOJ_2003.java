import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int cnt = 0, start = 0, end = 0, sum = arr[0];

		while (true)
		{
			if (sum == m)
			{
				sum -= arr[start++];
				sum += arr[++end];
				cnt++;
			}
			else if (sum < m)
				sum += arr[++end];
			else if (sum > m)
				sum -= arr[start++];

			if (end == n)
				break;
		}

		bw.write(Integer.toString(cnt));
		br.close();
		bw.flush();
		bw.close();
	}
}
