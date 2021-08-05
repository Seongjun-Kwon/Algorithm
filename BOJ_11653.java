import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		boolean[] isPrime = new boolean[n + 1];
		List<Integer> Prime = new ArrayList<>();
		
		if (n == 1)
			return;
		
		isPrime[1] = false;
		for (int i = 2; i <= n; i++)
			isPrime[i] = true;

		for (int i = 2; i <= Math.sqrt(n); i++)
		{
			if (isPrime[i] == true)
			{
				for (int j = 2; i * j <= n; i++)
				{
					isPrime[i * j] = false;
				}
			}
		}

		for (int i = 2; i <= n; i++)
		{
			if (isPrime[i] == true)
				Prime.add(i);
		}

		while (n != 1)
		{
			for (int i = 0; i < Prime.size(); i++)
			{

				if ((n % Prime.get(i)) != 0)
					continue;
				else
				{
					n /= Prime.get(i);
					sb.append(Prime.get(i) + "\n");
					break;
				}
			}
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
