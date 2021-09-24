import java.io.*;

public class Main
{
	static StringBuilder sb = new StringBuilder();

	static void move(int a, int b, int n) // 원판 n개를 기둥 a에서 기둥 b로 옮기는 메서드
	{
		if (n == 1)
		{
			sb.append(a + " " + b + "\n");
			return;
		}

		move(a, 6 - a - b, n - 1);
		sb.append(a + " " + b + "\n");
		move(6 - a - b, b, n - 1);
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		sb.append((int) (Math.pow(2, n) - 1) + "\n");
		move(1, 3, n);
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
