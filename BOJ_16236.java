import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point implements Comparable<Point> {
		int r;
		int c;
		int dis;

		public Point(int r, int c, int dis) {
			this.r = r;
			this.c = c;
			this.dis = dis;
		}

		@Override
		public int compareTo(Point o) {
			if (this.dis == o.dis) {
				if (this.r == o.r) {
					return this.c - o.c;
				} else {
					return this.r - o.r;
				}
			} else {
				return this.dis - o.dis;
			}
		}
	}

	static int N;
	static int[][] space;
	static boolean[][] vis;
	static int[] dr = {-1, 0, 0, 1}; // 상 좌 우 하
	static int[] dc = {0, -1, 1, 0};
	static int startR, startC;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		space = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());

				if (space[i][j] == 9) {
					startR = i;
					startC = j;
				}
			}
		}

		solve(startR, startC, 2);

		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}

	private static void solve(int startR, int startC, int size) {

		int eatCnt = 0;
		int time = 0;
		boolean canEat = true;

		while (canEat) {
			canEat = false;
			Queue<Point> q = new LinkedList<>();
			PriorityQueue<Point> pq = new PriorityQueue<>();
			q.add(new Point(startR, startC, 0));
			space[startR][startC] = 0;
			vis = new boolean[N][N];
			vis[startR][startC] = true;

			while (!q.isEmpty()) {
				Point cur = q.poll();

				for (int i = 0; i < 4; i++) {
					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];

					if (nr < 0 || nc < 0 || nr >= N || nc >= N || vis[nr][nc] || space[nr][nc] > size) {
						continue;
					}

					if (space[nr][nc] != 0 && space[nr][nc] < size) {
						pq.add(new Point(nr, nc, cur.dis + 1));
					} else {
						q.add(new Point(nr, nc, cur.dis + 1));
						vis[nr][nc] = true;
					}
				}
			}

			if (!pq.isEmpty()) {
				Point fish = pq.poll();
				startR = fish.r;
				startC = fish.c;
				time += fish.dis;
				eatCnt++;
				canEat = true;
			}
			if (size == eatCnt) {
				size++;
				eatCnt = 0;
			}
			answer = time;
		}
	}
}
