import java.io.*;
import java.util.*;

public class Main
{
	static int getCnt(int a, int b)
	{
		int cnt = 0;

		while (a >= b)
		{
			cnt = cnt + (a / b);
			a /= b;
		}

		return cnt;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int cnt2 = getCnt(n, 2) - getCnt(m, 2) - getCnt(n - m, 2);
		int cnt5 = getCnt(n, 5) - getCnt(m, 5) - getCnt(n - m, 5);
		
		int ans = Math.min(cnt2, cnt5);
		bw.write(Integer.toString(ans));
		br.close();
		bw.flush();
		bw.close();
	}
}
