import java.io.*;
import java.util.*;

public class Main
{
	static class Time implements Comparable<Time>
	{
		int start;
		int end;

		public Time(int start, int end)
		{
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time args)
		{
			if (this.end < args.end)
				return -1;
			
			else if (this.end == args.end)
				return this.start <= args.start ? -1 : 1;
			
			else
				return 1;
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int ans = 0; // 선택 가능한 최대 회의 수
		int time = 0; // 현재 시간
		int n = Integer.parseInt(br.readLine());
		Time[] TimeTable = new Time[n];

		for (int i = 0; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			TimeTable[i] = new Time(start, end);
		}

		Arrays.sort(TimeTable);

		for (int i = 0; i < n; i++)
		{
			if (time > TimeTable[i].start)
				continue;
			
			ans++;
			time = TimeTable[i].end;
		}

		bw.write(Integer.toString(ans));
		br.close();
		bw.flush();
		bw.close();
	}
}
