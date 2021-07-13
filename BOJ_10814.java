import java.io.*;
import java.util.*;

public class Main
{
	static int n;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		String member[][] = new String[n][2];

		for (int i = 0; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			member[i][0] = st.nextToken();
			member[i][1] = st.nextToken();
		}

		Arrays.sort(member, new Comparator<String[]>()
		{
			public int compare(String[] s1, String[] s2)
			{
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			}
		});
		
		for(int i=0; i<n; i++)
		{
			System.out.println(member[i][0]+' '+member[i][1]);
		}
	}
}
