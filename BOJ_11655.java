import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		char[] ans = new char[str.length()];

		for (int i = 0; i < str.length(); i++)
		{
			ans[i] = str.charAt(i);
			if ((ans[i] >= 'a' && ans[i] <= 'm') || (ans[i] >= 'A' && ans[i] <= 'M'))
				ans[i] += 13;
			else if ((ans[i] >= 'n' && ans[i] <= 'z') || (ans[i] >= 'N' && ans[i] <= 'Z'))
				ans[i] -= 13;
		}

		for (int i = 0; i < str.length(); i++)
			bw.write(Character.toString(ans[i]));
		br.close();
		bw.flush();
		bw.close();
	}
}
