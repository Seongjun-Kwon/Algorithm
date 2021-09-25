import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String n = br.readLine();
		String[] str = n.split("");
		
		long sum = 0;
		for (int i = 0; i < n.length(); i++)
			sum += Long.parseLong(str[i]);

		if (!n.contains("0") || (sum % 3) != 0)
		{
			bw.write("-1");
			br.close();
			bw.flush();
			bw.close();
			return;
		}

		Arrays.sort(str, Collections.reverseOrder());
		
		for (int i = 0; i < str.length; i++)
			sb.append(str[i]);
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
