import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int[][] board;
	private static int[][] maxSum; // maxSum[i][j] = i 행 j 열까지 더한 최댓값
	private static int[][] minSum; // minSum[i][j] = i 행 j 열까지 더한 최솟값
	private static int max = Integer.MIN_VALUE;
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		board = new int[N][3];
		maxSum = new int[N][3];
		minSum = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 3; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		maxSum[0][0] = board[0][0];
		maxSum[0][1] = board[0][1];
		maxSum[0][2] = board[0][2];
		minSum[0][0] = board[0][0];
		minSum[0][1] = board[0][1];
		minSum[0][2] = board[0][2];

		for (int i = 0; i < N - 1; i++) {
			maxSum[i + 1][0] = board[i + 1][0] + Math.max(maxSum[i][0], maxSum[i][1]);
			minSum[i + 1][0] = board[i + 1][0] + Math.min(minSum[i][0], minSum[i][1]);
			maxSum[i + 1][1] = board[i + 1][1] + Math.max(Math.max(maxSum[i][0], maxSum[i][1]), maxSum[i][2]);
			minSum[i + 1][1] = board[i + 1][1] + Math.min(Math.min(minSum[i][0], minSum[i][1]), minSum[i][2]);
			maxSum[i + 1][2] = board[i + 1][2] + Math.max(maxSum[i][1], maxSum[i][2]);
			minSum[i + 1][2] = board[i + 1][2] + Math.min(minSum[i][1], minSum[i][2]);
		}

		for (int i = 0; i < 3; i++) {
			if (max < maxSum[N - 1][i]) {
				max = maxSum[N - 1][i];
			}
			if (min > minSum[N - 1][i]) {
				min = minSum[N - 1][i];
			}
		}

		sb.append(max).append(" ").append(min);

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
