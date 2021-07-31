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
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		for (int i = m - 1; i >= 0; i--)
			sum += Integer.parseInt(st.nextToken()) * Math.pow(A, i);
		
		Stack<Integer> sta = new Stack<Integer>();
		if (m == 1 && sum == 0)
			bw.write("0");
		else
		{
			while (sum != 0)
			{
				sta.push(sum % B);
				sum /= B;
			}
		}

		while (!sta.empty())
			sb.append(sta.pop() + " ");
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
