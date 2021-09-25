import java.io.*;
import java.util.*;

public class Main
{
	static int n;
	static char[][] arr;

	static void DivideConquer(int a, int b, int length)
	{
		if (length == 3)
		{
			arr[a][b] = '*';
			arr[a + 1][b - 1] = arr[a + 1][b + 1] = '*';
			arr[a + 2][b - 2] = arr[a + 2][b - 1] = arr[a + 2][b] = arr[a + 2][b + 1] = arr[a + 2][b + 2] = '*';
			return;
		}

		int newLength = length / 2;
		
		DivideConquer(a, b, newLength);
		DivideConquer(a + newLength, b - newLength, newLength);
		DivideConquer(a + newLength, b + newLength, newLength);
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		arr = new char[n][2 * n - 1];
		
		for (int i = 0; i < n; i++)
			Arrays.fill(arr[i], ' ');
		
		DivideConquer(0, n - 1, n);

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
