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
		int team = 0;
		
		if (n / 2 >= m)
			team = m;
		
		else
			team = n / 2;
		
		int notTeam = n + m - 3 * team;
		k -= notTeam;

		while (k > 0)
		{
			team--;
			k -= 3;
		}

		bw.write(Integer.toString(team));
		br.close();
		bw.flush();
		bw.close();
	}
}
