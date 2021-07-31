import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		String[] arr = { "000", "001", "010", "011", "100", "101", "110", "111" };

		if (str.length() == 1 && str.charAt(0) == '0')
			sb.append('0');
		else
		{
			for (int i = 0; i < str.length(); i++)
			{
				int n = (int) (str.charAt(i) - 48);

				if (i == 0 && n <= 3)
				{
					if (n == 1)
						sb.append("1");
					else if (n == 2)
						sb.append("10");
					else if (n == 3)
						sb.append("11");
				}
				else
					sb.append(arr[n]);
			}
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
