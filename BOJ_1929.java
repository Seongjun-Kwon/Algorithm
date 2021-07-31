import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		boolean[] isPrime = new boolean[n + 1];
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i < n + 1; i++)
			isPrime[i] = true;

		for (int i = 2; i <= Math.sqrt(n); i++)
		{
			if (isPrime[i] == true)
			{
				for (int j = 2; i * j <= n; j++)
					isPrime[i * j] = false;
			}
		}

		for (int i = m; i <= n; i++)
		{
			if (isPrime[i] == true)
				bw.write(Integer.toString(i) + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
