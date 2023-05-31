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

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		int[][] dp = new int[n][m];
		int maxSquareLength = 0;

		for (int i = 0; i < n; i++) {
			String line = br.readLine();

			for (int j = 0; j < line.length(); j++) {
				arr[i][j] = line.charAt(j) - '0';
				dp[i][j] = arr[i][j];
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (dp[i][j] == 0) {
					continue;
				}

				dp[i][j] = dp[i][j] + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (maxSquareLength < dp[i][j]) {
					maxSquareLength = dp[i][j];
				}
			}
		}

		bw.write(Integer.toString(maxSquareLength * maxSquareLength));
		br.close();
		bw.flush();
		bw.close();
	}
}
