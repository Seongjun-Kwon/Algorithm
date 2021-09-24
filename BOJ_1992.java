import java.io.*;
import java.util.*;

public class Main
{
	static StringBuilder sb = new StringBuilder();
	static int[][] arr;

	static boolean isPossible(int a, int b, int length)
	{
		for (int i = a; i < a + length; i++)
		{
			for (int j = b; j < b + length; j++)
			{
				if (arr[i][j] != arr[a][b])
					return false;
			}
		}

		return true;
	}

	static void DivideConquer(int a, int b, int length)
	{
		if (isPossible(a, b, length))
			sb.append(arr[a][b]);
		
		else
		{
			sb.append("(");
			int newLength = length / 2;

			for (int i = 0; i < 2; i++)
			{
				for (int j = 0; j < 2; j++)
					DivideConquer(a + i * newLength, b + j * newLength, newLength);
			}

			sb.append(")");
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		for (int i = 0; i < n; i++)
		{
			String str1 = br.readLine();
			String[] str2 = str1.split("");
			
			for (int j = 0; j < n; j++)
				arr[i][j] = Integer.parseInt(str2[j]);
		}

		DivideConquer(0, 0, n);
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}
}
