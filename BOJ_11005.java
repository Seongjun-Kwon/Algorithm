import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Long.parseLong(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		String str = "";

		while (n > 0)
		{
			int r = (int) n % b;
			if (r < 10)
				str += (char) (r + (int) '0');
			else
				str += (char) (r - 10 + (int) 'A');
			n /= b;
		}

		char[] ans = new char[str.length()];

		for (int i = str.length() - 1; i >= 0; i--)
		{
			ans[i] = str.charAt(i);
			bw.write(Character.toString(ans[i]));
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
