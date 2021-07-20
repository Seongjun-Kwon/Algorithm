import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;

		while ((str = br.readLine()) != null)
		{
			int ans[] = new int[4];

			for (int i = 0; i < str.length(); i++)
			{
				char a = str.charAt(i);
				if (a >= 'a' && a <= 'z')
					ans[0]++;
				else if (a >= 'A' && a <= 'Z')
					ans[1]++;
				else if (a >= '0' && a <= '9')
					ans[2]++;
				else if (a == ' ')
					ans[3]++;
			}

			for (int i = 0; i < 4; i++)
			{
				bw.write(Integer.toString(ans[i]) + " ");
			}

			bw.newLine();
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
