import java.io.*;
import java.util.*;

public class Main
{
	static int n, k;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 1; i <= n; i++)
			al.add(i);
		
		sb.append("<");
		int idx = -1;

		while (!al.isEmpty())
		{
			idx = (idx + k) % n;
			sb.append(al.get(idx) + ", ");
			al.remove(idx);
			idx--;
			n--;
			if (n != 0)
				idx = (idx + n) % n;
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
	}
}
