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
		int r, c;
		boolean destroyed;

		public Point(int r, int c, boolean destroyed) {
			this.r = r;
			this.c = c;
			this.destroyed = destroyed;
		}
	}

	private static int n, m;
	private static int[][] map;
	private static boolean[][][] visit;
	private static int[] dr = {0, 1, 0, -1};
	private static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m + 1];
		visit = new boolean[n + 1][m + 1][2];

		for (int i = 1; i < n + 1; i++) {
			String row = br.readLine();

			for (int j = 1; j < m + 1; j++) {
				map[i][j] = row.charAt(j - 1) - '0';
			}
		}

		int answer = search();

		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}

	private static int search() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(1, 1, false));
		visit[1][1][0] = true;
		int answer = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			answer++;

			for (int i = 0; i < size; i++) {
				Point now = q.poll();

				if (now.r == n && now.c == m) {
					return answer;
				}

				for (int j = 0; j < 4; j++) {
					int nextR = now.r + dr[j];
					int nextC = now.c + dc[j];

					if (nextR < 1 || nextC < 1 || nextR > n || nextC > m) {
						continue;
					}

					if (map[nextR][nextC] == 0) { // 다음 칸이 이동할 수 있는 경우
						if (!now.destroyed && !visit[nextR][nextC][0]) { // 이전에 벽을 부순 적 없는 경우
							q.add(new Point(nextR, nextC, false));
							visit[nextR][nextC][0] = true;
						} else if (now.destroyed && !visit[nextR][nextC][1]) { // 이전에 벽을 부순 적 있는 경우
							q.add(new Point(nextR, nextC, true));
							visit[nextR][nextC][1] = true;
						}
					} else { // 다음 칸이 벽인 경우
						if (now.destroyed || visit[nextR][nextC][1]) { // 이전에 벽을 부순 적 있는 경우
							continue;
						}

						q.add(new Point(nextR, nextC, true));
						visit[nextR][nextC][1] = true;
					}
				}
			}
		}

		return -1;
	}
}
