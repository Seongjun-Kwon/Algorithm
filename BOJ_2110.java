import java.io.*;
import java.util.Arrays;

public class Main
{
	static int n, c, lo, hi, mid;
	static int[] dis;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = br.readLine().split(" ");
		
		n = Integer.parseInt(str[0]);
		c = Integer.parseInt(str[1]);
		dis = new int[n];
		
		for (int i = 0; i < n; i++)
			dis[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(dis);
		
		lo = 1;
		hi = dis[n - 1];
		
		while (lo + 1 < hi)
		{
			mid = (lo + hi) / 2;
			int cnt = 1;
			int cur = dis[0];

			for (int i = 0; i < n; i++)
			{
				if (dis[i] - cur >= mid)
				{
					cnt++;
					cur = dis[i];
				}
			}

			if (cnt >= c)
				lo = mid;
			
			else if (cnt < c)
				hi = mid;
		}

		bw.write(Integer.toString(lo));
		br.close();
		bw.flush();
		bw.close();
	}
}
