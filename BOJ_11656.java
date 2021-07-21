import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		String[] ans = new String[str.length()];

		for (int i = 0; i < str.length(); i++)
		{
			ans[i] = str.substring(i);
		}

		Arrays.sort(ans);
		
		for (int i = 0; i < ans.length; i++)
			sb.append(ans[i] + "\n");
		
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}
}
