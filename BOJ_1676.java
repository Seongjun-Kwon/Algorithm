import java.io.*;

public class Main
{
	static int n;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		int cnt2 = 0;
		int cnt5 = 0;

		for (int i = 2; i <= n; i++)
		{
			int a = i;

			while ((a % 2) == 0)
			{
				cnt2++;
				a /= 2;
			}

			while ((a % 5) == 0)
			{
				cnt5++;
				a /= 5;
			}
		}

		int ans = Math.min(cnt2, cnt5);
		bw.write(Integer.toString(ans));
		br.close();
		bw.flush();
		bw.close();
	}
}
