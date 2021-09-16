import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] nCard = new int[20000001];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++)
		{
			int cnt = Integer.parseInt(st.nextToken());
			nCard[cnt + 10000000]++;
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++)
		{
			int num = Integer.parseInt(st.nextToken());
			sb.append(nCard[num + 10000000] + " ");
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
