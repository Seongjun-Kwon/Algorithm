import java.io.*;
import java.util.*;

public class Main
{
	static long n, m, lo, hi, mid;
	static List<Long> adj;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		adj = new ArrayList<>();
		
		lo = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
		{
			long length = Integer.parseInt(st.nextToken());
			adj.add(length);
			hi = Math.max(hi, length) + 1;
		}

		while (lo + 1 < hi)
		{
			mid = (lo + hi) / 2;
			long get = 0;

			for (int i = 0; i < n; i++)
			{
				if (adj.get(i) > mid)
					get += adj.get(i) - mid;
			}

			if (get >= m)
				lo = mid;
			
			else if (get < m)
				hi = mid;
		}

		bw.write(Long.toString(lo));
		br.close();
		bw.flush();
		bw.close();
	}
}
