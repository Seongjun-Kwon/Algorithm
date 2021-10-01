import java.io.*;
import java.util.*;

public class Main
{
	static int n, m;
	static long result;
	static int[][] arr;

	static long getSum(int x1, int y1, int x2, int y2)
	{
		long sum = 0;

		for (int i = y1; i <= y2; i++)
		{
			for (int j = x1; j <= x2; j++)
				sum += arr[i][j];
		}

		return sum;
	}

	static void Rec1()
	{
		for (int i = 0; i < m - 2; i++)
		{
			for (int j = i + 1; j < m - 1; j++)
			{
				long a = getSum(0, 0, i, n - 1);
				long b = getSum(i + 1, 0, j, n - 1);
				long c = getSum(j + 1, 0, m - 1, n - 1);
				
				if (a * b * c > result)
					result = a * b * c;
			}
		}
	}

	static void Rec2()
	{
		for (int i = 0; i < n - 2; i++)
		{
			for (int j = i + 1; j < n - 1; j++)
			{
				long a = getSum(0, 0, m - 1, i);
				long b = getSum(0, i + 1, m - 1, j);
				long c = getSum(0, j + 1, m - 1, n - 1);
				
				if (a * b * c > result)
					result = a * b * c;
			}
		}
	}

	static void Rec3()
	{
		for (int i = 0; i < n - 1; i++)
		{
			for (int j = 0; j < m - 1; j++)
			{
				long a = getSum(0, 0, m - 1, i);
				long b = getSum(0, i + 1, j, n - 1);
				long c = getSum(j + 1, i + 1, m - 1, n - 1);
				
				if (a * b * c > result)
					result = a * b * c;
			}
		}
	}

	static void Rec4()
	{
		for (int i = 0; i < n - 1; i++)
		{
			for (int j = 0; j < m - 1; j++)
			{
				long a = getSum(0, 0, j, i);
				long b = getSum(j + 1, 0, m - 1, i);
				long c = getSum(0, i + 1, m - 1, n - 1);
				
				if (a * b * c > result)
					result = a * b * c;
			}
		}
	}

	static void Rec5()
	{
		for (int i = 0; i < n - 1; i++)
		{
			for (int j = 0; j < m - 1; j++)
			{
				long a = getSum(0, 0, j, i);
				long b = getSum(0, i + 1, j, n - 1);
				long c = getSum(j + 1, 0, m - 1, n - 1);
				
				if (a * b * c > result)
					result = a * b * c;
			}
		}
	}

	static void Rec6()
	{
		for (int i = 0; i < n - 1; i++)
		{
			for (int j = 0; j < m - 1; j++)
			{
				long a = getSum(0, 0, j, n - 1);
				long b = getSum(j + 1, 0, m - 1, i);
				long c = getSum(j + 1, i + 1, m - 1, n - 1);
				
				if (a * b * c > result)
					result = a * b * c;
			}
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		result = Integer.MIN_VALUE;
		arr = new int[n][m];

		for (int i = 0; i < n; i++)
		{
			char[] tmp = br.readLine().toCharArray();
			
			for (int j = 0; j < m; j++)
				arr[i][j] = tmp[j] - '0';
		}

		Rec1();
		Rec2();
		Rec3();
		Rec4();
		Rec5();
		Rec6();
		
		bw.write(Long.toString(result));
		br.close();
		bw.flush();
		bw.close();
	}
}
