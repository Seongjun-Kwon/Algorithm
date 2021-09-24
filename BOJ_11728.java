import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] a = new int[n];
		int[] b = new int[m];
		int[] c = new int[n + m];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++)
			b[i] = Integer.parseInt(st.nextToken());
		
		int aidx = 0;
		int bidx = 0;
		for (int i = 0; i < n + m; i++)
		{
			if (aidx == n)
				c[i] = b[bidx++];
			
			else if (bidx == m)
				c[i] = a[aidx++];
			
			else if (a[aidx] <= b[bidx])
				c[i] = a[aidx++];
			
			else
				c[i] = b[bidx++];
		}

		for (int i = 0; i < c.length; i++)
			sb.append(c[i]+" ");
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
