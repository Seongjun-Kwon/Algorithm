import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int ans = 0;
		
		if (n == 1)
			ans = 1;
		
		else if (n == 2)
			ans = Math.min(4, (m - 1) / 2 + 1);
		
		else if (n >= 3)
		{
			if (m < 7)
				ans = Math.min(4, m);
			
			else
				ans = m - 2;
		}
		
		bw.write(Integer.toString(ans));
		br.close();
		bw.flush();
		bw.close();
	}
}
