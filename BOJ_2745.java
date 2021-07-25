import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String b = st.nextToken();
		String n = st.nextToken();
		
		char[] c = new char[b.length()];
		int sum = 0;

		for (int i = 0; i < b.length(); i++)
		{
			c[i] = b.charAt(i);
			if (c[i] >= '0' && c[i] <= '9')
				sum += (int) (c[i] - '0') * Math.pow(Integer.parseInt(n), b.length() - 1 - i);
			else if (c[i] >= 'A' && c[i] <= 'Z')
				sum += (10 + (int) (c[i] - 'A')) * Math.pow(Integer.parseInt(n), b.length() - 1 - i);
		}

		bw.write(Integer.toString(sum));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
