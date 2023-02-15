import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		private int r;
		private int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M;
	static char[][] board;
	static boolean[][] vis;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];

		for (int i = 0; i < N; i++) {
			String row = br.readLine();

			for (int j = 0; j < M; j++) {
				board[i][j] = row.charAt(j);
			}
		}

		boolean hasCycle = false;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				vis = new boolean[N][M];
				vis[i][j] = true;
				hasCycle = solve(i, j, i, j, 1);

				if (hasCycle) {
					System.out.println("Yes");
					return;
				}
			}
		}

		System.out.println("No");
	}

	private static boolean solve(int startR, int startC, int curR, int curC, int cnt) {

		vis[curR][curC] = true;

		for (int i = 0; i < 4; i++) {
			int nr = curR + dr[i];
			int nc = curC + dc[i];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
				continue;
			}
			if (cnt >= 4 && nr == startR && nc == startC) {
				return true;
			}
			if (vis[nr][nc] || board[curR][curC] != board[nr][nc]) {
				continue;
			}

			if (solve(startR, startC, nr, nc, cnt + 1)) {
				return true;
			}
		}

		return false;
	}
}
