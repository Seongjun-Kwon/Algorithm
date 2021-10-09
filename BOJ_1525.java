import java.io.*;
import java.util.*;

public class Main
{
	static int arr;
	static HashMap<Integer, Integer> check;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static void BFS(int x)
	{
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		check.put(x, 0);

		while (!q.isEmpty())
		{
			int cur = q.poll();
			String curStr = String.valueOf(cur);
			int idx = curStr.indexOf("9"); // 1차원 배열 상에서 0이 위치한 인덱스
			int row = idx / 3; // 2차원 배열 상에서 0의 행
			int col = idx % 3; // 2차원 배열 상에서 0의 열

			for (int i = 0; i < 4; i++)
			{
				int nxtRow = row + dy[i];
				int nxtCol = col + dx[i];
				int nxtIdx = nxtRow * 3 + nxtCol; // 1차원 배열 상에서 0이 이동할 곳의 인덱스
				
				if (nxtRow < 0 || nxtRow > 2 || nxtCol < 0 || nxtCol > 2)
					continue;
				
				// 0의 위치를 바꿔 준다
				StringBuilder sb = new StringBuilder(curStr);
				char tmp = sb.charAt(nxtIdx);
				sb.setCharAt(nxtIdx, '9');
				sb.setCharAt(idx, tmp);
				int nxt = Integer.parseInt(sb.toString());
				
				if (check.get(nxt) != null)
					continue;
				
				check.put(nxt, check.get(cur) + 1);
				q.add(nxt);
			}
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		arr = 0;
		check = new HashMap<>();

		for (int i = 0; i < 3; i++)
		{
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 3; j++)
			{
				int a = Integer.parseInt(st.nextToken());
				
				if (a == 0)
					a = 9;
				
				arr = (arr * 10) + a;
			}
		}

		BFS(arr);

		if (check.get(123456789) == null)
		{
			bw.write("-1");
			br.close();
			bw.flush();
			bw.close();
			return;
		}

		bw.write(Integer.toString(check.get(123456789)));
		br.close();
		bw.flush();
		bw.close();
	}
}
