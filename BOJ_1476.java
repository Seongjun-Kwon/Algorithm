import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		int e = Integer.parseInt(str[0]);
		int s = Integer.parseInt(str[1]);
		int m = Integer.parseInt(str[2]);
		int ans = 1;
		int a = 1, b = 1, c = 1;

		if (e == 1 && s == 1 && m == 1)
		{
			bw.write("1");
			br.close();
			bw.flush();
			bw.close();
			return;
		}

		while (ans < 7980)
		{
			a++;
			b++;
			c++;
			ans++;
			
			if (a > 15)
				a = 1;
			
			if (b > 28)
				b = 1;
			
			if (c > 19)
				c = 1;
			
			if (a == e && b == s && c == m)
				break;
		}

		bw.write(Integer.toString(ans));
		br.close();
		bw.flush();
		bw.close();
	}
}
