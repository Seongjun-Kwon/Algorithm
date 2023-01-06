import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static double[] percent;
	static boolean[][] vis;
	static int[] dr = {0, 0, 1, -1}; // 동 서 남 북
	static int[] dc = {1, -1, 0, 0};
	static double ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		percent = new double[4];
		vis = new boolean[2 * N + 1][2 * N + 1];

		for (int i = 0; i < 4; i++) {
			percent[i] = Double.parseDouble(st.nextToken()) * 0.01;
		}

		vis[N][N] = true;
		dfs(N, N, 0, 1);

		bw.write(String.valueOf(ans));
		br.close();
		bw.flush();
		bw.close();

	}

	private static void dfs(int curR, int curC, int cnt, double sum) {
		if (cnt == N) {
			ans += sum;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = curR + dr[i];
			int nc = curC + dc[i];

			if (nr < 0 || nc < 0 || nr >= 2 * N + 1 || nc >= 2 * N + 1) {
				continue;
			}
			if (vis[nr][nc]) {
				continue;
			}

			vis[nr][nc] = true;
			dfs(nr, nc, cnt + 1, sum * percent[i]);
			vis[nr][nc] = false;
		}
	}
}
