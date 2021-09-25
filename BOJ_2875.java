import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		while (k > 0)
		{
			if (n / 2 >= m)
				n--;
			
			else
				m--;
			
			k--;
		}

		int team = Math.min(n / 2, m);
		
		bw.write(Integer.toString(team));
		br.close();
		bw.flush();
		bw.close();
	}
}
