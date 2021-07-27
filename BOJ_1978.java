import java.io.*;
import java.util.*;

public class Main
{
	static boolean isPrime(int x)
	{
		if (x == 1)
			return false;

		for (int i = 2; i <= 1000; i++)
		{
			if (x == i)
				continue;
			if (x % i == 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cnt = 0;
		int n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
		{
			int x = Integer.parseInt(st.nextToken());
			if (isPrime(x) == true)
				cnt++;
		}

		bw.write(Integer.toString(cnt));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
