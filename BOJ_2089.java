import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		if (n == 0)
			bw.write('0');

		while (n != 0)
		{
			int r = n % (-2);
			n /= (-2);

			if (r < 0)
			{
				r = r * (-1);
				n++;
			}

			sb.append(r);
		}

		bw.write(sb.reverse().toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
