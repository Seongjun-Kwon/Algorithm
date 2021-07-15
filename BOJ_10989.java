import java.io.*;

public class Main
{
	static int n;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		int cnt[] = new int[10005];

		for (int i = 0; i < n; i++)
		{
			cnt[Integer.parseInt(br.readLine())]++;
		}

		for (int i = 1; i <= 10000; i++)
		{
			if (cnt[i] > 0)
			{
				for (int j = 0; j < cnt[i]; j++)
				{
					bw.write(i + "\n");
				}
			}
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
