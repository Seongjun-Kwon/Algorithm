import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int cnt[] = new int[26];

		for (char a = 'a'; a <= 'z'; a++)
		{
			for (int i = 0; i < str.length(); i++)
			{
				if (a == str.charAt(i))
				{
					cnt[a - 97] = i + 1;
					break;
				}
			}
		}

		for (int i = 0; i < 26; i++)
		{
			if (cnt[i] == 0)
				bw.write(Integer.toString(-1) + " ");
			else
				bw.write(Integer.toString(cnt[i] - 1) + " ");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
