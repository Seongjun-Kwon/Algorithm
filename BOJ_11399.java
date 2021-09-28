import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int ans = 0;
		int n = Integer.parseInt(br.readLine());
		int[] Time = new int[n];
		int[] TimeSum = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			Time[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(Time);

		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j <= i; j++)
				TimeSum[i] += Time[j];

			ans += TimeSum[i];
		}

		bw.write(Integer.toString(ans));
		br.close();
		bw.flush();
		bw.close();
	}
}
