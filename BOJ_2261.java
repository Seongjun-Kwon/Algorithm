import java.io.*;
import java.util.*;

public class Main
{
	static int n;
	static Pair[] arr;

	static class Pair implements Comparable<Pair>
	{
		int x, y;

		public Pair(int x, int y)
		{
			this.x = x;
			this.y = y;
		}

		public int compareTo(Pair args)
		{
			return this.x - args.x;
		}
	}

	static Comparator<Pair> yCom = new Comparator<Pair>()
	{
		public int compare(Pair a, Pair b)
		{
			return a.y - b.y;
		}
	};

	static int dis(Pair a, Pair b)
	{
		return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
	}

	static int bruteForce(int start, int end)
	{
		int minDis = Integer.MAX_VALUE;

		for (int i = start; i < end; i++)
		{
			for (int j = i + 1; j <= end; j++)
				minDis = Math.min(minDis, dis(arr[i], arr[j]));
		}

		return minDis;
	}

	static int divideConquer(int start, int end)
	{
		if (end - start + 1 < 4)
			return bruteForce(start, end);
		
		int mid = (start + end) / 2;
		int left = divideConquer(start, mid);
		int right = divideConquer(mid + 1, end);
		int minDis = Math.min(left, right);
		
		ArrayList<Pair> list = new ArrayList<>();

		for (int i = start; i <= end; i++)
		{
			int tmp = arr[mid].x - arr[i].x;
			
			if (tmp * tmp < minDis)
				list.add(arr[i]);
		}

		Collections.sort(list, yCom);

		for (int i = 0; i < list.size() - 1; i++)
		{
			for (int j = i + 1; j < list.size(); j++)
			{
				int tmp = list.get(i).y - list.get(j).y;
				
				if (tmp * tmp < minDis)
					minDis = Math.min(minDis, dis(list.get(i), list.get(j)));
				
				else
					break;
			}
		}

		return minDis;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new Pair[n];

		for (int i = 0; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Pair(x, y);
		}

		Arrays.sort(arr);
		
		bw.write(Integer.toString(divideConquer(0, n - 1)));
		br.close();
		bw.flush();
		bw.close();
	}
}
