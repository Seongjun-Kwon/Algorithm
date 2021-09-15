import java.io.*;
import java.util.*;

public class Main
{
	static int n, m, lo, hi, mid;
	static int[] nCard;
	static int[] mCard;

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
			lo = -1;
			hi = n;
			mCard[i] = Integer.parseInt(st.nextToken());

			while (lo + 1 < hi)
			{
				mid = (lo + hi) / 2;
				
				if (nCard[mid] > mCard[i])
					hi = mid;
				
				else if (nCard[mid] < mCard[i])
					lo = mid;
				
				else if (nCard[mid] == mCard[i])
					break;
			}

			if (nCard[mid] == mCard[i])
				sb.append("1 ");
			
			else
				sb.append("0 ");
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
