import java.io.*;
import java.util.*;

public class Main
{
	static int k, n;
	static long left, right, mid;
	static List<Integer> list;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		k = Integer.parseInt(str[0]);
		n = Integer.parseInt(str[1]);
		left = 1;
		right = -1;
		list = new ArrayList<>();

		for (int i = 0; i < k; i++)
		{
			int length = Integer.parseInt(br.readLine());
			list.add(length);
			right = Math.max(right, length);
		}

		while (left <= right)
		{
			int sum = 0;
			mid = (left + right) / 2;
			
			for (int i = 0; i < k; i++)
				sum += list.get(i) / mid;
			
			if (sum < n)
				right = mid - 1;
			
			else if (sum >= n)
				left = mid + 1;
		}

		bw.write(Long.toString(left - 1));
		br.close();
		bw.flush();
		bw.close();
	}
}
