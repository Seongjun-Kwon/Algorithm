import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int a = 2;

		while (n != 1)
		{
			if ((n % a) == 0)
			{
				n /= a;
				sb.append(a + "\n");
			}
			else
				a++;
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
