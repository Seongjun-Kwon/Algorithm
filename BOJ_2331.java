import java.io.*;
import java.util.*;

public class Main
{
	static int a, p, m, val, count, sum;
	static int[] result;

	static int cal(int x)
	{
		val = 0;

		while (x != 0)
		{
			m = x % 10;
			val += Math.pow(m, p);
			x /= 10;
		}

		return val;
	}

	static int DFS(int x)
	{
		result[x] = count;
		sum = cal(x);

		if (result[sum] != 0)
			return (result[sum] - 1);
		else
		{
			count++;
			result[sum] = count;
			return DFS(sum);
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] st = br.readLine().split(" ");
		
		a = Integer.parseInt(st[0]);
		p = Integer.parseInt(st[1]);
		result = new int[1000000];
		count = 1;
		
		bw.write(Integer.toString(DFS(a)));
		br.close();
		bw.flush();
		bw.close();
	}
}
