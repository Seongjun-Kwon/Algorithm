import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	private static int n;
	private static int[][] profit;
	private static int[][] profitSum; // profitSum[i][j] = (0,0) ~ (i,j) 까지 이익의 합
	private static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		profit = new int[n + 1][n + 1];
		profitSum = new int[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 1; j < n + 1; j++) {
				profit[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				profitSum[i][j] = profitSum[i - 1][j] + profitSum[i][j - 1] - profitSum[i - 1][j - 1] + profit[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			solve(i);
		}

		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}

	private static void solve(int k) { // 시작점이 (i,j) 이고 길이가 k x k 인 정사각형에서의 총 이익
		for (int i = 1; i < n - k + 1; i++) {
			for (int j = 1; j < n - k + 1; j++) {
				int tmpMax =
						profitSum[i + k][j + k] - profitSum[i - 1][j + k] - profitSum[i + k][j - 1] + profitSum[i - 1][j - 1];
				answer = Math.max(answer, tmpMax);
			}
		}
	}
}
