import java.io.*;
import java.util.*;

public class Main
{
	static char[][] arr;

	static void DivideConquer(int a, int b, int length)
	{
		if (length == 1)
		{
			arr[a][b] = '*';
			return;
		}

		int newLength = length / 3;

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (i == 1 && j == 1)
					continue;
				
				else
					DivideConquer(a + i * newLength, b + j * newLength, newLength);
			}
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		
		for (int i = 0; i < arr.length; i++)
			Arrays.fill(arr[i], ' ');
		
		DivideConquer(0, 0, n);

		for (int i = 0; i < n; i++)
		{
			bw.write(arr[i]);
			bw.write("\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
