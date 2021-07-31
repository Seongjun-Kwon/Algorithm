import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(br.readLine());
		StringBuilder outsb = new StringBuilder();
		
		if (sb.length() % 3 == 2)
			sb.insert(0, "0");
		else if (sb.length() % 3 == 1)
			sb.insert(0, "00");

		for (int i = 0; i < sb.length(); i += 3)
		{
			int sum = 0;
			sum += (int) (sb.charAt(i) - 48) * 4;
			sum += (int) (sb.charAt(i + 1) - 48) * 2;
			sum += (int) (sb.charAt(i + 2) - 48) * 1;
			outsb.append(sum);
		}

		bw.write(outsb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
