import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Point point = (Point)o;
			return r == point.r && c == point.c;
		}

		@Override
		public int hashCode() {
			return Objects.hash(r, c);
		}
	}

	private static int n, m, d;
	private static int[][] board;
	private static boolean[] archer;
	private static int[] dr = {0, -1, 0};
	private static int[] dc = {-1, 0, 1};
	private static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		board = new int[n + 1][m];
		archer = new boolean[m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(0, 0);

		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}

	private static void solve(int cnt, int idx) {
		if (cnt == 3) {
			int attackSum = 0;
			int[][] copyBoard = copyArr(board);

			for (int i = 0; i < m; i++) {
				if (archer[i]) {
					copyBoard[n][i] = 2;
				} else {
					copyBoard[n][i] = 0;
				}
			}

			for (int i = 0; i < n; i++) {
				attackSum += takeTurn(copyBoard[n], copyBoard);
			}

			if (answer < attackSum) {
				answer = attackSum;
			}
		}

		for (int i = idx; i < m; i++) {
			archer[i] = true;
			solve(cnt + 1, i + 1);
			archer[i] = false;
		}
	}

	private static int[][] copyArr(int[][] from) {
		int[][] to = new int[from.length][from[0].length];

		for (int i = 0; i < from.length; i++) {
			for (int j = 0; j < from[0].length; j++) {
				to[i][j] = from[i][j];
			}
		}

		return to;
	}

	private static int takeTurn(int[] archer, int[][] board) {
		int attackCntInTurn = attackTarget(archer, board);
		moveTarget(board);

		return attackCntInTurn;
	}

	private static int attackTarget(int[] archer, int[][] board) {
		List<Point> targets = new ArrayList<>();

		for (int i = 0; i < archer.length; i++) {
			if (archer[i] == 2) {
				Point target = findTarget(n, i, board);

				if (target != null && !targets.contains(target)) {
					targets.add(target);
				}
			}
		}

		for (Point p : targets) {
			board[p.r][p.c] = 0;
		}

		return targets.size();
	}

	private static Point findTarget(int startR, int startC, int[][] board) {
		Queue<Point> q = new LinkedList<>();
		int[][] dis = new int[n + 1][m];
		q.add(new Point(startR, startC));

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 3; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nc >= m || nr == n || dis[nr][nc] > 0) {
					continue;
				}
				if (dis[cur.r][cur.c] + 1 <= d && board[nr][nc] == 1) {
					return new Point(nr, nc);
				}

				q.add(new Point(nr, nc));
				dis[nr][nc] = dis[cur.r][cur.c] + 1;
			}
		}

		return null;
	}

	private static void moveTarget(int[][] board) {
		int[] tmp = new int[m];

		for (int i = n - 1; i >= 1; i--) {
			board[i] = board[i - 1];
		}
		board[0] = tmp;
	}
}
