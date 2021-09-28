import java.io.*;
import java.util.*;

public class Main
{
	static int btnPossible(int num, boolean[] btnBroken) // 숫자 버튼만으로 이동이 가능할 시 누르는 버튼 수 반환
	{
		int cnt = 0;

		if (num == 0)
		{
			if (btnBroken[0])
				return cnt;
			else
				return 1;
		}

		while (num > 0)
		{
			if (btnBroken[num % 10])
				return 0;
			
			cnt++;
			num /= 10;
		}

		return cnt;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		boolean[] broken = new boolean[10];

		if (m != 0)
		{
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++)
				broken[Integer.parseInt(st.nextToken())] = true; // true면 고장, false면 정상
		}

		if (n == 100)
		{
			bw.write("0");
			br.close();
			bw.flush();
			bw.close();
			return;
		}

		int ans = Math.abs(n - 100); // +, - 버튼만으로 이동할 시 누르는 버튼 수
		int cnt = 0;

		for (int i = 0; i < 1000000; i++)
		{
			cnt = btnPossible(i, broken);

			if (cnt > 0)
			{
				if (ans > Math.abs(i - n) + cnt)
					ans = Math.abs(i - n) + cnt;
			}
		}

		bw.write(Integer.toString(ans));
		br.close();
		bw.flush();
		bw.close();
	}
}
