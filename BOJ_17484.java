import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] fuel = new int[N][M];
		int[][][] dp = new int[N][M][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				fuel[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 3; j++) {
				dp[0][i][j] = fuel[0][i];
			}
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 3; k++) {
					if (k == 0) {
						if (j == M - 1) {
							dp[i][j][k] = Integer.MAX_VALUE;
						} else {
							dp[i][j][k] = fuel[i][j] + Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]);
						}
					} else if (k == 1) {
						dp[i][j][k] = fuel[i][j] + Math.min(dp[i - 1][j][0], dp[i - 1][j][2]);
					} else { // k == 2
						if (j == 0) {
							dp[i][j][k] = Integer.MAX_VALUE;
						} else {
							dp[i][j][k] = fuel[i][j] + Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]);
						}
					}
				}
			}
		}

		int answer = Integer.MAX_VALUE;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 3; j++) {
				if (answer > dp[N - 1][i][j]) {
					answer = dp[N - 1][i][j];
				}
			}
		}

		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}
}
