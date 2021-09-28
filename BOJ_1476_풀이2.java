import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		int e = Integer.parseInt(str[0]) - 1;
		int s = Integer.parseInt(str[1]) - 1;
		int m = Integer.parseInt(str[2]) - 1;

		for (int i = 0;; i++)
		{
			if (i % 15 == e && i % 28 == s && i % 19 == m)
			{
				bw.write(Integer.toString(i + 1));
				br.close();
				bw.flush();
				bw.close();
				return;
			}
		}
	}
}
