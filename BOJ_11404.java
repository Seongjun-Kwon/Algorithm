import java.io.*;
import java.util.*;

public class Main
{
	static int[][] D;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		D = new int[n + 1][n + 1];
		
		for (int a[] : D)
			Arrays.fill(a, 100 * 100000);

		while (m-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			D[a][b] = Math.min(D[a][b], c);
		}

		for (int i = 1; i <= n; i++)
			D[i][i] = 0;

		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				for (int k = 1; k <= n; k++)
				{
					D[j][k] = Math.min(D[j][k], D[j][i] + D[i][k]);
				}
			}
		}

		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= n; j++)
			{
				if (D[i][j] == 100 * 100000)
					bw.write("0 ");
				else
					bw.write(Integer.toString(D[i][j]) + " ");
			}

			bw.write("\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
