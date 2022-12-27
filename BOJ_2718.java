import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int T;
	static int N;
	static int[][] dp;

	// dp[i][j] = 4 x i 타일에서 i번째 열 타일을 j 상태로 채우는 경우의 수 (i번째 이전 타일들은 다 채워져 있음)
	// j=0  j=1  j=2  j=3  j=4
	// x	 o	  o	   x	x
	// x	 x	  o	   x	o
	// x	 x	  x	   o	o
	// x	 o	  x	   o	x

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			dp = new int[N + 2][5];
			dp[1][0] = 1;

			for (int j = 2; j < N + 2; j++) {
				dp[j][0] = dp[j - 2][0] + dp[j - 1][0] + dp[j - 1][1] + dp[j - 1][2] + dp[j - 1][3];
				dp[j][1] = dp[j - 1][0] + dp[j - 1][4];
				dp[j][2] = dp[j - 1][0] + dp[j - 1][3];
				dp[j][3] = dp[j - 1][0] + dp[j - 1][2];
				dp[j][4] = dp[j - 1][1];
			}

			sb.append(dp[N + 1][0]).append('\n');
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
