import java.io.*;
import java.util.*;

public class Main
{
	static int n, m, lo, hi, mid, cnt;
	static int[] nCard;
	static int[] mCard;

	static int lowerBound(int target)
	{
		lo = -1;
		hi = n;

		while (lo + 1 < hi)
		{
			mid = (lo + hi) / 2;
			
			if (nCard[mid] >= target)
				hi = mid;
			
			else
				lo = mid;
		}
		return hi;
	}

	static int upperBound(int target)
	{
		lo = -1;
		hi = n;

		while (lo + 1 < hi)
		{
			mid = (lo + hi) / 2;
			
			if (nCard[mid] <= target)
				lo = mid;
			
			else
				hi = mid;
		}
		return hi;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		nCard = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++)
			nCard[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(nCard);
		
		m = Integer.parseInt(br.readLine());
		mCard = new int[m];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++)
		{
			mCard[i] = Integer.parseInt(st.nextToken());
			int cnt = upperBound(mCard[i]) - lowerBound(mCard[i]);
			sb.append(cnt + " ");
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
