import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static class Point {
		int h, n, m;

		public Point(int h, int n, int m) {
			this.h = h;
			this.n = n;
			this.m = m;
		}
	}

	private static int m, n, h;
	private static int[][][] tomato;
	private static boolean[][][] visit;
	private static int[] dn = {0, 0, 0, 0, 1, -1};
	private static int[] dm = {0, 0, -1, 1, 0, 0};
	private static int[] dh = {-1, 1, 0, 0, 0, 0};
	private static Queue<Point> q = new LinkedList<>();
	private static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		tomato = new int[h][n][m];
		visit = new boolean[h][n][m];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());

				for (int k = 0; k < m; k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());

					if (tomato[i][j][k] == 1) {
						q.add(new Point(i, j, k));
						visit[i][j][k] = true;
					}
				}
			}
		}

		answer = search();
		answer = checkAllTomatoIsRipen();

		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}

	private static int search() {
		int time = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			boolean isRipen = false;

			for (int i = 0; i < size; i++) {
				Point now = q.poll();

				for (int j = 0; j < 6; j++) {
					int nextH = now.h + dh[j];
					int nextN = now.n + dn[j];
					int nextM = now.m + dm[j];

					if (nextH < 0 || nextN < 0 || nextM < 0 || nextH >= h || nextN >= n || nextM >= m) {
						continue;
					}
					if (tomato[nextH][nextN][nextM] == 1 || tomato[nextH][nextN][nextM] == -1 || visit[nextH][nextN][nextM]) {
						continue;
					}

					q.add(new Point(nextH, nextN, nextM));
					visit[nextH][nextN][nextM] = true;
					tomato[nextH][nextN][nextM] = 1;
					isRipen = true;
				}
			}

			if (isRipen) {
				time++;
			}
		}

		return time;
	}

	private static int checkAllTomatoIsRipen() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (tomato[i][j][k] == 0) {
						return -1;
					}
				}
			}
		}

		return answer;
	}
}
