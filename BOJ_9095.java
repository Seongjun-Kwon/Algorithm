import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		int[] DP = new int[11];
		
		DP[1] = 1;
		DP[2] = 2;
		DP[3] = 4;
		
		for (int i = 4; i < DP.length; i++)
			DP[i] = DP[i - 1] + DP[i - 2] + DP[i - 3];

		for (int i = 0; i < t; i++)
		{
			int a = Integer.parseInt(br.readLine());
			sb.append(DP[a] + "\n");
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
